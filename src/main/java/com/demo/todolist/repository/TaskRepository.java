package com.demo.todolist.repository;


import com.demo.todolist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is jpa interface that provides pre-defined methods to work with database.
 *
 * @author Stefan Sidlovsky
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
