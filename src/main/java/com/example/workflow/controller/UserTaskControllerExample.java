package com.example.workflow.controller;

import com.example.workflow.delegate.user_task.UserTaskService;
import com.example.workflow.dto.EmployeeDTO;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserTaskControllerExample {

    @Autowired
    private UserTaskService userTaskService;
    @Autowired
    private TaskService taskService;

    @PostMapping("/apply-request/{time}")
    public String completeApplyRequest(@PathVariable("time") int time, @RequestBody EmployeeDTO employeeDTO) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("demo").list();
        System.out.println(tasks.toString());
        return userTaskService.checkUserDetails(time, employeeDTO);
    }

    @GetMapping("/leave-request/{days}")
    public String completeLeaveRequest(@PathVariable("days") int days) {
        return userTaskService.completeLeaveRequest(days);
    }

    @GetMapping("/boss-check/{decision}")
    public String bossCheckRequest(@PathVariable("decision") String decision) {
        return userTaskService.bossCheckRequest(decision);
    }
}