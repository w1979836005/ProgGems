package org.example.service.impl;

import org.example.factory.DaoFactory;
import org.example.mapper.UserDao;
import org.example.model.pojo.Result;
import org.example.model.pojo.User;
import org.example.service.UserService;

import static org.example.util.MD5Util.encrypt;

public class UserServiceImpl implements UserService {
    @Override
    public Result register(String username,String password,String email,String password1) {

        //通过工厂类创建Dao层代码操作数据
        UserDao userDao = DaoFactory.getInstance().getUserDao();

        /***
         * 注册逻辑：
         * 1.用户信息为空，不能注册
         * 2.用户名长度为 5 位以上（密码同）
         * 3.已存在用户名，不能注册
         * 4.进行md5加密
         * 6.邮箱验证 （bushi）
         * 7.确认两次密码是否相同
         */

        if(username == null || password == null || email == null || password1 == null) {
            return new Result(false,"用户信息为空",200);
        }

        if(username.length() < 5 || password.length() < 5 ) {
            return new Result(false,"用户信息长度不符合要求",201);
        }

        if(!password.equals(password1)) {
            return new Result(false,"两次密码不一致",204);
        }

        if(false) {
            return new Result(false,"用户已存在",202);
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(encrypt(password));
        userDao.addUser(user);

        Result result = new Result(true,"success",203);
        return result;
    }

    @Override
    public Result login() {
        return null;
    }
}
