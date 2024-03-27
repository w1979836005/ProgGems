package org.example.mapper.impl;

import org.example.mapper.PreparedStatementSetter;
import org.example.mapper.ResultSetExtractor;
import org.example.mapper.UserDao;
import org.example.model.pojo.User;
import org.example.util.DaoException;
import org.example.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private void executeUpdate(String sql, PreparedStatementSetter pss) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtils.getConn();
            ps = conn.prepareStatement(sql);
            pss.setValues((com.mysql.jdbc.PreparedStatement) ps);
            ps.executeUpdate();
        } finally {
            JdbcUtils.free(null, ps, conn);
        }
    }

    private <T> T executeQuery(String sql, PreparedStatementSetter pss, ResultSetExtractor<T> rse) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        T result = null;
        try {
            conn = JdbcUtils.getConn();
            ps = conn.prepareStatement(sql);
            pss.setValues((com.mysql.jdbc.PreparedStatement) ps);
            rs = ps.executeQuery();
            result = rse.extractData(rs);
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return result;
    }

    @Override
    public void addUser(User user) {

        String sql = "insert into users(username,password,email) values(?,?,?)";
        PreparedStatementSetter pss = ps -> {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
        };
        try {
            executeUpdate(sql, pss);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public User getUser(String username) {


        return null;
    }

    @Override
    public User getUser(String username, String password) {
        return null;
    }

    @Override
    public void delUser(int uid) {

    }

    @Override
    public void updateUser(User user) {

    }
}
