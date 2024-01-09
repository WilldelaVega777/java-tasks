//------------------------------------------------------------------------------------
// Package Section
//------------------------------------------------------------------------------------
package com.hexagonal.tasks.infrastructure.entities;

//------------------------------------------------------------------------------------
// Imports Section
//------------------------------------------------------------------------------------
import com.hexagonal.tasks.domain.models.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

//------------------------------------------------------------------------------------
// Entity Class Definition Section
//------------------------------------------------------------------------------------
@Entity
public class TaskEntity {
    //--------------------------------------------------------------------------------
    // Private Fields Section
    //--------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private Boolean completed;

    //--------------------------------------------------------------------------------
    // Constructor Methods Section
    //--------------------------------------------------------------------------------
    public TaskEntity() {}

    public TaskEntity(
            Long pId,
            String pTitle,
            String pDescription,
            LocalDateTime pCreationDate,
            Boolean pCompleted
    )
    {
        this.id = pId;
        this.title = pTitle;
        this.description = pDescription;
        this.creationDate = pCreationDate;
        this.completed = pCompleted;
    }

    //--------------------------------------------------------------------------------
    // Static Class Mappers Section
    //--------------------------------------------------------------------------------
    public static TaskEntity fromDomainModel(Task pTask) {
        return new TaskEntity(
                pTask.getId(),
                pTask.getTitle(),
                pTask.getDescription(),
                pTask.getCreationDate(),
                pTask.getCompleted()
        );
    }

    //--------------------------------------------------------------------------------
    public Task toDomainModel() {
        return new Task(id, title, description, creationDate, completed);
    }

    //--------------------------------------------------------------------------------
    // Public Properties Section
    //--------------------------------------------------------------------------------
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
