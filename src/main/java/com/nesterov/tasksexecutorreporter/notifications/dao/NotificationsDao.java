package com.nesterov.tasksexecutorreporter.notifications.dao;

import com.nesterov.tasksexecutorreporter.dto.NotifierType;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class NotificationsDao {
    private final JdbcTemplate jdbcTemplate;

    public List<NotifierType> getNotificationMethods(long ownerId) {
        String sql = "SELECT notifier_type_id, name FROM owner_to_notifier_type INNER JOIN notifier_type ON notifier_type_id=notifier_type.id WHERE owner_id=" + ownerId;

        return jdbcTemplate.query(
                sql, (rs, rowNum) ->
                new NotifierType(
                        rs.getString("name"),
                        rs.getInt("notifier_type_")
                )
        );
    }
}
