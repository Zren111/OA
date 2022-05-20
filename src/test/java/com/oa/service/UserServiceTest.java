package com.oa.service;

import org.junit.Test;

public class UserServiceTest {
    private  UserService us=new UserService();
    @Test
    public void test() throws Exception {
        us.checkLogin("m8","test");
    }
}