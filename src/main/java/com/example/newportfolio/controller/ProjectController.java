package com.example.newportfolio.controller;

import com.example.newportfolio.dto.ProjectDto;
import com.example.newportfolio.exception.ProjectNotFoundException;
import com.example.newportfolio.model.Project;
import com.example.newportfolio.service.ProjectService;
import com.example.newportfolio.service.TechnologyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    TechnologyService technologyService;
    @GetMapping
    public String index(@RequestParam Optional<String> search, Model model) {
        model.addAttribute("projectList", projectService.getProjectList(search));
        return "projects/index";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        try {
            Project project = projectService.getProjectById(id);
            model.addAttribute("project", project);
            return "projects/show";
        } catch (ProjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("project", new ProjectDto());
        model.addAttribute("technologyList", technologyService.getAll());
        return "projects/form";
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("project") ProjectDto formProject, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("technologyList", technologyService.getAll());
            return "projects/form";
        }
        try {
            Project savedProject = projectService.createProject(formProject);
            return "redirect:/projects/show/" + savedProject.getId();
        } catch (ProjectNotFoundException e) {
            bindingResult.addError(new FieldError("project", "title", e.getMessage(), false, null, null, "Title must be unique"));
            return "projects/form";
        } catch (IOException e) {
            bindingResult.addError(new FieldError("project", "coverFile", null, false, null, null, "Unable to save file"));
            return "projects/form";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute("project", projectService.getProjectDtoById(id));
            model.addAttribute("technologyList", technologyService.getAll());
            return "projects/form";
        } catch (ProjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Integer id, @Valid @ModelAttribute("project") ProjectDto formProject, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("technologyList", technologyService.getAll());
            return "projects/form";
        }
        try {
            Project savedProject = projectService.editProject(formProject);
            return "redirect:/projects/show/" + savedProject.getId();
        } catch (ProjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (IOException e) {
            bindingResult.addError(new FieldError("project", "coverFile", null, false, null, null,
                    "Unable to save file"));
            return "projects/form";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            Project projectToDelete = projectService.getProjectById(id);
            projectService.deleteProject(id);
            redirectAttributes.addFlashAttribute("message", "Project " + projectToDelete.getTitle() + " deleted!");
            return "redirect:/projects";
        } catch (ProjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}