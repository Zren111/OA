package com.oa.service;

import com.oa.dao.DepartmentDao;
import com.oa.entity.Department;
import com.oa.utils.MybatisUtils;

public class DepartmentService {
    public Department selectById(Long departmentId){
        return (Department) MybatisUtils.executeQuery(sqlSession -> {
            return sqlSession.getMapper(DepartmentDao.class).selectById(departmentId);
        });
    }
}
