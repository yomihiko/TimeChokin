package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseConnection {
	private static Connection conn;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String db;
	private static String user;
	private static String pass;
	public DatabaseConnection() {
		try {
			Scanner sc = new Scanner(new File("database/.database"),"UTF-8");
			db = "jdbc:mysql://"+sc.next()+"/"+sc.next();
			user = sc.next();
			pass = sc.next();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public static ResultSet select(String sql,String value) {
		try {
			conn = DriverManager.getConnection(db,user,pass);
			pst = conn.prepareStatement(sql);
			pst.setString(1, value);
			rs = pst.executeQuery();
			return rs;

		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public static ResultSet select(String sql) {
		try {
			conn = DriverManager.getConnection(db,user,pass);
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			return rs;

		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public static void insert(String[] values,String table) {
		try {
			conn = DriverManager.getConnection(db,user,pass);
			String sql = "insert into "+table+" values(";
			for(int i = 0;i < values.length;i++) {
				if(i == 0) {
					sql = sql +  "?";
				}
				else {
					sql = sql + ",?";
				}
			}
			sql = sql + ");";
			pst = conn.prepareStatement(sql);
			for(int i = 0;i < values.length;i++) {
				pst.setString(i + 1, values[i]);
			}
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public static void close() {
		try {
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
