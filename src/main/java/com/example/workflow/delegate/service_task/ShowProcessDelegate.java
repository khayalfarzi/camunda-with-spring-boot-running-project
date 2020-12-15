package com.example.workflow.delegate.service_task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ShowProcessDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String key = (String) execution.getVariable("key");

        System.out.println(key);
    }
}
