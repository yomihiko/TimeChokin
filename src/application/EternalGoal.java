package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import dialogs.ErrDialog;
import dialogs.InfoDialog;

public class EternalGoal extends Data {
	/**
	 * ID
	 */
	private int id;
	/**
	 * 目標は何時間か
	 */
	private int amount;
	/**
	 * コインID
	 */
	private int coinID;
	private String fxmlEditID;
	private String fxmlDelID;
	private String[] columnNames = {"Amount","CoinID"};
	private String tableName = "EternalGoal";
	private String keyName = "ID";
	/**
	 * 目標の最小時間(分)
	 */
	private int mintime = 1;
	/**
	 * 目標の最大時間(分)
	 */
	private int maxtime = 1439;

	private boolean flag = false;


	public void set(int id,int amount,int coinID) {
		this.id = id;
		this.amount = amount;
		this.coinID = coinID;
		fxmlEditID = "edit" + id;
		fxmlDelID = "del" + id;
		flag = true;
	}
	public void set(int amount,int coinID) {
		if(betweenNum(amount, mintime, maxtime)) {
			this.amount = amount;
			this.coinID = coinID;
			flag = true;
		}
		else {
			ErrDialog.internalErr("目標時間", mintime, maxtime);
		}
	}
	public void set(int amount) {
		if(betweenNum(amount, mintime, maxtime)) {
			this.amount = amount;
			flag = true;
		}
		else {
			ErrDialog.internalErr("目標時間", mintime, maxtime);
		}
	}
	/**
	 * IDが一致するかどうか
	 * @param editID 調べるID
	 * @return boolean
	 */
	public boolean editCheck(String editID) {
		if(editID.equals(fxmlEditID)) {
			return true;
		}
		return false;
	}
	public String getEditID() {
		return fxmlEditID;
	}
	public String getDelID() {
		return fxmlDelID;
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
		String[] values = {Integer.toString(amount),Integer.toString(coinID)};
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
	public void update() {
		if(flag == false) {
			return;
		}
		try {
			DatabaseConnection db = new DatabaseConnection(filepath);
			db.update(keyName, Integer.toString(id), columnNames[0], Integer.toString(amount), tableName);
			db.close();
		} catch (SQLException e) {
			ErrDialog.databaseErr();
		}
	}
	public void delete() {
		if(flag == false) {
			return;
		}
		try {
			DatabaseConnection db = new DatabaseConnection(filepath);
			db.delete(keyName, Integer.toString(id), tableName);
			db.close();
		} catch (SQLException e) {
			ErrDialog.databaseErr();
		}
	}
}
