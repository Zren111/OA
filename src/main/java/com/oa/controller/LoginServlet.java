package com.oa.controller;

import com.alibaba.fastjson.JSON;
import com.oa.entity.User;
import com.oa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    private UserService userService=new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger logger=  LoggerFactory.getLogger(LoginServlet.class);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        super.doPost(req, resp);
        String username=req.getParameter("uesrname");
        String password=req.getParameter("password");
        Map<String,Object> result=new HashMap<>();
        try{
            User user=userService.checkLogin(username,password);
            result.put("code",0);
            result.put("message","success");
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            result.put("code",e.getClass().getSimpleName());
            result.put("message",e.getMessage());
        }
        String json=JSON.toJSONString(result);
        resp.getWriter().println(json);
            
    }
}
