package com.nesterov.tasksexecutorreporter.notifications.service;

import com.nesterov.tasksexecutorreporter.dao.CommandDao;
import com.nesterov.tasksexecutorreporter.dto.Command;
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
    private final CommandDao commandDao;

    public void makeNotify(int commandId, boolean result) {
        Command command = (commandDao.getCommandById(commandId));
        List<NotifierType> notificationMethods = notificationsDao.getNotificationMethods(command.getOwnerId());
        List<Notifier> notifiers = notifierSwitchService.getNotifiers(notificationMethods);
        notifiers.forEach(
                (notifier) -> notifier.makeNotify(command.getOwnerId(), "command " + commandId + " was finished with result " + result)
        );
    }

}
