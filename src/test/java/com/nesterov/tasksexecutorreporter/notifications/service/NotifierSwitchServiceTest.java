package com.nesterov.tasksexecutorreporter.notifications.service;

import com.nesterov.tasksexecutorreporter.notifications.notifiers.Notifier;
import com.nesterov.tasksexecutorreporter.notifications.notifiers.email.EmailService;
import com.nesterov.tasksexecutorreporter.notifications.notifiers.telegram.TelegramService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class NotifierSwitchServiceTest {
    @Autowired
    private NotifierSwitchService notifierSwitchService;
    @Autowired
    private EmailService emailService;

    @Test
    public void getNotifiersForEmail() {
        List<String> listOfNames = List.of("e-mail");

        System.out.println(emailService);

        List<Notifier> notifierList = notifierSwitchService.getNotifiers(listOfNames);

        assertTrue(notifierList.get(0) instanceof EmailService);
    }

    @Test
    public void getNotifiersForEmailAndTelegram(){
        List<String> listOfNames = List.of("e-mail", "telegram");

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