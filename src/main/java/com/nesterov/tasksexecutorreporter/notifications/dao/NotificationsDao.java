package com.nesterov.tasksexecutorreporter.notifications.dao;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class NotificationsDao {

    public List<String> getNotificationMethods(int id) {
        if (id == 1){
            return List.of("e-mail");
        }
        if (id == 2){
            return List.of("e-mail", "telegram");
        }
        return null;
    }
}
