package com.example.workflow.controller;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ServiceTaskController {
    private static final String PROCESS_DEFINITION_KEY = "annual_leave_steps";

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @GetMapping("/start")
    public String startBPMNProcess() {
        System.out.println("======================= Start Process started ===================================");
        runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY);
        return "Process successfully started";
    }
}