package controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Check;
import application.Coin;
import application.DatabaseConnection;
import application.Master;
import dialogs.ErrDialog;
import dialogs.InfoDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CoinController extends MasterController implements Initializable {

    @FXML
    private Button testBtn;
    @FXML
    private Button coinAddBtn;
    @FXML
    private Button changeBtn;
    @FXML
    private Button delBtn;
    @FXML
    private ComboBox<Coin> coinSelect;
    @FXML
    private TextField coinNameField;

    private String tableName = "Coin";
    private String coinIDColumnName = "coinID";
    private String coinNameColumnName = "coinName";
    /**
     * コイン名の最小文字数
     */
    private int coinNameMinLength = 1;
    /**
     * コイン名の最大文字数
     */
    private int coinNameMaxLength = 20;


    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO 自動生成されたメソッド・スタブ
    	updateComboBox();
	}
    @FXML
    public void onTestBtnPress(MouseEvent event) {

    }

    @FXML
    public void onTestBtnExit(MouseEvent event) {

    }
    /**
     * コイン追加ボタン
     * @param event
     */
    @FXML
    public void onCoinAddBtn(ActionEvent event) {
    	Master.newStage(400, 150, "コイン追加", "FXML/CoinAdd.fxml");
    	updateComboBox();
    }
    /**
     * 更新ボタン
     * @param event
     */
    @FXML
    public void onChangeBtn(ActionEvent event) {
    	DatabaseConnection d = new DatabaseConnection(databaseFilePath);
    	int id = coinSelect.getValue().getCoinID();
    	String st = coinNameField.getText();
    	if(Check.stringLengteCheck(coinNameMinLength,coinNameMaxLength, st) == false) {
    		ErrDialog.lengthOverErr("コイン名", coinNameMinLength,coinNameMaxLength);
    		return;
    	}
    	try {
			d.update(coinIDColumnName, Integer.toString(id), coinNameColumnName, st, tableName);
			InfoDialog.changeDoneDialog("コイン名");
			coinSelect.getValue().setCoinName(st);
			coinSelect.getItems().set(coinSelect.getValue().getIndex(), coinSelect.getValue());
			d.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			ErrDialog.databaseErr();
		}
    }
    /**
     * 削除ボタン
     * @param event
     */
    @FXML
    public void onDelbtn(ActionEvent event) {
    	String name = coinSelect.getValue().toString();
    	int id = coinSelect.getValue().getCoinID();
    	if(InfoDialog.deleteCheckDialog(name).get() == ButtonType.YES) {
    		DatabaseConnection d = new DatabaseConnection(databaseFilePath);
    		try {
				d.delete(coinIDColumnName, Integer.toString(id), tableName);
				updateComboBox();
				d.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				ErrDialog.databaseErr();
			}
    	}

    }
    @FXML
    public void onCoinSelect(ActionEvent event) {
    	if(coinSelect.getValue() != null) {
    		coinNameField.setText(coinSelect.getValue().toString());
    	}
    	else {
    		coinNameField.setText("");
    	}
    	setDisble(false);
    }
    /**
     * コンボボックスを更新
     */
    private void updateComboBox() {
    	DatabaseConnection db = new DatabaseConnection(databaseFilePath);
		ResultSet rs;
		try {
			coinSelect.getItems().clear();
			rs = db.select("select * from " + tableName);
			int index = 0;
			while(rs.next()) {
				Coin tmp = new Coin(index,rs.getInt(coinIDColumnName),rs.getString(coinNameColumnName));
				coinSelect.getItems().add(tmp);
				index++;
			}
			rs.close();
			db.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			ErrDialog.databaseErr();
		}
		setDisble(true);
    }
    /**
     * ボタンの選択可否の切替
     * @param f
     */
    private void setDisble(boolean f) {
    	changeBtn.setDisable(f);
    	delBtn.setDisable(f);
    	coinNameField.setDisable(f);
    }
}
