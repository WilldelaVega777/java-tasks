//------------------------------------------------------------------------------------
// Package Section
//------------------------------------------------------------------------------------
package com.hexagonal.tasks.application.usecases;

//------------------------------------------------------------------------------------
// Imports Section
//------------------------------------------------------------------------------------
import com.hexagonal.tasks.domain.ports.in.IDeleteTaskUseCase;
import com.hexagonal.tasks.domain.ports.out.ITaskRepositoryPort;

//------------------------------------------------------------------------------------
// Class Implementation Section
//------------------------------------------------------------------------------------
public class DeleteTaskUseCaseImpl implements IDeleteTaskUseCase {
    //--------------------------------------------------------------------------------
    // Constants Section
    //--------------------------------------------------------------------------------
    private final ITaskRepositoryPort taskRepositoryPort;

    //--------------------------------------------------------------------------------
    // Constructor Method Section
    //--------------------------------------------------------------------------------
    public DeleteTaskUseCaseImpl(ITaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    //--------------------------------------------------------------------------------
    // Public Methods Section
    //--------------------------------------------------------------------------------
    @Override
    public Boolean deleteTask(Long pId) {
        return taskRepositoryPort.deleteById(pId);
    }
}
