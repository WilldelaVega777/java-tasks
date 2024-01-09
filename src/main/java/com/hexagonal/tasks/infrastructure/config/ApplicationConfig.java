//------------------------------------------------------------------------------------
// Package Section
//------------------------------------------------------------------------------------
package com.hexagonal.tasks.infrastructure.config;

//------------------------------------------------------------------------------------
// Imports Section
//------------------------------------------------------------------------------------
import com.hexagonal.tasks.application.services.TaskService;
import com.hexagonal.tasks.application.usecases.*;
import com.hexagonal.tasks.domain.ports.in.IGetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.ports.out.IExternalServicePort;
import com.hexagonal.tasks.domain.ports.out.ITaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.adapters.ExternalServiceAdapter;
import com.hexagonal.tasks.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//------------------------------------------------------------------------------------
// Class Definition Section
//------------------------------------------------------------------------------------
@Configuration
public class ApplicationConfig {
    @Bean
    public TaskService taskService(
            ITaskRepositoryPort pTaskRepositoryPort,
            IGetAdditionalTaskInfoUseCase pGetAdditionalTaskInfoUseCase
    ) {
        return new TaskService(
                new CreateTaskUseCaseImpl(pTaskRepositoryPort),
                new DeleteTaskUseCaseImpl(pTaskRepositoryPort),
                new RetrieveTaskUseCaseImpl(pTaskRepositoryPort),
                new UpdateTaskUseCaseImpl(pTaskRepositoryPort),
                pGetAdditionalTaskInfoUseCase
        );
    }

    @Bean
    @Primary
    public ITaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public IGetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(IExternalServicePort pExternalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(pExternalServicePort);
    }

    @Bean
    public IExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }
}
