//------------------------------------------------------------------------------------
// Package Section
//------------------------------------------------------------------------------------
package com.hexagonal.tasks.domain.ports.in;

//------------------------------------------------------------------------------------
// Imports Section
//------------------------------------------------------------------------------------
import com.hexagonal.tasks.domain.models.Task;

import java.util.List;
import java.util.Optional;

//------------------------------------------------------------------------------------
// Interface Definition Section
//------------------------------------------------------------------------------------
public interface IRetrieveTaskUseCase {
    Optional<Task> getTaskById(Long pId);
    List<Task> getAllTasks();
}
