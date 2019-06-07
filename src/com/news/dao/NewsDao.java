package com.news.dao;

import com.news.model.User;
import com.news.util.ConnectHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.news.model.News;
import com.news.model.Type;

public class NewsDao {

	public boolean addNews(Integer userid, Integer typeid, String newscontent, String title, String newsimg) {
		boolean state = false;
		File file = new File("E:/eclipse-workspace/NewsSystem/WebContent/img/" + newsimg);
		Connection conn = ConnectHelper.openConnection();

		try {
			FileInputStream fin = new FileInputStream(file);
 			ByteBuffer nbf  = ByteBuffer.allocate((int) file.length());
			byte[] array  = new byte[1024];
			int  offset = 0, length = 0;
			while((length = fin.read(array)) > 0) {
				if (length != 1024) 
					nbf.put(array,0,length);
				else
					nbf.put(array);
				offset += length;
			}
			
			byte[] content = nbf.array();
 			PreparedStatement stat = conn.prepareStatement(
					"insert into news values (null,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stat.setInt(1, userid);
			stat.setInt(2, typeid);
			stat.setString(3, newscontent);
			stat.setTimestamp(4, new Timestamp(new Date().getTime()));
			stat.setString(5, title);
			stat.setBytes(6, content);
			int rows = stat.executeUpdate();
			// 执行完sql语句之后 使用查询对象可以获取当前这条语句执行之后生成的主键数据
			ResultSet rs = stat.getGeneratedKeys();
			// 定义一个变量保存生成的USeriD
			int newsid = 0;

			if (rs.next()) {
				newsid = rs.getInt(1);
			}

			if (rows > 0) {
				// 向客户端响应信息
				state = true;
			} else {
				state = false;
			}
			fin.close();
			System.out.println("图片记录已经加载");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectHelper.colseQuietly(conn);
		}
		return state;

	}
	
	public List<News> getAll() {

		List<News> news = new ArrayList();

		Connection conn = ConnectHelper.openConnection();
		try {
			PreparedStatement stat = conn.prepareStatement("select * from news");
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				News news2 = new News();
				news2.setNewsID(rs.getInt("NewsID"));
				news2.setNewsTitle(rs.getString("NewsTitle"));
				news2.setNewsTime(rs.getTimestamp("NewsTime"));
				news2.setTypeID(rs.getInt("TypeID"));
				news2.setUserID(rs.getInt("UserID"));
				news.add(news2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectHelper.colseQuietly(conn);
		}
		return news;
	}
	
	public News get(int newsid) {
		News news2 = new News();
		Connection conn = ConnectHelper.openConnection();
		try {
			PreparedStatement stat = conn.prepareStatement("select * from news where NewsID = ?");
			stat.setInt(1, newsid);
			System.out.println(newsid);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				news2.setNewsID(rs.getInt("NewsID"));
				news2.setNewsTitle(rs.getString("NewsTitle"));
				news2.setNewsContent(rs.getString("NewsContent"));
				news2.setNewsTime(rs.getTimestamp("NewsTime"));
				//news2.setNewsImg(rs.getBytes("NewsImg");
				news2.setTypeID(rs.getInt("TypeID"));
				news2.setUserID(rs.getInt("UserID"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectHelper.colseQuietly(conn);
		}

		return news2;

	}

}
