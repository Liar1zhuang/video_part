package com.example.demo.dao;

import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author denakira
 * @date 2019/12/23 7:25 下午
 */
@Repository
public interface UserDao {

    UserEntity getInfo(String name,String password);

}
