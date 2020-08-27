package com.naver.db;

import java.sql.*;

public class DB {
	// 연결
	public static Connection conn() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USER, DBConfig.DB_PW);
		System.out.println("연결 성공");
		return conn;
	}
}