package com.nesterov.tasksexecutorreporter.notifications;

public interface Notifier {
    void notify(String recipient, String message);
}
