package com.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.news.util.ConnectHelper;

public class RegisterDao {

	public boolean register(String UserPassword, String UserName, String UserSex, String UserPhone,String select) {
		boolean valid = false;
		Connection conn = ConnectHelper.openConnection();

		try {

			PreparedStatement stat = conn.prepareStatement("insert into user values(null,?,?,?,?,null,?)",
					Statement.RETURN_GENERATED_KEYS);

			stat.setString(1, UserPassword);
			stat.setString(2, UserName);
			stat.setString(3, UserSex);
			stat.setString(4, UserPhone);
			stat.setString(5, select);
			int rows = stat.executeUpdate();
			// 执行完sql语句之后 使用查询对象可以获取当前这条语句执行之后生成的主键数据
			ResultSet rs = stat.getGeneratedKeys();
			// 定义一个变量保存生成的USeriD
			int userid = 0;

			if (rs.next()) {
				userid = rs.getInt(1);
			}
			

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

}
