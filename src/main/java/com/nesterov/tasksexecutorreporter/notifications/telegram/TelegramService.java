package com.nesterov.tasksexecutorreporter.notifications.telegram;

import com.nesterov.tasksexecutorreporter.notifications.Notifier;
import org.springframework.stereotype.Service;

@Service
public class TelegramService implements Notifier {
    @Override
    public void notify(String recipient, String message) {

    }
}
