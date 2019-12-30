package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author denakira
 * @date 2019/12/23 7:27 下午
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity loginIn(String name, String password) {
        return userDao.getInfo(name,password);
    }
}
