package controllers;

import java.sql.SQLException;

import application.Check;
import application.DatabaseConnection;
import application.Master;
import dialogs.ErrDialog;
import dialogs.InfoDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CoinAddController extends MasterController {
	@FXML
	private TextField coinName;
	@FXML
	private Button coinAddBtn;
	@FXML
	private Button cancelBtn;
	private int minlength = 1;
	private int maxlength = 20;
	private String[] columnNames = {"coinName"};
	private String tableName = "Coin";
	@FXML
	public void onCoinAddBtn(ActionEvent event) {
		// TODO Autogenerated
		String[] st = {coinName.getText()};
		if(Check.stringLengteCheck(minlength, maxlength, st[0])) {
			DatabaseConnection db = new DatabaseConnection(databaseFilePath);
			try {
				db.insert(columnNames, st, tableName);
				db.close();
				InfoDialog.coinAddDoneDialog(st[0]);
				Master.closeSubStage();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				ErrDialog.databaseErr();
			}
		}
		else {
			ErrDialog.lengthOverErr("コイン名", minlength, maxlength);
		}
	}
	// Event Listener on Button[#cancelBtn].onAction
	@FXML
	public void onCancelBtn(ActionEvent event) {
		// TODO Autogenerated
		Master.closeSubStage();
	}
}
