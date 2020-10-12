package com.tom.microtask.controller;


import com.tom.microtask.bean.Task;
import com.tom.microtask.dao.TaskRepository;
import com.tom.microtask.exception.MicroTaskException;
import com.tom.microtask.service.TaskService;
import com.tom.microtask.task_menagment.TaskSearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskService taskService;

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    public void createTask(Task task) throws Exception {
        validateForm(task);
        log.info(" "+task.getUserName()+" "+task.getDate());
        task.setTime(task.getTime().substring(0, 5));
        taskRepository.save(task);
    }

    private void validateForm(Task t) throws Exception {
        checkIfUserExists(t.getUserName());
        checkDate(t.getDate());
        checkTime(t.getTime());
    }

    private void checkIfUserExists(String userName) throws Exception {
        if(taskService.checkIfUserExists(userName));
        else throw new MicroTaskException("Validation Error : User not found", HttpStatus.NOT_FOUND);
    }

    private void checkDate(LocalDate date) throws Exception {
        if (date.isAfter(LocalDate.now()) || date.isEqual(LocalDate.now())) ;
        else throw new MicroTaskException("Validation Error : Invalid date",HttpStatus.NOT_ACCEPTABLE);
    }

    private void checkTime(String time) throws Exception {
        if (LocalTime.parse(time).isAfter(LocalTime.now()));
        else throw new MicroTaskException("Validation Error : Invalid time",HttpStatus.NOT_ACCEPTABLE);
    }
}
