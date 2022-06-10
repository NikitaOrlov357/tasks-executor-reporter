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
                rs.getInt("COMMAND.ID"),
                rs.getString("COMMAND.COMMAND"),
                rs.getLong("COMMAND.TYPE_ID"),
                rs.getLong("COMMAND.REGULARITY"),
                rs.getLong("COMMAND.START"),
                new Owner(
                        rs.getLong("COMMAND.OWNER_ID"),
                        rs.getString("OWNER.NAME")
                ),
                rs.getDate("COMMAND.DATE")
        );
    }
}
