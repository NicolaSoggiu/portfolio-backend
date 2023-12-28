package com.example.newportfolio.service;

import com.example.newportfolio.dto.ProjectDto;
import com.example.newportfolio.exception.ProjectNameUniqueException;
import com.example.newportfolio.exception.ProjectNotFoundException;
import com.example.newportfolio.model.Project;
import com.example.newportfolio.repository.ProjectRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.unbescape.properties.PropertiesKeyEscapeLevel;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getProjectList(Optional<String> search) {
        if (search.isPresent()) {
            return projectRepository.findByTitleContainingIgnoreCase(search.get());
        } else {
            return projectRepository.findAll();
        }
    }

    public List<Project> getProjectList() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Integer id) throws ProjectNotFoundException {
        Optional<Project> result = projectRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ProjectNotFoundException("Project with id " + id + " not found!");
        }
    }

    public Project createProject(Project project) throws ProjectNameUniqueException {
        project.setId(null);
        try {
            return projectRepository.save(project);
        } catch (RuntimeException e) {
            throw new ProjectNameUniqueException("Project with this name already exist!");
        }
    }

    public Project createProject(ProjectDto projectDto) throws IOException, ProjectNameUniqueException {
        Project project = convertDtoToBook(projectDto);
        return createProject(project);
    }

    private static Project convertDtoToBook(ProjectDto projectDto) throws IOException {
        Project project = new Project();
        project.setId(projectDto.getId());
        project.setTitle(projectDto.getTitle());
        project.setDescription(projectDto.getDescription());
        project.setImage(projectDto.getImage());
        project.setTechnologyList(projectDto.getTechnologyList());
        if (projectDto.getCover() != null && !projectDto.getCover().isEmpty()) {
            byte[] bytes = projectDto.getCover().getBytes();
            project.setCover(bytes);
        }
        return project;
    }

    private static ProjectDto convertProjectToDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setTitle(project.getTitle());
        projectDto.setDescription(project.getDescription());
        projectDto.setImage(project.getImage());
        projectDto.setTechnologyList(project.getTechnologyList());
        return projectDto;
    }

    public ProjectDto getProjectDtoById(Integer id) throws ProjectNotFoundException {
        Project project = getProjectById(id);
        return convertProjectToDto(project);
    }

    public Project editProject(Project project) throws ProjectNotFoundException {
        Project projectToEdit = getProjectById(project.getId());
        projectToEdit.setTitle(project.getTitle());
        projectToEdit.setDescription(project.getDescription());
        projectToEdit.setImage(project.getImage());
        projectToEdit.setTechnologyList(project.getTechnologyList());
        if (project.getCover() != null && project.getCover().length > 0) {
            projectToEdit.setCover(project.getCover());
        }
        return projectRepository.save(projectToEdit);
    }

    public Project editProject(ProjectDto projectDto) throws IOException {
        Project project = convertDtoToBook(projectDto);
        return editProject(project);
    }

    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }
}