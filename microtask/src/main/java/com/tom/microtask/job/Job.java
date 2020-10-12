//package com.tom.microtask.job;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
//
//@Component
//public class Job {
//
//    @Autowired
//    private TaskExecutor taskExecutor;
//
//    @Autowired
//    private TaskSearcherRunnable taskSearcherRunnable;
//
//    @Autowired
//    private ApplicationContext context;
//
//    @PostConstruct
//    public void init() {
//        this.taskExecutor.execute(taskSearcherRunnable);
//    }
//
//}
//
//
