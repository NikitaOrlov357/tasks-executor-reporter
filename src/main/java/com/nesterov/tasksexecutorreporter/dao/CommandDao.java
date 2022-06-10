package com.nesterov.tasksexecutorreporter.dao;

import com.nesterov.tasksexecutorreporter.dto.Command;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@RequiredArgsConstructor
public class CommandDao {
    private final JdbcTemplate jdbcTemplate;

    public Command getCommandById(long commandId){
        String sql = "SELECT * FROM command INNER JOIN owner on owner_id = owner.id WHERE id=" + commandId;
        return jdbcTemplate.queryForObject(sql, new CommandMapper());
    }
}
