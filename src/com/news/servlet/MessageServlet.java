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
import com.news.dao.UserDao;
import com.news.model.Message;
import com.news.model.News;
import com.news.model.User;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int newsid = (int) request.getSession().getAttribute("id");//提取会话信息
		NewsDao newsDao = new NewsDao();
		News news2 = newsDao.get(newsid);
		MessageDao messageDao = new MessageDao();
		List<Message> messages = messageDao.getAll(newsid);
		request.setAttribute("messages", messages);
		request.setAttribute("news2", news2);
		request.getRequestDispatcher("signle_news.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");//统一格式转换
		String userphone = request.getSession().getAttribute("userphone").toString();//提取会话信息
		System.out.println(userphone);
	
		int newsid = (int) request.getSession().getAttribute("id");//提取会话信息
		//System.out.println(newsid);
		UserDao userDao = new UserDao();
		User user = userDao.get(userphone);
		int userid = user.getUserID();
        String message = request.getParameter("msgcontent");
        if (message.equals("")) {
			request.setAttribute("error", "评论不能为空！");
			doGet(request, response);
		}else {
			 MessageDao messageDao = new MessageDao();
			 boolean valid = messageDao.addmessage(userid,newsid,message);
			 if (valid) {
					response.sendRedirect(request.getContextPath() + "/NewsServlet");
					return;

				} else {
					request.setAttribute("error", "评论失败");
					doGet(request, response);
				}
			 
		}
        
        
        
		
	}

}
