package com.example.workflow.delegate.service_task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckApplyDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        int days = (int) execution.getVariable("key");

        if (days > 20)
            execution.setVariable("key", "cant");
        else execution.setVariable("key", "can");
    }
}