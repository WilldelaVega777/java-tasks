//------------------------------------------------------------------------------------
// Package Section
//------------------------------------------------------------------------------------
package com.hexagonal.tasks.infrastructure.repositories;

//------------------------------------------------------------------------------------
// Imports Section
//------------------------------------------------------------------------------------
import com.hexagonal.tasks.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//------------------------------------------------------------------------------------
// Repository Class Definition Section
//------------------------------------------------------------------------------------
@Repository
public interface IJpaTaskRepository extends JpaRepository<TaskEntity, Long> {}
