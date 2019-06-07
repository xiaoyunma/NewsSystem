package com.news.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//定义一个链接数据库工具类
public class ConnectHelper {
	// 定义一个方法连接数据库 并且返回连接数据库的对象
	static {
		try {
			// 1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection openConnection() {
		Connection conn = null;
		try {
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/newsdata?useUnicode=true&characterEncoding=utf-8", "root", "1234");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void colseQuietly(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
