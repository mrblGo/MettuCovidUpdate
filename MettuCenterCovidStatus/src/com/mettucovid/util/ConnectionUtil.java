package com.mettucovid.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ConnectionUtil {

	// db connection method
		public static Connection getConnection() {

			// initialize connection name
			Connection conn = null;

			try {

				// configure to my database using driver manager
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mettucenter", "root", "");
				//conn = DriverManager.getConnection("jdbc:mysql://node1286-mettucentercovid19update.gpuoncloud.in/mettucenter", "root", "ASVgiq33391");
				//conn = DriverManager.getConnection("jdbc:mysql://node1311-env-5662773.gpuoncloud.in/mettucenter", "root", "QGHgog56825");
				
				

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return conn;

		}

		// closing connection
		public static void closeConnection(PreparedStatement ps, Connection conn) throws SQLException {
			ps.close();
			conn.close();

		}

		public static void closeConnection(PreparedStatement ps, ResultSet rs, Connection conn) throws SQLException {
			ps.close();
			rs.close();
			conn.close();

		}
		public static void main(String[] args) {
			System.out.println(ConnectionUtil.getConnection());
		}

}
