package cn.itcast.web.servlet;

import cn.itcast.dao.QusetionDao;
import cn.itcast.domain.Question;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/SubmitQuestionServlet")
public class SubmitQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String choice=req.getParameter("choice");
        String id=req.getParameter("id");
        QusetionDao dao=new QusetionDao();
        Question question=dao.login(id);
        String choice1=question.getChoice1();
        String choice2=question.getChoice2();
        String choice3=question.getChoice3();
        String choice4=question.getChoice4();
        String desd=question.getDesb();
        resp.getWriter().write(
                "<form  action='/day14/SubmitQuestionServlet' method='post'>"+
                        "<input type='hidden' name=id value="+id+">"+"<br/>"+
                        "<label>"+desd+"</label>"+"<br/>"+
                        "A:"+choice1+"<br/>"+
                        "B:"+choice2+"<br/>"+
                        "C:"+choice3+"<br/>"+
                        "D:"+choice4+"<br/>"+
                        "</form>"
        );
        if(question.getAnswer().equals(choice)) resp.getWriter().write("回答正确！");
        else if(choice==null) resp.getWriter().write("未回答");
        else resp.getWriter().write("回答错误,正确答案为"+question.getAnswer());
        resp.getWriter().write("<br/><a href='http://localhost:8080/day14/ShowQuestionServlet'> 继续答题</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
