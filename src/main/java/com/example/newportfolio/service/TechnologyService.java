package com.example.newportfolio.service;

import com.example.newportfolio.exception.TechnologyNameUniqueException;
import com.example.newportfolio.exception.TechnologyNotFoundException;
import com.example.newportfolio.model.Project;
import com.example.newportfolio.model.Technology;
import com.example.newportfolio.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyService {
    @Autowired
    private TechnologyRepository technologyRepository;

    public List<Technology> getAll() {
        return technologyRepository.findByOrderByName();
    }

    public Technology save(Technology technology) throws TechnologyNameUniqueException {
        if (technologyRepository.existsByName(technology.getName())) {
            throw new TechnologyNameUniqueException(technology.getName());
        }
        technology.setName(technology.getName().toLowerCase());
        return technologyRepository.save(technology);
    }

    public Technology getTechnology(Integer id) throws TechnologyNotFoundException {
        return technologyRepository.findById(id).orElseThrow(()->
                new TechnologyNotFoundException("Technology with id " + id + " not found!"));
    }

    public void deleteTechnology(Integer id) {
        Technology technologyToDelete = getTechnology(id);
        List<Project> projects = technologyToDelete.getProjects();
        if (projects.size() > 0) {
            for (Project project : projects) {
                List<Technology> technologies = project.getTechnologyList();
                technologies.remove(technologyToDelete);
            }
            technologyToDelete.setProjects(new ArrayList<>());
        }
        technologyRepository.deleteById(id);
    }
}