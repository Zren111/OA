package com.oa.dao;

import com.oa.entity.Node;
import com.oa.utils.MybatisUtils;

import java.util.List;

public class RbacDao {
    public List<Node> selectNodeByUserId(long userID){
        return (List)MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList("rbac.selectRole",userID));
    }
}