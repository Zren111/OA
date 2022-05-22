package com.oa.dao;

import junit.framework.TestCase;
import org.junit.Test;

public class RbacDaoTest {
    @Test
    public void test(){
        RbacDao rbacDao=new RbacDao();
        rbacDao.selectNodeByUserId(2);
    }

}