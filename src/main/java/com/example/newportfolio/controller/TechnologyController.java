package com.example.newportfolio.controller;

import com.example.newportfolio.exception.TechnologyNameUniqueException;
import com.example.newportfolio.exception.TechnologyNotFoundException;
import com.example.newportfolio.model.Technology;
import com.example.newportfolio.service.TechnologyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/technologies")
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("technologyList", technologyService.getAll());
        model.addAttribute("technologyObj", new Technology());
        return "technologies/index";
    }

    @PostMapping
    public String doSave(@Valid @ModelAttribute("technologyObj") Technology formTechnology, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "technologies/index";
        }
        try {
            technologyService.save(formTechnology);
            return "redirect:/technologies";
        } catch (TechnologyNameUniqueException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "A technology with name " + e.getMessage() + " already exist!");
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            Technology technologyToDelete = technologyService.getTechnology(id);
            technologyService.deleteTechnology(technologyToDelete.getId());
            redirectAttributes.addFlashAttribute("message", "Technology delete!");
            return "redirect:/technologies";
        } catch (TechnologyNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}