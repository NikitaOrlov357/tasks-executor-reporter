package com.nesterov.tasksexecutorreporter.dao;

import com.nesterov.tasksexecutorreporter.dto.Command;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CommandDao {
    private final JdbcTemplate jdbcTemplate;

    public Command getCommandById(long commandId){
        String sql = "SELECT * FROM command WHERE id=" + commandId;

        return jdbcTemplate.queryForObject(sql, new CommandMapper());
    }
}
