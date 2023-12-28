package com.example.newportfolio.dto;

import com.example.newportfolio.model.Technology;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public class ProjectDto {
    private Integer id;
    @NotBlank(message = "Title must be not blank!")
    @Size(max = 255, message = "Length must be less than 255!")
    private String title;
    @NotBlank(message = "Image must be not blank!")
    private String image;
    @NotBlank(message = "Description must be not blank!")
    @Size(max = 255, message = "Length must be less than 255!")
    private String description;

    private MultipartFile cover;
    private List<Technology> technologyList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getCover() {
        return cover;
    }

    public void setCover(MultipartFile cover) {
        this.cover = cover;
    }

    public List<Technology> getTechnologyList() {
        return technologyList;
    }

    public void setTechnologyList(List<Technology> technologyList) {
        this.technologyList = technologyList;
    }
}