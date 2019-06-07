package com.news.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.MessageDao;
import com.news.dao.NewsDao;
import com.news.dao.TypeDao;
import com.news.model.Message;
import com.news.model.News;
import com.news.model.Type;

/**
 * Servlet implementation class SingleNewsServlet
 */
@WebServlet("/SingleNewsServlet")
public class SingleNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		request.getSession().setAttribute("id",id);//将newsid保存在整个会话期间  
		NewsDao newsDao = new NewsDao();
		News news2 = newsDao.get(id);
		MessageDao messageDao = new MessageDao();
		List<Message> messages = messageDao.getAll(id);
		request.setAttribute("messages", messages);
		request.setAttribute("news2", news2);
		request.getRequestDispatcher("signle_news.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
