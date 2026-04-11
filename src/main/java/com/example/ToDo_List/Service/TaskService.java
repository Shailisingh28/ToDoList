package com.example.ToDo_List.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ToDo_List.Model.Task;
import com.example.ToDo_List.Repository.TaskRepo;

@Service
public class TaskService {
    TaskRepo repo;

    public TaskService(TaskRepo repo) {
        this.repo = repo;
    }

    public List<Task> getAll() {
        return repo.findAll();
    }

    public void addTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        repo.save(task);
    }

    public String deletetask(Long id) {
        Optional<Task> task = repo.findById(id);
        if (task.isPresent()) {
            repo.deleteById(id);
            return "deleted";
        }
        return "Not found";
    }

    public void toggle(Long id) {
        Task task = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid request"));
        task.setCompleted(!task.isCompleted());
        repo.save(task);
    }
}
