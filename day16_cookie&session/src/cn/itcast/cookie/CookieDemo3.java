package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CookieDemo3")
public class CookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie c1=new Cookie("msg","hello");
        Cookie c2=new Cookie("name","zhangsan");
        c1.setMaxAge(30);//c1对象持久化到硬盘30s,负数为默认值，0为删除,tomcat8之后可中文
        c1.setPath("/");//Cookie共享，默认值为所在的虚拟目录
        response.addCookie(c1); response.addCookie(c2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
