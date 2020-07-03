package com.kuang.servlet;

import com.kuang.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //得到session
        HttpSession session = req.getSession();

        //给session中存东西
        session.setAttribute("name",new Person("kuangshen",1));

        //获取session的id
        String sessionIdid = session.getId();

        //判断是不是新创建
        if (session.isNew()){
            resp.getWriter().write("session创建成功，ID："+sessionIdid);
        }else {
            resp.getWriter().write("session已经在服务器中存在了，ID："+sessionIdid);
        }

        //Session在创建的时候做了什么事情：
        Cookie cookie = new Cookie("JSESSIONID", sessionIdid);
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
