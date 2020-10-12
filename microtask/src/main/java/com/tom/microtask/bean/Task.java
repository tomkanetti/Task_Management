package com.tom.microtask.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
public class Task {
    @Id
    @JsonIgnore
    String id;
    String taskName;
    String userName;
    LocalDate date;
    @JsonFormat(pattern=("HH:mm"))
    String time;

}
