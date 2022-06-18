package com.nesterov.tasksexecutorreporter.configs.applicationConfigs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalConfigs {

    @Bean
    public NotificationsConfig notificationsConfig(){
        return new NotificationsConfig();
    }

    @Getter
    public class NotificationsConfig{
        @Value("${dummymode.notifications.email.enable}")
        private boolean dummyModeNotificationsEmailEnable;
    }

}
