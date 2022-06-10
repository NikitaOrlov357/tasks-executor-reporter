package com.nesterov.tasksexecutorreporter.dto;

import lombok.Value;

import java.util.Date;

@Value
public class Command {
    long id;
    String command;
    long typeId;
    long regularity;
    long start;
    Owner owner;
    Date time;

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", command='" + command + '\'' +
                ", typeId=" + typeId +
                ", regularity=" + regularity +
                ", start=" + start +
                ", owner=" + owner +
                ", time=" + time +
                '}';
    }
}

