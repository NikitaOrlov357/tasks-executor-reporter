package com.nesterov.tasksexecutorreporter.dao;

import com.nesterov.tasksexecutorreporter.dto.Command;
import com.nesterov.tasksexecutorreporter.dto.CommandType;
import com.nesterov.tasksexecutorreporter.dto.Owner;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class CommandMapper implements RowMapper<Command> {



    @Override
    public Command mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Command(
                rs.getInt("id"),
                rs.getString("command"),
                CommandType.valueOf(rs.getString("type").toUpperCase(Locale.ROOT)),
                rs.getLong("regularity"),
                rs.getLong("start"),
                new Owner(
                        rs.getInt("id"),
                        rs.getString("name")
                ),
                rs.getDate("time")
        );
    }
}
