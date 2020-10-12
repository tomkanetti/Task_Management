package com.tom.microtask.task_menagment;

import com.tom.microtask.bean.Task;
import com.tom.microtask.dao.TaskRepository;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

@Component
public class TaskSearcher {
    @Autowired
    TaskRepository taskRepository;

    LocalDateTime localDateTime;

    private static final Logger log = LoggerFactory.getLogger(TaskSearcher.class);

    @Scheduled(cron = "0 * * * * ?")
    public void reportCurrentTime() throws InterruptedException {
        searchTask();
        //log.info("here "+ localDateTime.toLocalTime().withNano(0).toString());

    }

    private void searchTask() throws InterruptedException {
        localDateTime = LocalDateTime.now();
        messageXMinutesBefore(localDateTime, 10);
        messageXMinutesBefore(localDateTime, 5);
        messageXMinutesBefore(localDateTime, 0);

    }

    private void messageXMinutesBefore(LocalDateTime localDateTime, int minutes) throws InterruptedException {
        List<Task> tasks = taskRepository.findTasksByDateAndTime(localDateTime.toLocalDate(), localDateTime.toLocalTime().plusMinutes(minutes).withSecond(0).withNano(0).toString());
        if (!tasks.isEmpty()) {
            massage(tasks, minutes);
        }
    }
    private void massage(List<Task> tasks, int minutes) throws InterruptedException {
        for (Task t : tasks) {
            if (minutes == 0) {
                log.info(t.getUserName() + "!! Your task- '" + t.getTaskName() + "' now! ");
                taskRepository.delete(t);
                //runTask(t);
            } else
                log.info(t.getUserName() + "!! Your task - " + t.getTaskName() + " in " + minutes + " Minutes");
        }

    }


//    private void runTask(Task task) throws InterruptedException {
//        java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, Thread.currentThread().getName() + " running the task " + task.getTaskName() + " ....");
//        TimeUnit.SECONDS.sleep(5);
//        taskRepository.delete(task);
//        java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, task.getTaskName() + " Finished and deleted");
//    }
}

