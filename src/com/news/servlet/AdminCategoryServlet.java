package com.news.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.String;
import com.news.dao.TypeDao;
import com.news.model.Type;

/**
 * Servlet implementation class AdminCategoryServlet
 */
@WebServlet("/admin/Category")
public class AdminCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminCategoryServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TypeDao typeDao = new TypeDao();
		List<Type> types = typeDao.getAll();
		request.setAttribute("types", types);

		request.getRequestDispatcher("/admin_category.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String typename1 = request.getParameter("typename");
		String typename = new String(typename1.getBytes("ISO-8859-1"), "UTF-8");
		if (typename == null || "".equals(typename)) {
			request.setAttribute("error", "分类名称不能为空");
			doGet(request, response);
			return;

		}
		TypeDao typeDao = new TypeDao();
		boolean isExists = typeDao.exists(typename);
		if (isExists) {
			request.setAttribute("error", "分类名称已经存在");
			doGet(request, response);
			return;
		}
		typeDao.addType(typename);
		doGet(request, response);
	}

}
