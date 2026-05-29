package com.viniciusdev.crud.repository;

import com.viniciusdev.crud.model.TasksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TasksRepository extends JpaRepository<TasksModel, UUID> {
}
