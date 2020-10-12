package com.tom.microtask.dao;

import com.tom.microtask.bean.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface TaskRepository extends MongoRepository<Task,String> {

     List<Task> findByDate(LocalDate date);
     List<Task> findByTime(String time);
     @Query("{ 'date' : ?0 , 'time': ?1}")
     List<Task> findTasksByDateAndTime(LocalDate date,String time);


}
