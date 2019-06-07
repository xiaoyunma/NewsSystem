package com.news.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userphone = request.getParameter("userphone");
		String userpassword = request.getParameter("userpassword");
		String select = request.getParameter("select");
		System.out.println(select);
		//System.out.println("从客户端接收到参数："+"账号："+userphone+"密码："+userpassword);
		UserDao userDao = new UserDao();
		boolean valid = userDao.login(userphone, userpassword,select);
		if (valid) {
			//System.out.println("账户密码正确");
			request.getSession().setAttribute("userphone",userphone);//将用户名保存在整个会话期间  
			if (select.equals("管理员")) {
				response.sendRedirect("admin/Home");
				return;
			}else {
				response.sendRedirect("NewsServlet");
				return;
			}
			
			
		}else {
			request.setAttribute("error", "账号或密码错误");
			doGet(request, response);
		}
		
	}

}
