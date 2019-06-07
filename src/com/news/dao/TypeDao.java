package com.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.model.Type;
import com.news.util.ConnectHelper;
import java.lang.String;

public class TypeDao {

	public void addType(String typename) {
		Connection conn = ConnectHelper.openConnection();
		try {
			PreparedStatement stat = conn.prepareStatement("insert into type(TypeName) values(?)");
			stat.setString(1, typename);
			stat.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectHelper.colseQuietly(conn);
		}
	}

	public boolean exists(String typename) {
		boolean isExists = false;
		Connection conn = ConnectHelper.openConnection();
		try {
			PreparedStatement stat = conn.prepareStatement("select * from type where TypeName=?");
			stat.setString(1, typename);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				isExists = true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectHelper.colseQuietly(conn);
		}
		return isExists;
	}

	public List<Type> getAll() {

		List<Type> types = new ArrayList();

		Connection conn = ConnectHelper.openConnection();
		try {
			PreparedStatement stat = conn.prepareStatement("select * from type");
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				Type type = new Type();
				type.setId(rs.getInt("TypeID"));
				type.setTypename(rs.getString("TypeName"));
				types.add(type);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectHelper.colseQuietly(conn);
		}
		return types;
	}

	public Type get(int id) {
		Type type = new Type();
		Connection conn = ConnectHelper.openConnection();
		try {
			PreparedStatement stat = conn.prepareStatement("select * from type where TypeID = ?");
			stat.setInt(1, id);
			System.out.println(id);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				type.setId(rs.getInt("TypeID"));
				type.setTypename(rs.getString("TypeName"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectHelper.colseQuietly(conn);
		}

		return type;

	}

	public void edit(int id, String typename) {
		Connection conn = ConnectHelper.openConnection();
		try {
			PreparedStatement stat = conn.prepareStatement("update type set TypeName=? where TypeID=?");
			stat.setString(1, typename);
			stat.setInt(2, id);
			stat.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectHelper.colseQuietly(conn);
		}

	}

	public void delete(int id) {
		Connection conn = ConnectHelper.openConnection();
		try {
			PreparedStatement stat = conn.prepareStatement("delete from type where TypeID=?");
			stat.setInt(1, id);
			stat.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectHelper.colseQuietly(conn);
		}
	}

}
