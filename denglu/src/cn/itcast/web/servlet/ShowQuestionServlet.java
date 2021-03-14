package cn.itcast.web.servlet;

import cn.itcast.dao.QusetionDao;
import cn.itcast.domain.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ShowQuestionServlet")
public class ShowQuestionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //获取参数
        int a=(int)(Math.random()*10)+1;
        String x=String.valueOf(a);
        QusetionDao dao=new QusetionDao();
        Question question=dao.login(x);
        String id=String.valueOf(question.getId());
        String desd=question.getDesb();
        String choice1=question.getChoice1();
        String choice2=question.getChoice2();
        String choice3=question.getChoice3();
        String choice4=question.getChoice4();

        //输出表单
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(x);
        resp.getWriter().write(
                "<form  action='/day14/SubmitQuestionServlet' "+"method='post'>"+
                        "<input type='hidden' name='id' value="+id+">"+
                        "<label>"+desd+"</label>"+"<br/>"+
                        "<input type='radio' name='choice' value='A'>"+"A:"+choice1+"<br/>"+
                        "<input type='radio' name='choice' value='B'>"+"B:"+choice2+"<br/>"+
                        "<input type='radio' name='choice' value='C'>"+"C:"+choice3+"<br/>"+
                        "<input type='radio' name='choice' value='D'>"+"D:"+choice4+"<br/>"+
                        "<input type='submit' value='提交'>"+
                        "</form>"
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
