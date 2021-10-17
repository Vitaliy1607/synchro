package com.example.synchronize;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.example.synchronize.primary.entity.PersonEntity;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component
public class MyCustomReader extends JdbcCursorItemReader<PersonEntity> implements ItemReader<PersonEntity>{

    public MyCustomReader(@Autowired DataSource primaryDataSource) {
        setDataSource(primaryDataSource);
        setSql("SELECT id, name, salary FROM employee");
        setFetchSize(100);
        setRowMapper(new EmployeeRowMapper());
    }

    public static class EmployeeRowMapper implements RowMapper<PersonEntity> {
        @Override
        public PersonEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            PersonEntity person  = new PersonEntity();
            person.setId(rs.getLong("id"));
            person.setFirstName(rs.getString("firstName"));
            person.setLastName(rs.getString("lastName"));
            person.setGender(rs.getString("gender"));
            return person;
        }
    }
}
