package com.example.workflow.delegate.user_task;

import com.example.workflow.dto.EmployeeDTO;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTaskService {

    @Autowired
    private TaskService taskService;

    public String checkUserDetails(int time, EmployeeDTO employeeDTO) {

        List<Task> tasks = taskService.createTaskQuery().taskAssignee("demo").list();

        String id = null;
        System.out.println("start olunmus task " + tasks.toString());

        for (Task t : tasks) {
            System.out.println(t.getAssignee() + " " +
                    t.getCaseDefinitionId() + " " +
                    t.getCaseExecutionId() + " " +
                    t.getCaseInstanceId() + " " +
                    t.getId() + " " +
                    t.getName() + " " +
                    t.getPriority());
            id = t.getId();
        }

        if (time > 5)
            taskService.setVariable(id, "isCanBe", "no");
        else taskService.setVariable(id, "isCanBe", employeeDTO);

        taskService.complete(id);

        return "Successfully completed";
    }

    public String completeLeaveRequest(int days) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("demo").list();

        String id = null;
        System.out.println("start olunmus task " + tasks.toString());

        for (Task t : tasks) {
            System.out.println(t.getAssignee() + " " +
                    t.getCaseDefinitionId() + " " +
                    t.getCaseExecutionId() + " " +
                    t.getCaseInstanceId() + " " +
                    t.getId() + " " +
                    t.getName() + " " +
                    t.getPriority());
            id = t.getId();
        }

        taskService.setVariable(id, "key", days);

        taskService.complete(id);
        return "Successfully completed";
    }

    public String bossCheckRequest(String decision) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("demo").list();

        String id = null;
        System.out.println("start olunmus task " + tasks.toString());

        for (Task t : tasks) {
            System.out.println(t.getAssignee() + " " +
                    t.getCaseDefinitionId() + " " +
                    t.getCaseExecutionId() + " " +
                    t.getCaseInstanceId() + " " +
                    t.getId() + " " +
                    t.getName() + " " +
                    t.getPriority());
            id = t.getId();
        }

        if (decision.equals("BAD"))
            taskService.setVariable(id, "key", "no");
        else taskService.setVariable(id, "key", "Boss decision is OK everything is okay and employee can do leave");
        return "Boss check request successfully";
    }
}
