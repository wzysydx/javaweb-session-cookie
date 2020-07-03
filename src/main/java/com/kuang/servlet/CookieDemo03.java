package com.kuang.servlet;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();//这里返回数组，说明cookie可能存在多个
        PrintWriter out = resp.getWriter();

        //判断cookie是否存在
        if (cookies != null){
            //如果存在怎么办？
            out.write("你上一次访问的时间是");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获取cookie的名字
                if (cookie.getName().equals("name")){
                    System.out.println(cookie.getValue());
                }
            }
        }else {
            out.write("这是您第一次访问");
        }

        Cookie cookie = new Cookie("name","狂神");
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
