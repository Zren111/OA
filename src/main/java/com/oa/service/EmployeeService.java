package com.oa.service;

import com.oa.dao.EmployeeDao;
import com.oa.entity.Employee;
import com.oa.utils.MybatisUtils;

public class EmployeeService {
    public Employee selectById(Long employeeId){
        return (Employee) MybatisUtils.executeQuery(sqlSession -> {
            return sqlSession.getMapper(EmployeeDao.class).selectById(employeeId);
        });
    }
}
