package com.example.newportfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Title must be not blank!")
    @Size(max = 255, message = "Length must be less than 255!")
    @Column(unique = true)
    private String title;
    @NotBlank(message = "Image must be not blank!")
    @Column(nullable = false)
    private String image;
    @Column(nullable = false, length = 5000)
    @NotBlank(message = "Description must be not blank!")
    @Size(max = 5000, message = "Length must be less than 5000!")
    private String description;
    @Column(nullable = true)
    private String git;
    @Column(nullable = true)
    private String link;
    @CreationTimestamp
    private LocalDate createdAt;

    @Lob
    @Column(length = 16777215)
    @JsonIgnore
    private byte[] cover;
    @ManyToMany(fetch = FetchType.LAZY)
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

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public List<Technology> getTechnologyList() {
        return technologyList;
    }

    public void setTechnologyList(List<Technology> technologyList) {
        this.technologyList = technologyList;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }
}