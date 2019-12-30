package com.example.demo.service;

import com.example.demo.entity.UserEntity;

/**
 * @author denakira
 * @date 2019/12/23 7:27 下午
 */
public interface UserService {
    UserEntity loginIn(String name, String password);
}
