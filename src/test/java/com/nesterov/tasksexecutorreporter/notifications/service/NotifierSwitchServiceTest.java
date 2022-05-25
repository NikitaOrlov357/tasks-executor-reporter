package com.nesterov.tasksexecutorreporter.notifications.service;

import com.nesterov.tasksexecutorreporter.notifications.Notifier;
import com.nesterov.tasksexecutorreporter.notifications.email.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class NotifierSwitchServiceTest {
    @Autowired
    NotifierSwitchService notifierSwitchService;

    @Test
    void getNotifiersForEmail() {
        List<String> listOfNames = List.of("e-mail");

        List<Notifier> notifierList = notifierSwitchService.getNotifiers(listOfNames);

        assertTrue(notifierList.get(0) instanceof EmailService);
    }
}