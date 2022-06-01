package com.nesterov.tasksexecutorreporter.notifications.notifiers;

public interface Notifier {
    void makeNotify(int ownerId, String message);
}