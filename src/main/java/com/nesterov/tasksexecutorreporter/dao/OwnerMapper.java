package com.nesterov.tasksexecutorreporter.dao;

import com.nesterov.tasksexecutorreporter.dto.Owner;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerMapper implements RowMapper<Owner> {
    @Override
    public Owner mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Owner(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("e_mail"),
                rs.getString("phone")
        );
    }
}
