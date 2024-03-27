package org.example.mapper;

import org.example.model.pojo.User;

// 创建接口
    public interface UserDao {

        public void addUser(User user) ;

        public User getUser(String username);

        public User getUser(String username,String password);

        public void delUser(int uid);

        public void updateUser(User user);

    }
