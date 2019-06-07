package com.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.news.model.Message;
import com.news.model.News;
import com.news.model.Type;
import com.news.util.ConnectHelper;

public class MessageDao {

	public boolean addmessage(int userid,int newsid,String msgcontent) {
		boolean valid = false;
		Connection conn = ConnectHelper.openConnection();

		try {

			PreparedStatement stat = conn.prepareStatement("insert into message values(null,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			stat.setInt(1, newsid);
			stat.setInt(2, userid);
			stat.setTimestamp(3, new Timestamp(new Date().getTime()));
			stat.setString(4, msgcontent);
			int rows = stat.executeUpdate();
			// 执行完sql语句之后 使用查询对象可以获取当前这条语句执行之后生成的主键数据
			ResultSet rs = stat.getGeneratedKeys();
		
			

			if (rows > 0) {
				// 向客户端响应信息
				valid = true;
			} else {
				valid = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectHelper.colseQuietly(conn);
		}

		return valid;
	}
	
	public List<Message> getAll(int newsid) {

		List<Message> messages = new ArrayList();

		Connection conn = ConnectHelper.openConnection();
		try {
			PreparedStatement stat = conn.prepareStatement("select * from message where NewsID=?");
			stat.setInt(1, newsid);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				Message message = new Message();
				message.setMsgID(rs.getInt("MsgID"));
				message.setUserID(rs.getInt("UserID"));
				message.setNewsID(rs.getInt("NewsID"));
				message.setMsgContent(rs.getString("MsgContent"));
				message.setMsgTime(rs.getDate("MsgTime"));
				messages.add(message);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectHelper.colseQuietly(conn);
		}
		return messages;
	}
	
	public Message get(int newsid) {
		Message message = new Message();
		Connection conn = ConnectHelper.openConnection();
		try {
			PreparedStatement stat = conn.prepareStatement("select * from message where NewsID = ?");
			stat.setInt(1, newsid);
			System.out.println(newsid);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				message.setNewsID(rs.getInt("NewsID"));
				message.setUserID(rs.getInt("UserID"));
				message.setMsgContent(rs.getString("MsgContent"));
				message.setMsgTime(rs.getTimestamp("MsgTime"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectHelper.colseQuietly(conn);
		}

		return message;

	}
}
