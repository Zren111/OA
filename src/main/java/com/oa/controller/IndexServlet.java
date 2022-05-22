package com.oa.controller;

import com.oa.entity.Department;
import com.oa.entity.Employee;
import com.oa.entity.Node;
import com.oa.entity.User;
import com.oa.service.DepartmentService;
import com.oa.service.EmployeeService;
import com.oa.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/index")
public class IndexServlet extends HttpServlet {
    UserService userService=new UserService();
    EmployeeService employeeService=new EmployeeService();
    DepartmentService departmentService=new DepartmentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("login_user");
        Employee employee=employeeService.selectById(user.getEmployeeId());
        Department department=departmentService.selectById(employee.getDepartmentId());
        List<Node> nodeList=userService.selectNodeByUserId(user.getUserId());
        request.setAttribute("node_list",nodeList);
        session.setAttribute("current_employee",employee);
        session.setAttribute("current_department",department);
        request.getRequestDispatcher("/index.ftl").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
