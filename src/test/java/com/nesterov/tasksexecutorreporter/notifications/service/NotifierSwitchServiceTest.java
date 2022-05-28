package com.nesterov.tasksexecutorreporter.notifications.service;

import com.nesterov.tasksexecutorreporter.notifications.Notifier;
import com.nesterov.tasksexecutorreporter.notifications.email.EmailService;
import com.nesterov.tasksexecutorreporter.notifications.telegram.TelegramService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class NotifierSwitchServiceTest {
    @Autowired
    private NotifierSwitchService notifierSwitchService;

    @Test
    public void getNotifiersForEmail() {
        List<String> listOfNames = List.of("e-mail");

        List<Notifier> notifierList = notifierSwitchService.getNotifiers(listOfNames);

        assertTrue(notifierList.get(0) instanceof EmailService);
    }

    @Test
    public void getNotifiersForEmailAndTelegram(){
        List<String> listOfNames = List.of("emailService", "telegramService");

        List<Notifier> notifierList = notifierSwitchService.getNotifiers(listOfNames);

        boolean containsEmailService = false;
        boolean containsTelegramService = false;

        for (Notifier notifier : notifierList) {
            if (notifier.getClass() == EmailService.class) {
                containsEmailService = true;
            } else if (notifier.getClass() == TelegramService.class) {
                containsTelegramService = true;
            }
        }

        assertTrue(containsEmailService && containsTelegramService);

    }
}