package com.tat.development.skills.repository;

import com.tat.development.skills.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TaskRepository.
 * This interface using for operations with user's tasks entities.
 * @author Aydar_Safiullin
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
