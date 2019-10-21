package yx.coutroller;

import yx.entity.User;
import yx.service.UserService;
import yx.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author:三金
 * @Date:2019/10/17 19:00
 */
@WebServlet(urlPatterns = "/login")
public class loginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService=new UserServiceimpl();
        //防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获得数据
        String name=req.getParameter("name");
        String pwd=req.getParameter("pwd");
        List<User> users=userService.getName(name,pwd);
        //判断
        if (users !=null){
            req.setAttribute("users",users);
            req.getRequestDispatcher("/list.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("login.jsp");
        }
    }
}
