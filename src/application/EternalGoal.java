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
	private static  String[] columnNames = {"Amount","CoinID"};
	private static  String tableName = "EternalGoal";
	private static String keyName = "ID";
	/**
	 * 目標の最小時間(分)
	 */
	private int mintime = 1;
	/**
	 * 目標の最大時間(分)
	 */
	private int maxtime = 1439;

	private boolean flag = false;

	public static EternalGoal nowEdit;


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

	public static EternalGoal[] select(int count) {
		EternalGoal[] egs = new EternalGoal[count];
		EternalGoal tmp;
		try {
			DatabaseConnection db = new DatabaseConnection(filepath);
			ResultSet rs = db.select("select * from " + tableName);
			int index = 0;
			while(index < count && rs.next()) {
				tmp = new EternalGoal();
				tmp.set(rs.getInt(keyName),rs.getInt(columnNames[0]),rs.getInt(columnNames[1]));
				egs[index] = tmp;
				index++;
			}
			rs.close();
			db.close();
		}catch (SQLException e) {
			// TODO: handle exception
			ErrDialog.databaseErr();
			e.printStackTrace();
		}
		return egs;
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
	public double rate(int bank) {
		if(amount == 0) {
			return 0.0;
		}
		double tmp = (double) bank / (double) amount;
		if(tmp >= 1.0) {
			return 1.0;
		}
		return tmp;
	}
	public int getCoinID() {
		return coinID;
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
	public boolean update() {
		if(flag == false) {
			return false;
		}
		try {
			DatabaseConnection db = new DatabaseConnection(filepath);
			db.update(keyName, Integer.toString(id), columnNames[0], Integer.toString(amount), tableName);
			db.close();
			InfoDialog.changeDoneDialog(nowEdit.getCoinName());
			return true;
		} catch (SQLException e) {
			ErrDialog.databaseErr();
			return false;
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
