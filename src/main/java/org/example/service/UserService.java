package org.example.service;

import org.example.model.pojo.Result;

public interface UserService {
    public Result register(String username,String password,String email,String password1);
    public Result login();
}
