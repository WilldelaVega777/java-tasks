//------------------------------------------------------------------------------------
// Package Section
//------------------------------------------------------------------------------------
package com.hexagonal.tasks.application.services;

//------------------------------------------------------------------------------------
// Imports Section
//------------------------------------------------------------------------------------
import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.in.*;
import java.util.Optional;
import java.util.List;

//------------------------------------------------------------------------------------
// Class Definition Section
//------------------------------------------------------------------------------------
public class TaskService implements
        ICreateTaskUseCase,
        IDeleteTaskUseCase,
        IGetAdditionalTaskInfoUseCase,
        IRetrieveTaskUseCase,
        IUpdateTaskUseCase
{
    //----------------------------------------------------------------------------------
    // Constants Section
    //----------------------------------------------------------------------------------
    private final ICreateTaskUseCase createTaskUseCase;
    private final IDeleteTaskUseCase deleteTaskUseCase;
    private final IGetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;
    private final IRetrieveTaskUseCase retrieveTaskUseCase;
    private final IUpdateTaskUseCase updateTaskUseCase;

    //----------------------------------------------------------------------------------
    // Constructor Method Section
    //----------------------------------------------------------------------------------
    public TaskService(
           ICreateTaskUseCase createTaskUseCase,
           IDeleteTaskUseCase deleteTaskUseCase,
           IRetrieveTaskUseCase retrieveTaskUseCase,
           IUpdateTaskUseCase updateTaskUseCase,
           IGetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase
    ) {
        this.createTaskUseCase = createTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }

    //----------------------------------------------------------------------------------
    // Public Methods Section
    //----------------------------------------------------------------------------------
    @Override
    public Task createTask(Task pTask) {
        return createTaskUseCase.createTask(pTask);
    }

    @Override
    public Boolean deleteTask(Long pId) {
        return deleteTaskUseCase.deleteTask(pId);
    }

    @Override
    public Optional<Task> getTaskById(Long pId) {
        return retrieveTaskUseCase.getTaskById(pId);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long pId, Task pUpdatedTask) {
        return updateTaskUseCase.updateTask(pId, pUpdatedTask);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long pId) {
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(pId);
    }
}
