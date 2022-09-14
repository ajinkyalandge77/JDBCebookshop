package com.jdbc.assesement1;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {
	public static void main(String[] args) throws SQLException {
		Connection con = null;

		try {
			// connect to database
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "1135");

			System.out.println(" connected to database");
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery("select *from books");
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
