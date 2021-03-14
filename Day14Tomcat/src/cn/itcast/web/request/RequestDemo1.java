package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求方式get
        String method=request.getMethod();
        System.out.println(method);
        //获取虚拟目录，
        String contextPath=request.getContextPath();
        System.out.println(contextPath);
        //获取Servlet路径 /requestDemo1
        String servletPath=request.getServletPath();
        System.out.println(servletPath);
        //获取get方式请求参数,name=zhangsan
        String quanyString=request.getQueryString();
        System.out.println(quanyString);
        //获取请求URI
        String requestURI=request.getRequestURI();
        StringBuffer requstURL=request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requstURL);
        //获取协议及版本，HTTP/1.1
        String  protocol = request.getProtocol();
        System.out.println(protocol);
        //获取客户机的IP地址
        String remoteAddr=request.getRemoteAddr();
        System.out.println(remoteAddr);

    }
}

