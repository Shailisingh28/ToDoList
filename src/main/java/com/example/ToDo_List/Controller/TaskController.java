package com.example.ToDo_List.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ToDo_List.Model.Task;
import com.example.ToDo_List.Service.TaskService;

@Controller
public class TaskController {
    TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Task> tasks = service.getAll();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping
    public String addTask(@RequestParam String title) {
        service.addTask(title);
        return ("redirect:/");
    }

    @GetMapping("/{id}/delete")
    public String deletetask(@PathVariable Long id) {
        service.deletetask(id);
        return "redirect:/";// to refresh the page
    }

    @GetMapping("/{id}/toggle")
    public String toggle(@PathVariable Long id) {
        service.toggle(id);
        return "redirect:/";
    }
}
