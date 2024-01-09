//------------------------------------------------------------------------------------
// Package Section
//------------------------------------------------------------------------------------
package com.hexagonal.tasks.application.usecases;

//------------------------------------------------------------------------------------
// Imports Section
//------------------------------------------------------------------------------------
import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.in.IRetrieveTaskUseCase;
import com.hexagonal.tasks.domain.ports.out.ITaskRepositoryPort;

import java.util.List;
import java.util.Optional;

//------------------------------------------------------------------------------------
// Class Implementation Section
//------------------------------------------------------------------------------------
public class RetrieveTaskUseCaseImpl implements IRetrieveTaskUseCase {
    //--------------------------------------------------------------------------------
    // Constants Section
    //--------------------------------------------------------------------------------
    private final ITaskRepositoryPort taskRepositoryPort;

    //--------------------------------------------------------------------------------
    // Constructor Method Section
    //--------------------------------------------------------------------------------
    public RetrieveTaskUseCaseImpl(ITaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    //--------------------------------------------------------------------------------
    // Public Methods Section
    //--------------------------------------------------------------------------------
    @Override
    public Optional<Task> getTaskById(Long pId) {
        return this.taskRepositoryPort.findById(pId);
    }

    public List<Task> getAllTasks()
    {
        return this.taskRepositoryPort.findAll();
    }
}
