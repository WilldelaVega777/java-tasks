//------------------------------------------------------------------------------------
// Package Section
//------------------------------------------------------------------------------------
package com.hexagonal.tasks.domain.ports.out;

//------------------------------------------------------------------------------------
// Imports Section
//------------------------------------------------------------------------------------
import com.hexagonal.tasks.domain.models.Task;
import java.util.List;
import java.util.Optional;

//------------------------------------------------------------------------------------
// Interface Definition Section
//------------------------------------------------------------------------------------
public interface ITaskRepositoryPort {
    Task save(Task pTask);
    List<Task> findAll();
    Optional<Task> findById(Long pId);
    Optional<Task> updateTask(Task pUpdatedTask);
    Boolean deleteById(Long pId);
}
