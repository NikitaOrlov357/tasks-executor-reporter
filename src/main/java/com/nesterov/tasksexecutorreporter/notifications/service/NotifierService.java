package com.nesterov.tasksexecutorreporter.notifications.service;

import com.nesterov.tasksexecutorreporter.notifications.dto.NotifierType;
import com.nesterov.tasksexecutorreporter.notifications.dao.NotificationsDao;
import com.nesterov.tasksexecutorreporter.notifications.notifiers.Notifier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NotifierService {
    private final NotificationsDao notificationsDao;
    private final NotifierSwitchService notifierSwitchService;

    public void makeNotify(int ownerId, int commandId, boolean result) {
        List<NotifierType> notificationMethods = notificationsDao.getNotificationMethods(ownerId);
        List<Notifier> notifiers = notifierSwitchService.getNotifiers(notificationMethods);
        notifiers.forEach(
                (notifier) -> notifier.makeNotify(1, "command " + commandId + " was finished with result " + result)
        );
    }

}
