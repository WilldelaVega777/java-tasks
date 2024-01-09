//------------------------------------------------------------------------------------
// Package Section
//------------------------------------------------------------------------------------
package com.hexagonal.tasks.application.usecases;

//------------------------------------------------------------------------------------
// Imports Section
//------------------------------------------------------------------------------------

import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.ports.in.IGetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.ports.out.IExternalServicePort;
import com.hexagonal.tasks.domain.ports.out.ITaskRepositoryPort;

//------------------------------------------------------------------------------------
// Class Implementation Section
//------------------------------------------------------------------------------------
public class GetAdditionalTaskInfoUseCaseImpl implements IGetAdditionalTaskInfoUseCase {
    //--------------------------------------------------------------------------------
    // Constants Section
    //--------------------------------------------------------------------------------
    private final IExternalServicePort externalServicePort;

    //--------------------------------------------------------------------------------
    // Constructor Method Section
    //--------------------------------------------------------------------------------
    public GetAdditionalTaskInfoUseCaseImpl(IExternalServicePort pExternalServicePort) {
        this.externalServicePort = pExternalServicePort;
    }

    //--------------------------------------------------------------------------------
    // Public Methods Section
    //--------------------------------------------------------------------------------
    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long pId) {
        return this.externalServicePort.getAdditionalTaskInfo(pId);
    }

    public IExternalServicePort getExternalServicePort() {
        return externalServicePort;
    }
}
