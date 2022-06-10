package com.nesterov.tasksexecutorreporter.notifications.service;

import com.nesterov.tasksexecutorreporter.notifications.dto.NotifierType;
import com.nesterov.tasksexecutorreporter.notifications.dao.NotificationsDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    public TestService (NotificationsDao notificationsDao){
        List<NotifierType> notifierTypeList = notificationsDao.getNotificationMethods(1);
        System.out.println(notifierTypeList);
    }

}
