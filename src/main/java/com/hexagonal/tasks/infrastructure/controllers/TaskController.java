//------------------------------------------------------------------------------------
// Package Section
//------------------------------------------------------------------------------------
package com.hexagonal.tasks.infrastructure.controllers;

//------------------------------------------------------------------------------------
// Imports Section
//------------------------------------------------------------------------------------
import com.hexagonal.tasks.application.services.TaskService;
import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//------------------------------------------------------------------------------------
// Controller Class Definition Section
//------------------------------------------------------------------------------------
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    //--------------------------------------------------------------------------------
    // Constants Section
    //--------------------------------------------------------------------------------
    private final TaskService taskService;

    //--------------------------------------------------------------------------------
    // Constructor Method Section
    //--------------------------------------------------------------------------------
    TaskController(TaskService pTaskService) {
        this.taskService = pTaskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task pTask) {
        Task createdTask = this.taskService.createTask(pTask);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> GetTaskById(@PathVariable Long pId)
    {
        return this.taskService.getTaskById(pId)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = this.taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long pTaskId, @RequestBody Task pUpdateTask) {
        return this.taskService.updateTask(pTaskId, pUpdateTask)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTask(@PathVariable Long pTaskId) {
        if (taskService.deleteTask(pTaskId))
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{taskId}/additionalInfo")
    public ResponseEntity<AdditionalTaskInfo> getAdditionalTaskInfo(@PathVariable Long pId)
    {
        AdditionalTaskInfo additionalTaskInfo = this.taskService.getAdditionalTaskInfo(pId);
        return new ResponseEntity<>(additionalTaskInfo, HttpStatus.OK);
    }
}
