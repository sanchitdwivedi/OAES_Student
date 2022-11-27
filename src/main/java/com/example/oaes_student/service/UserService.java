package com.example.oaes_student.service;

import com.example.oaes_student.dao.UserDao;
import com.example.oaes_student.dao.UserDaoImpl;
import com.example.oaes_student.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;

    public UserService(){
        userDao = new UserDaoImpl();
    }

    public void updateUser(User user) throws Exception {
        userDao.save(user);
    }

    public User getUserById(long userId) throws Exception {
        return userDao.findByUserId(userId);
    }
}