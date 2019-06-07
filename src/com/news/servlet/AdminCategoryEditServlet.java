package com.news.servlet;

import java.lang.String;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.TypeDao;
import com.news.model.Type;

/**
 * Servlet implementation class AdminCategoryEditServlet
 */
@WebServlet("/admin/CategoryEdit")
public class AdminCategoryEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminCategoryEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);

		TypeDao typeDao = new TypeDao();
		Type type = typeDao.get(id);
		request.setAttribute("type", type);
		request.getRequestDispatcher("/admin_category_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		String typename1 = request.getParameter("typename");

		TypeDao typeDao = new TypeDao();
		if ("delete".equals(action)) {
			typeDao.delete(id);
		} else {
			String typename = new String(typename1.getBytes("ISO-8859-1"), "UTF-8");
			if (typename == null || "".equals(typename)) {
				request.setAttribute("error", "分类名称不能为空");
				doGet(request, response);
				return;

			}

			boolean isExists = typeDao.exists(typename);
			if (isExists) {
				request.setAttribute("error", "分类名称已经存在");
				doGet(request, response);
				return;
			}

			typeDao.edit(id, typename);
		}
		response.sendRedirect(request.getContextPath() + "/admin/Category");

	}
}
