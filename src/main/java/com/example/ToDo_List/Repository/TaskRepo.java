package com.example.ToDo_List.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ToDo_List.Model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

}
