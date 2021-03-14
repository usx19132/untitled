import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/serveyServlet")
public class serveyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aClass = request.getParameter("class");
        String name = request.getParameter("name");
        String[] internets = request.getParameterValues("internet");
        String[] shops = request.getParameterValues("shop");
        String advice = request.getParameter("advice");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(
                "<ol>" +
                "<li>班级："+aClass+"</li>"+
                "<li>姓名："+name+"</li>"+
                "<li>常用网站："
        );
        for (String a:internets){
            response.getWriter().write(a);
        }
        response.getWriter().write("</li><li>喜欢的网购物品种类：");
        for (String a:shops){
            response.getWriter().write(a);
        }
        response.getWriter().write("</li><li>改进建议："+advice+"</li></ol>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
