package com.assignment.application.interceptor;

import com.assignment.application.entity.Employee;
import com.assignment.application.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.preHandle(request, response, handler);
        String userName = request.getHeader("username");
        String password = request.getHeader("password");
        if(userName==null || password==null || userName.isEmpty() || password.isEmpty()){
            throw new IllegalArgumentException("Invalid Credential");
        }
        else if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
            return true;
        }
        Employee employee;
        employee = employeeRepo.getEmployee(userName);
        if(employee==null){
            throw new IllegalArgumentException("Invalid Credential");
        }
        if(!employee.getEmployeeId().equalsIgnoreCase(userName) || !employee.getDob().equalsIgnoreCase(password)){
            throw new IllegalArgumentException("Invalid Credential");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
