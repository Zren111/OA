package com.oa.service;

import com.oa.dao.RbacDao;
import com.oa.dao.UserDao;
import com.oa.entity.Node;
import com.oa.entity.User;
import com.oa.service.exception.BussinessException;
import com.oa.utils.MD5Utils;

import java.util.List;


public class UserService {
    private UserDao userDao=new UserDao();
    private RbacDao rbacDao=new RbacDao();
    public User checkLogin(String username, String password){
        User user=userDao.selectByUsername(username);
        if(user==null){
            throw new BussinessException("L001","Username dont exist");
        }
        String md5 = MD5Utils.md5Digest(password, user.getSalt());
        if(!md5.equals(user.getPassword()))
            throw new BussinessException("L001","Password fail");
        return user;
    }
    public List<Node> selectNodeByUserId(long userId){
        return rbacDao.selectNodeByUserId(userId);
    }

}
