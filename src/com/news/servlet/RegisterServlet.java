package com.news.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.RegisterDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean repeat = false;
		// 判断两次密码是否一致
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");

		String userphone = request.getParameter("userphone");
		String userpassword = request.getParameter("userpassword");
		String userpassword1 = request.getParameter("userpassword1");
		String usersex = request.getParameter("sex");
		String select = "普通用户";
		if (username.equals("")) {
			request.setAttribute("error_name", "用户名不能为空！");
			doGet(request, response);
		}
		if (userphone.equals("")) {
			request.setAttribute("error_phone", "手机号不能为空！");
			doGet(request, response);
		}
		// 从客户端接收参数
		if (userpassword.equals(userpassword1) && !userpassword.equals("")) {
			repeat = true;
		}else{
			request.setAttribute("error_repeat", "两次密码不一致，请重新输入！");
			doGet(request, response);
		}
		System.out.println("从客户端接收到参数：" + "用户名：" + username + "手机号：" + userphone);

		RegisterDao registerDao = new RegisterDao();
		boolean valid= registerDao.register(userpassword, username, usersex, userphone,select);
		if (valid) {
			System.out.println("恭喜你注册成功！");
			response.sendRedirect("login.jsp");
			return;

		} else {
			request.setAttribute("error", "注册失败");
			doGet(request, response);
		}

	}

}
