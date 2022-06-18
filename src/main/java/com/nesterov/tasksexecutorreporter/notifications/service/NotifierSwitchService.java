package com.nesterov.tasksexecutorreporter.notifications.service;

import com.nesterov.tasksexecutorreporter.notifications.dto.NotifierType;
import com.nesterov.tasksexecutorreporter.notifications.notifiers.Notifier;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotifierSwitchService {
    private final ApplicationContext applicationContext;

    public List<Notifier> getNotifiers(List<NotifierType> notifierNames){
        List<Notifier> notifiers = new ArrayList<>();

        notifierNames.forEach(
            (notifierType) -> {
                notifiers.add((Notifier) applicationContext.getBean(notifierType.getName()));
            }
        );

        return notifiers;
    }

}
