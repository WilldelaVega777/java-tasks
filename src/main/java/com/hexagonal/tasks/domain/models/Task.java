//--------------------------------------------------------------------------------------
// Package Section
//--------------------------------------------------------------------------------------
package com.hexagonal.tasks.domain.models;

//--------------------------------------------------------------------------------------
// Imports Section
//--------------------------------------------------------------------------------------
import java.time.LocalDateTime;

//--------------------------------------------------------------------------------------
// Class Definition Section
//--------------------------------------------------------------------------------------
public class Task {
    //----------------------------------------------------------------------------------
    // Private Fields Section
    //----------------------------------------------------------------------------------
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private Boolean completed;

    //----------------------------------------------------------------------------------
    // Constructor Method Section
    //----------------------------------------------------------------------------------
    public Task(
            Long pId,
            String pTitle,
            String pDescription,
            LocalDateTime pCreationDate,
            Boolean pCompleted
    ) {
        this.id = pId;
        this.title = pTitle;
        this.description = pDescription;
        this.creationDate = pCreationDate;
        this.completed = pCompleted;
    }

    //----------------------------------------------------------------------------------
    // Public Properties Section
    //----------------------------------------------------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
