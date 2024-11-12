package com.todoexample.todo.controller;

import com.todoexample.todo.entity.Task;
import com.todoexample.todo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

@GetMapping
    public String getTasks(Model model) {
        List<Task> tasks =  todoService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }
}