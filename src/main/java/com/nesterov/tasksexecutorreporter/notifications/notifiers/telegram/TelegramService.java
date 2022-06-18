package com.nesterov.tasksexecutorreporter.notifications.notifiers.telegram;

import com.nesterov.tasksexecutorreporter.notifications.notifiers.Notifier;
import org.springframework.stereotype.Service;

@Service("telegram")
public class TelegramService implements Notifier {
    @Override
    public void makeNotify(long ownerId, String message) {

    }
}
