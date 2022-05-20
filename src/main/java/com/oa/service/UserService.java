package com.oa.service;

import com.oa.dao.UserDao;
import com.oa.entity.User;
import com.oa.service.exception.BussinessException;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;

public class UserService extends HttpServlet {
    private UserDao userDao;
    public User checkLogin(String username, String password){
        User user=userDao.selectByUsername(username);
        if(user==null){
            throw new BussinessException("L001","Username dont exist");
        }
        return user;
    }

}
