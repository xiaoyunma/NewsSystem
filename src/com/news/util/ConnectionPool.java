package com.news.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionPool {//创建JDBC连接池
          
	private static Map<String, ConnectionPool> pools = new HashMap<String, ConnectionPool>();
	static {
		// 读取连接池配置，这里直接把连接信息写在代码中
		try {
			ConnectionPool a = new ConnectionPool("com.mysql.jdbc.Driver",
					"jdbc:mysql://localhost:3306/newsdata?useUnicode=true&characterEncoding=utf-8&user=root&password=1234");
			pools.put("a", a);
			ConnectionPool b = new ConnectionPool("com.mysql.jdbc.Driver",
					"jdbc:mysql://localhost:3306/newsdata?useUnicode=true&characterEncoding=utf-8&user=root&password=1234");
			pools.put("b", b);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionPool getPool(String poolName) {
		return pools.get(poolName);

	}

	private ConnectionPool(String driver, String url) throws ClassNotFoundException {
		Class.forName(driver);
		this.url = url;
	}

	private String url;
	// 当前空闲的数据库链接集合
	private List<Connection> freeConnections = new ArrayList<Connection>();
	// 当前为特定模块提供服务的数据库链接集合
	private List<Connection> busyConnections = new ArrayList<Connection>();

	public synchronized Connection getConnection() throws SQLException {
		if (this.freeConnections.size() > 0) {
			Connection result = this.freeConnections.remove(this.freeConnections.size() - 1);
			this.busyConnections.add(result);
			return result;
		}
		Connection result = DriverManager.getConnection(url);
		this.busyConnections.add(result);
		return result;

	}

	public synchronized void release(Connection conn) {
		this.busyConnections.remove(conn);
		this.freeConnections.add(conn);
	}

	public static void main(String[] args) {
		try {
			Connection conn = ConnectionPool.getPool("a").getConnection();
			// 业务代码
			ConnectionPool.getPool("a").release(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
