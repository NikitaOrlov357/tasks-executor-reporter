package com.nesterov.tasksexecutorreporter.notifications.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    public TestService (NotifierService notifierService){
        notifierService.makeNotify(1,true);
    }

}
