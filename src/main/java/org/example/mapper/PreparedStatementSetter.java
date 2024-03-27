package org.example.mapper;

import com.mysql.jdbc.PreparedStatement;

import java.sql.SQLException;

public interface PreparedStatementSetter {
    void setValues(PreparedStatement ps) throws SQLException;
}
