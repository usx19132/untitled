package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据参数名称获取参数值
        String username = request.getParameter("username");
        System.out.println("post");
        System.out.println(username);
        //根据参数名称获取参数值的数组
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby: hobbies) {
            System.out.println(hobby);
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历
        Set<String> keySet = parameterMap.keySet();
        for (String name:keySet) {
            System.out.println("-----------");
            System.out.println(name);
            String[] values = parameterMap.get(name);
            for (String value:values) {
                System.out.println(value);
            }

        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        System.out.println("get");
//        System.out.println(username);
        doPost(request,response);
    }
}
