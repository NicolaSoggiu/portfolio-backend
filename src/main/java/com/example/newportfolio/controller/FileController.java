package com.example.newportfolio.controller;

import com.example.newportfolio.exception.ProjectNotFoundException;
import com.example.newportfolio.model.Project;
import com.example.newportfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/files")
public class FileController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/cover/{projectId}")
    public ResponseEntity<byte[]> serveCover(@PathVariable Integer projectId) {
        try {
            Project project = projectService.getProjectById(projectId);
            byte[] coverBytes = project.getCover();
            if (coverBytes != null && coverBytes.length > 0) {
                MediaType mediaType = MediaType.IMAGE_JPEG;
                return ResponseEntity.ok().contentType(mediaType).body(coverBytes);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (ProjectNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}