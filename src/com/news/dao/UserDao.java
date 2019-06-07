package com.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.news.model.News;
import com.news.model.Type;
import com.news.model.User;
import com.news.servlet.UserInfoServlet;
import com.news.util.ConnectHelper;

public class UserDao {

	public boolean login(String UserPhone, String UserPassword,String select) {
		boolean valid = false;
		Connection conn = ConnectHelper.openConnection();
		try {
			//System.out.println("UserDao类接收到参数："+"账号："+  UserPhone +"密码：" + UserPassword);
			PreparedStatement stat = conn.prepareStatement("select * from user where UserPhone=? and UserPassword=? and IsReader=?");
			stat.setString(1, UserPhone);
			stat.setString(2, UserPassword);
			stat.setString(3, select);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				valid = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectHelper.colseQuietly(conn);
		}
		return valid;
	}
	
	public User get(String userphone) {
		User user = new User();
		Connection conn = ConnectHelper.openConnection();
		try {
			PreparedStatement stat = conn.prepareStatement("select * from user where UserPhone = ?");
			stat.setString(1, userphone);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				user.setUserID(rs.getInt("UserID"));
			}
          //System.out.println(user.getUserID());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectHelper.colseQuietly(conn);
		}

		return user;

	}
	public User getinfo(String userphone) {
		User users = new User();
		Connection conn = ConnectHelper.openConnection();
		try {
			PreparedStatement stat = conn.prepareStatement("select * from user where UserPhone = ?");
			stat.setString(1, userphone);
			System.out.println(userphone);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				users.setUserID(rs.getInt("UserID"));
				users.setUserName(rs.getString("UserName"));
				users.setUserPhone(rs.getString("UserPhone"));
				users.setUserSex(rs.getString("UserSex"));
				users.setIsReader(rs.getString("IsReader"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectHelper.colseQuietly(conn);
		}

		return users;

	}
}
