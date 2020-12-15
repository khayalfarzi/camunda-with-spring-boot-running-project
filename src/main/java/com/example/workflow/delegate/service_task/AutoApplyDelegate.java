package com.example.workflow.delegate.service_task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AutoApplyDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        execution.setVariable("key", "Auto deploy process okay! bos do not check request that's why " +
                "candidate will be auto leave");
    }
}