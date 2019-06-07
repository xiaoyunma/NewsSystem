package com.news.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.NewsDao;
import com.news.dao.TypeDao;
import com.news.dao.UserDao;
import com.news.model.News;
import com.news.model.Type;
import com.news.model.User;


/**
 * Servlet implementation class AdminNewsServlet
 */
@WebServlet("/admin/News")
public class AdminNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNewsServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TypeDao typeDao = new TypeDao();
		NewsDao newsDao = new NewsDao();
		List<News> news = newsDao.getAll();
		List<Type> types = typeDao.getAll();
		request.setAttribute("news", news);
		request.setAttribute("types", types);
		request.getRequestDispatcher("/admin_news.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//由于是中文，设置解码方式为utf-8
		request.setCharacterEncoding("utf-8");
		//获取选中的值
		boolean valid = false;
		String newstitle = request.getParameter("newstitle");
		String newscontent  = request.getParameter("newscontent");
		int typeid = Integer.parseInt(request.getParameter("newstype"));
		String newsimg = request.getParameter("newsimg");
		String userphone = request.getSession().getAttribute("userphone").toString();
		UserDao userDao = new UserDao();
		User user = userDao.get(userphone);
		//System.out.println(user.getUserID());
		int userid = user.getUserID();
		
		if (newstitle.equals("")) {
			request.setAttribute("error", "标题不能为空！");
			doGet(request, response);
		}
		if (newscontent.equals("")) {
			request.setAttribute("error", "新闻内容不能为空！");
			doGet(request, response);
		}
		// 从客户端接收参数
		if (newsimg.equals("")) {
			request.setAttribute("error", "新闻图片不能为空！");
			doGet(request, response);
		}else{
			valid = true;
		}  
		 System.out.println("从客户端接收到参数：" + "标题：" + newstitle + "内容：" + newscontent + "类型：" + typeid +"图片：" + newsimg + "UserID：" + userid );
		 NewsDao newsDao  = new NewsDao();
	     boolean state = newsDao.addNews(userid, typeid, newscontent,newstitle, newsimg);
	     if (state) {
				response.sendRedirect(request.getContextPath() + "/admin/Home");
				return;

			} else {
				request.setAttribute("error", "发布失败");
				doGet(request, response);
			}
		 
	}

}
