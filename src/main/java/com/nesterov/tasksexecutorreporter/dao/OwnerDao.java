package com.nesterov.tasksexecutorreporter.dao;

import com.nesterov.tasksexecutorreporter.dto.Command;
import com.nesterov.tasksexecutorreporter.dto.Owner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OwnerDao {
    private final JdbcTemplate jdbcTemplate;

    public Owner getOwnerById(long ownerId){
        String sql = "SELECT * FROM owner WHERE id=" + ownerId;

        return jdbcTemplate.queryForObject(sql, new OwnerMapper());
    }
}