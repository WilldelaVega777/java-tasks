//------------------------------------------------------------------------------------
// Package Section
//------------------------------------------------------------------------------------
package com.hexagonal.tasks.infrastructure.repositories;

//------------------------------------------------------------------------------------
// Imports Section
//------------------------------------------------------------------------------------

import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.out.ITaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.entities.TaskEntity;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

//------------------------------------------------------------------------------------
// Interface Definition Section
//------------------------------------------------------------------------------------
@Component
public class JpaTaskRepositoryAdapter implements ITaskRepositoryPort {
    //--------------------------------------------------------------------------------
    // Constants Section
    //--------------------------------------------------------------------------------
    private final IJpaTaskRepository jpaTaskRepository;

    //--------------------------------------------------------------------------------
    // Constructor Method Section
    //--------------------------------------------------------------------------------
    public JpaTaskRepositoryAdapter(IJpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    //--------------------------------------------------------------------------------
    // Public Methods Section
    //--------------------------------------------------------------------------------
    @Override
    public List<Task> findAll() {
        return this.jpaTaskRepository.findAll()
                .stream()
                .map(TaskEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Task> findById(Long pId) {
        return jpaTaskRepository.findById(pId).map(TaskEntity::toDomainModel);
    }

    @Override
    public Task save(Task pTask) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(pTask);
        TaskEntity savedTaskEntity = this.jpaTaskRepository.save(taskEntity);
        return savedTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Task> updateTask(Task pUpdatedTask) {
        if (jpaTaskRepository.existsById(pUpdatedTask.getId())) {
            TaskEntity taskEntity = TaskEntity.fromDomainModel(pUpdatedTask);
            TaskEntity updatedTaskEntity = jpaTaskRepository.save(taskEntity);
            return Optional.of(updatedTaskEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteById(Long pId) {
        if (jpaTaskRepository.existsById(pId)) {
            jpaTaskRepository.deleteById(pId);
            return true;
        }
        return false;
    }
}
