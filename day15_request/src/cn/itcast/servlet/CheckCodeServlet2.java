package cn.itcast.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet2")
public class CheckCodeServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=100;
        int height=50;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //图片美化
        //背景色
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0,0,width,height);
        //边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        Random ran=new Random();
        for (int i=1;i<=4;i++){
            int index=ran.nextInt(str.length());
            char ch=str.charAt(index);
            g.drawString(ch+"",width/5*i,height/2);
        }


        //2.4画干扰线
        g.setColor(Color.GREEN);
        for(int i=1;i<=10;i++){
            int x1=ran.nextInt(width);
            int x2=ran.nextInt(width);
            int y1=ran.nextInt(height);
            int y2=ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }



        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
