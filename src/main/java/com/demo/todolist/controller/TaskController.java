package com.demo.todolist.controller;

import com.demo.todolist.entity.Task;
import com.demo.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Spring controller class that handles work with task repository (database)
 * and model/view in browser.
 *
 * @author Stefan Sidlovsky
 */
@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping({"/", "/tasks"})
    public ModelAndView getAllTasks() {
        ModelAndView modelAndView = new ModelAndView("tasks-list"); //viewName is the name of .html template
        List<Task> tasks = taskRepository.findAll();
        modelAndView.addObject("tasks", tasks);
        return modelAndView;
    }

    @GetMapping(value = "/newTaskForm")
    public ModelAndView newTaskForm() {
        ModelAndView modelAndView = new ModelAndView("task-form");
        Task newTask = new Task();
        modelAndView.addObject("task", newTask);
        return modelAndView;
    }

    @PostMapping(value = "/saveTask")
    public String saveTask(@ModelAttribute Task task) {
        taskRepository.save(task);
        return "redirect:/tasks";
    }

    @GetMapping(value = "/updateForm")
    public ModelAndView updateForm(@RequestParam Long taskId) {
        ModelAndView modelAndView = new ModelAndView("task-form");
        Task task = taskRepository.findById(taskId).get();
        modelAndView.addObject("task", task);
        return modelAndView;
    }

    @GetMapping(value = "/finishTask")
    public String finishTask(@RequestParam Long taskId) {
        taskRepository.deleteById(taskId);
        return "redirect:/tasks";
    }
}
