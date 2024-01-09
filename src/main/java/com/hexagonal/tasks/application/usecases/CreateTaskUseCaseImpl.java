//------------------------------------------------------------------------------------
// Package Section
//------------------------------------------------------------------------------------
package com.hexagonal.tasks.application.usecases;

//------------------------------------------------------------------------------------
// Imports Section
//------------------------------------------------------------------------------------
import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.in.ICreateTaskUseCase;
import com.hexagonal.tasks.domain.ports.out.ITaskRepositoryPort;

//------------------------------------------------------------------------------------
// Class Implementation Section
//------------------------------------------------------------------------------------
public class CreateTaskUseCaseImpl implements ICreateTaskUseCase {
    //--------------------------------------------------------------------------------
    // Constants Section
    //--------------------------------------------------------------------------------
    private final ITaskRepositoryPort taskRepositoryPort;

    //--------------------------------------------------------------------------------
    // Constructor Method Section
    //--------------------------------------------------------------------------------
    public CreateTaskUseCaseImpl(ITaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    //--------------------------------------------------------------------------------
    // Public Methods Section
    //--------------------------------------------------------------------------------
    @Override
    public Task createTask(Task pTask) {
        return taskRepositoryPort.save(pTask);
    }
}
