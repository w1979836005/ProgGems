package org.example.service.impl;

import org.example.factory.DaoFactory;
import org.example.mapper.UserDao;
import org.example.mapper.impl.UserDaoImpl;
import org.example.model.pojo.Result;
import org.example.model.pojo.User;
import org.example.service.UserService;
import org.example.util.MD5Util;

import static org.example.util.MD5Util.encrypt;

public class UserServiceImpl implements UserService {
    private static UserDao userDao;
    static {
        userDao = DaoFactory.getUserDao();
    }
    @Override
    public Result register(String username,String password,String email,String password1) {

        //通过工厂类创建Dao层代码操作数据

        /***
         * 注册逻辑：
         * 1.用户信息为空，不能注册
         * 2.用户名长度为 5 位以上（密码同）
         * 3.已存在用户名，不能注册
         * 4.进行md5加密
         * 6.邮箱验证 （bushi）
         * 7.确认两次密码是否相同
         */
        System.out.println("service");
        if(username == null || password == null || email == null || password1 == null) {
            return new Result(false,"用户信息为空",200);
        }

        if(username.length() < 5 || password.length() < 5 ) {
            return new Result(false,"用户信息长度不符合要求",201);
        }

        if(!password.equals(password1)) {
            return new Result(false,"两次密码不一致",204);
        }

        System.out.println(userDao.getUser(username));
        User user1 = userDao.getUser(username);
        System.out.println(user1);
        if(user1 != null) {
            System.out.println("用户已存在");
            return new Result(false,"用户已存在",202);
        }

        System.out.println("通过检测");


        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(encrypt(password));
        userDao.addUser(user);

        return new Result(true,"success",203);
    }

    @Override
    public Result login(String username, String password) {

        if(username == null || password == null) {
            return new Result(false,"输入字段为空",200);
        }

        if(username.length() < 5 || password.length() < 5 ) {
            return new Result(false,"用户信息长度不符合要求",201);
        }

        password = encrypt(password);
        System.out.println(username);
        System.out.println(password);

        User user = userDao.getUser(username, password);


        if(user != null) {
            return new Result(true,"success",1);
        }else {
            return new Result(false,"用户不存在或者账号密码错误");
        }

    }
}
