<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>itcast</title>
</head>
<body>
<%
    response.setContentType("text/html;charset=utf-8");

    Cookie[] cookies=request.getCookies();
    boolean flag=false;
    if(cookies!=null && cookies.length>0){
        for (Cookie cookie: cookies) {
            String name=cookie.getName();
            if(name.equals("lastTime")){
                //输出
                String value=cookie.getValue();
                value= URLDecoder.decode(value,"utf-8");
%>
               <h1>欢迎回来!你上次访问的时间为<%=value%></h1>
<%
                //更新数据
                flag=true;
                Date date=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String str_date=sdf.format(date);
                str_date= URLEncoder.encode(str_date,"utf-8");
                cookie.setValue(str_date);
                cookie.setMaxAge(60*60*24*30);
                response.addCookie(cookie);

            }
        }
    }

    if(cookies==null || cookies.length==0 || flag==false){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date=sdf.format(date);
        str_date= URLEncoder.encode(str_date,"utf-8");
        Cookie cookie=new Cookie("lastTime",str_date);
        response.addCookie(cookie);
        cookie.setMaxAge(60*60*24*30);
        out.write("<h1>欢迎您首次登录</h1>");
    }
%>
</body>
</html>
