package com.nesterov.tasksexecutorreporter.dao;

import com.nesterov.tasksexecutorreporter.dto.Command;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommandMapper implements RowMapper<Command> {

    @Override
    public Command mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Command(
                rs.getLong("id"),
                rs.getString("command"),
                rs.getLong("type_id"),
                rs.getLong("regularity"),
                rs.getLong("start"),
                rs.getLong("owner_id"),
                rs.getDate("time")
        );
    }
}
