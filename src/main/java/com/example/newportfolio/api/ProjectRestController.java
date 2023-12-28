package com.example.newportfolio.api;

import com.example.newportfolio.exception.ProjectNotFoundException;
import com.example.newportfolio.model.Project;
import com.example.newportfolio.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/projects")
@CrossOrigin
public class ProjectRestController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> index(@RequestParam Optional<String> search) throws RuntimeException {
        try {
            System.out.println("Sono stato chiamato");
            return projectService.getProjectList();
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Project show(@PathVariable Integer id) {
        try {
            return projectService.getProjectById(id);
        } catch (ProjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public Project create(@Valid @RequestBody Project project) {
        try {
            return projectService.createProject(project);
        } catch (ProjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Project update(@PathVariable Integer id, @Valid @RequestBody Project project) {
        project.setId(id);
        try {
            return projectService.editProject(project);
        } catch (ProjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        try {
            Project projectToDelete = projectService.getProjectById(id);
            projectService.deleteProject(id);
        } catch (ProjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}