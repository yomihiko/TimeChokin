package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import dialogs.ErrDialog;
import dialogs.InfoDialog;

public class Bank extends Data {
	/**
	 * ID
	 */
	private int depositID;
	/**
	 * 目標は何時間か
	 */
	private int amount;

	/**
	 * 日にち
	 */
	private String date;
	/**
	 * コインID
	 */
	private int coinID;
	private static  String[] columnNames = {"Amount","Date","CoinID"};
	private static  String tableName = "Bank";
	private static String keyName = "DepositID";
	/**
	 * 目標の最小時間(分)
	 */
	private int mintime = 1;
	/**
	 * 目標の最大時間(分)
	 */
	private int maxtime = 1439;

	private boolean flag = false;


	public void set(int id,String date,int amount,int coinID) {
		this.depositID = id;
		this.amount = amount;
		this.coinID = coinID;
		this.date = date;
		flag = true;
	}
	public void set(String date,int amount,int coinID) {
		if(betweenNum(amount, mintime, maxtime)) {
			this.amount = amount;
			this.coinID = coinID;
			this.date = date;
			flag = true;
		}
		else {
			ErrDialog.internalErr("目標時間", mintime, maxtime);
		}
	}
	public void set(String date,int amount) {
		if(betweenNum(amount, mintime, maxtime)) {
			this.amount = amount;
			this.date = date;
			flag = true;
		}
		else {
			ErrDialog.internalErr("目標時間", mintime, maxtime);
		}
	}
	/**
	 * コイン名を取得
	 * @return コイン名
	 */
	public String getCoinName() {
		if(flag == false) {
			return "";
		}
		try {
			DatabaseConnection db = new DatabaseConnection(filepath);
			ResultSet rs = db.select("select CoinName from Coin where CoinID = ?", Integer.toString(coinID));
			rs.next();

			String name =  rs.getString("CoinName");
			rs.close();
			db.close();
			return name;
		}
		catch (SQLException e) {
			// TODO: handle exception
			return "";
		}
	}
	/**
	 * 目標時間を取得
	 * @return 目標時間(分)
	 */
	public int getAmount() {
		if(flag == false) {
			return -1;
		}
		return amount;
	}





	public boolean insert() {
		if(flag == false) {
			return false;
		}
		String[] values = {Integer.toString(amount),date,Integer.toString(coinID)};
		try {
			DatabaseConnection db = new DatabaseConnection(filepath);
			db.insert(columnNames, values, tableName);
			db.close();
			InfoDialog.goalAddDoneDialog();
			return true;
		} catch (SQLException e) {
			ErrDialog.databaseErr();
			return false;
		}
	}
	public static String getDate() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH) + 1;
	    int day = cal.get(Calendar.DATE);

	    return year + "-" + month + "-" + day;
	}

	public static int oneDaySum(String date,int coinID) {
		int sum = 0;
		try {
			DatabaseConnection db = new DatabaseConnection(filepath);
			ResultSet rs = db.select("select * from "+ tableName + " where "+ columnNames[1] + " = ? and CoinID = " + coinID, date);
			while(rs.next()) {
				sum += rs.getInt(columnNames[0]);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			ErrDialog.databaseErr();
		}
		return sum;
	}
	public static int allDaySum(int coinID) {
		int sum = 0;
		try {
			DatabaseConnection db = new DatabaseConnection(filepath);
			ResultSet rs = db.select("select * from "+ tableName + " where CoinID = ?" , Integer.toString(coinID));
			while(rs.next()) {
				sum += rs.getInt(columnNames[0]);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			ErrDialog.databaseErr();
		}
		return sum;
	}
}
