package com.example.oaes_student.dao;

import com.example.oaes_student.entity.User;

public interface UserDao {
    public User findByUserId(long userId) throws Exception;
    public void save(User user) throws Exception;
}
