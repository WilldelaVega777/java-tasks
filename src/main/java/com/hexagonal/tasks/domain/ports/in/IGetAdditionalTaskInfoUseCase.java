//------------------------------------------------------------------------------------
// Package Section
//------------------------------------------------------------------------------------
package com.hexagonal.tasks.domain.ports.in;

//------------------------------------------------------------------------------------
// Imports Section
//------------------------------------------------------------------------------------
import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;

//------------------------------------------------------------------------------------
// Interface Definition Section
//------------------------------------------------------------------------------------
public interface IGetAdditionalTaskInfoUseCase {
    public AdditionalTaskInfo getAdditionalTaskInfo(Long pId);
}
