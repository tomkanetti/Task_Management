//package com.tom.microtask.job;
//
//
//import com.tom.microtask.bean.Task;
//import com.tom.microtask.dao.TaskRepository;
//import lombok.SneakyThrows;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//@Component
//public class TaskSearcherRunnable implements Runnable {
//
//    @Autowired
//    TaskRepository taskRepository;
//
//    LocalDateTime localDateTime;
//
//    @Autowired
//    private TaskExecutor taskExecutor;
//
//    @Override
//    public void run() {
//        while (true) {
//            searchTask();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void searchTask() {
//        localDateTime = LocalDateTime.now();
//        messageXMinutesBefore(localDateTime, 10);
//        messageXMinutesBefore(localDateTime, 5);
//        messageXMinutesBefore(localDateTime, 0);
//
//    }
//
//
//    private void messageXMinutesBefore(LocalDateTime localDateTime, int minutes) {
//        List<Task> tasks = taskRepository.findTasksByDateAndTime(localDateTime.toLocalDate(), localDateTime.toLocalTime().plusMinutes(minutes).withNano(0).toString());
//        if (!tasks.isEmpty()) {
//            massage(tasks, minutes);
//        }
//    }
//
//    private void massage(List<Task> tasks, int minutes) {
//        for (Task t : tasks) {
//            if (minutes == 0) {
//                Logger.getAnonymousLogger().log(Level.INFO, t.getUserName() + "!! Your task- " + t.getTaskName() + " now! ");
//                this.taskExecutor.execute(new Runnable() {
//                    @SneakyThrows
//                    @Override
//                    public void run() {
//                        Logger.getAnonymousLogger().log(Level.INFO, Thread.currentThread().getName() + " running the task " + t.getTaskName() + " ....");
//                        Thread.sleep(5000);
//                        taskRepository.delete(t);
//                        Logger.getAnonymousLogger().log(Level.INFO, t.getTaskName() + " Finished and deleted");
//                    }
//                });
//            } else
//                Logger.getAnonymousLogger().log(Level.INFO, t.getUserName() + "!! Your task - " + t.getTaskName() + " in " + minutes + " Minutes");
//        }
//
//    }
//}