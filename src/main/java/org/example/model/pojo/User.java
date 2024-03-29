package org.example.model.pojo;

import java.sql.Timestamp;
import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String username;
    private String password;
    private String email;
    private Timestamp createdAt;

    // 默认构造函数
    public User() {
    }

    // 带参数的构造函数
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter 和 Setter 方法
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // 重写toString方法，方便调试和打印对象信息
    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", password=" + password
                + ", email=" + email + ", createdAt=" + createdAt + "]";
    }

    // 可以根据需要添加其他方法，比如hashCode和equals方法
}
