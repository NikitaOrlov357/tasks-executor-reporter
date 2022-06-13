package com.nesterov.tasksexecutorreporter.notifications.notifiers;

public interface Notifier {
    void makeNotify(long ownerId, String message);
}