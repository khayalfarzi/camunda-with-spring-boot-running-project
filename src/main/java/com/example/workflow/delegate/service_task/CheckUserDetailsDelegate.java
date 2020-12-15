package com.example.workflow.delegate.service_task;

import com.example.workflow.dto.EmployeeDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckUserDetailsDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        EmployeeDTO dto = new EmployeeDTO();
        if (!execution.getVariable("isCanBe").equals("no")) {
            dto = (EmployeeDTO) execution.getVariable("isCanBe");
            System.out.println(dto.toString());
        } else execution.setVariable("key", "no");

        if (dto.getAge() < 18)
            execution.setVariable("key", "no");
        else execution.setVariable("key", dto);
    }
}