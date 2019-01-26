package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.StringJoiner;

public class DatabaseConnection {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private String db;
	private String user;
	private String pass;
	public  DatabaseConnection(String filePath) {
		try {
			Scanner sc = new Scanner(new File(filePath),"UTF-8");
			db = "jdbc:mysql://"+sc.next()+"/"+sc.next();
			db = db + "?useUnicode=true&characterEncoding=utf8";
			user = sc.next();
			pass = sc.next();
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public ResultSet select(String sql,String value) throws SQLException {
		conn = DriverManager.getConnection(db,user,pass);
		pst = conn.prepareStatement(sql);
		pst.setString(1, value);
		rs = pst.executeQuery();
		return rs;

	}
	public ResultSet select(String sql) throws SQLException {
		conn = DriverManager.getConnection(db,user,pass);
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		return rs;

	}
	public void insert(String[] values,String table) throws SQLException {
		conn = DriverManager.getConnection(db,user,pass);
		StringJoiner sj = new StringJoiner(",", "(", ")");
		String sql = "insert into "+table+" values";
		for(int i = 0;i < values.length;i++) {
			sj.add("?");
		}
		sql = sql + sj.toString() + ";";
		pst = conn.prepareStatement(sql);
		for(int i = 0;i < values.length;i++) {
			pst.setString(i + 1, values[i]);
		}
		pst.executeUpdate();
	}

	public void insert(String[] columnNames,String[] values,String table) throws SQLException {
		conn = DriverManager.getConnection(db,user,pass);
		StringJoiner sj = new StringJoiner(",", "(", ")");
		String sql = "insert into "+table+" ";
		for(int i = 0;i < columnNames.length;i++) {
			sj.add(columnNames[i]);
		}
		sql = sql + sj.toString() + " values";
		sj = new StringJoiner(",", "(", ")");
		for(int i = 0;i < values.length;i++) {
			sj.add("?");
		}
		sql = sql + sj.toString() + ";";
		pst = conn.prepareStatement(sql);
		for(int i = 0;i < values.length;i++) {
			pst.setString(i + 1, values[i]);
		}
		pst.executeUpdate();
	}
	/**
	 * UPDATE実行
	 * @param keyColumnName 主キーカラム名
	 * @param keyValue 変更する行の主キーの値
	 * @param changeColumnName 変更する列のカラム名
	 * @param changeValue 変更する値
	 * @param table テーブル名
	 * @throws SQLException
	 */
	public void update(String keyColumnName,String keyValue,String changeColumnName,String changeValue,String table) throws SQLException {
		conn = DriverManager.getConnection(db,user,pass);
		pst = conn.prepareStatement("update " + table + " set " +
			changeColumnName + " = ? where " +
			keyColumnName + " = ?"
		);
		pst.setString(1, changeValue);
		pst.setString(2, keyValue);
		pst.executeUpdate();
	}
	/**
	 * DELETE実行
	 * @param keyColumnName 主キーカラム名
	 * @param keyValue 変更する行の主キーの値
	 * @param table テーブル名
	 * @throws SQLException
	 */
	public void delete(String keyColumnName,String keyValue,String table) throws SQLException {
		conn = DriverManager.getConnection(db,user,pass);
		pst = conn.prepareStatement("delete from " + table +
			" where " +
			keyColumnName + " = ?"
		);
		pst.setString(1, keyValue);
		pst.executeUpdate();
	}
	public void close() throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if(pst != null) {
			pst.close();
		}
		if(conn != null) {
			conn.close();
		}
	}
}
