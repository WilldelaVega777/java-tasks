//------------------------------------------------------------------------------------
// Package Section
//------------------------------------------------------------------------------------
package com.hexagonal.tasks.application.usecases;

//------------------------------------------------------------------------------------
// Imports Section
//------------------------------------------------------------------------------------


import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.in.IUpdateTaskUseCase;
import com.hexagonal.tasks.domain.ports.out.ITaskRepositoryPort;

import java.util.Optional;

//------------------------------------------------------------------------------------
// Class Implementation Section
//------------------------------------------------------------------------------------
public class UpdateTaskUseCaseImpl implements IUpdateTaskUseCase {
    //--------------------------------------------------------------------------------
    // Constants Section
    //--------------------------------------------------------------------------------
    private final ITaskRepositoryPort taskRepositoryPort;

    //--------------------------------------------------------------------------------
    // Constructor Method Section
    //--------------------------------------------------------------------------------
    public UpdateTaskUseCaseImpl(ITaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    //--------------------------------------------------------------------------------
    // Public Methods Section
    //--------------------------------------------------------------------------------
    @Override
    public Optional<Task> updateTask(Long pId, Task pUpdatedTask) {
        return this.taskRepositoryPort.updateTask(pUpdatedTask);
    }
}
