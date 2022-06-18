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
    long ownerId;
    Date time;

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", command='" + command + '\'' +
                ", typeId=" + typeId +
                ", regularity=" + regularity +
                ", start=" + start +
                ", ownerId=" + ownerId +
                ", time=" + time +
                '}';
    }
}

