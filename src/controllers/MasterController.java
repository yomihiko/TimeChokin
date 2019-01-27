package controllers;

import application.Master;
import application.ShadowEffect;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MasterController{
	@FXML
	protected AnchorPane masterPane;
	@FXML
    protected AnchorPane homePane;


	@FXML
    protected AnchorPane homeSelectSwitch;

    @FXML
    protected AnchorPane coinSelectSwitch;
    @FXML
    protected AnchorPane goalSelectSwitch;
    @FXML
    protected AnchorPane resultSelectSwitch;
    /**
     * データベース情報設定ファイルのパス
     */
    protected String databaseFilePath = "database/.database";
	/**
	 * 離しているときの影エフェクトの色(オレンジ系統)
	 */
	protected String orangeExitShadowColor = "903700";
	/**
	 * 押しているときの影エフェクトの色(オレンジ系統)
	 */
	protected String orangePressShadowColor = "5b2100";
	//private HomePane homePaneIns;
    @FXML
    public void onCoinSelectSwitch(MouseEvent event) {
    	Master.switching("FXML/Coin.fxml",masterPane.getWidth(),masterPane.getHeight());
    }

    @FXML
    public void onHomeSelectSwitch(MouseEvent event) {
    	Master.switching("FXML/Home.fxml",masterPane.getWidth(),masterPane.getHeight());
    }

    @FXML
    public void onGoalSelectSwitch(MouseEvent event) {
    	Master.switching("FXML/Goal.fxml",masterPane.getWidth(),masterPane.getHeight());
    }

    @FXML
    public void onResultSelectSwitch(MouseEvent event) {
    	Master.switching("FXML/Result.fxml",masterPane.getWidth(),masterPane.getHeight());
    }
    @FXML
    public void onOrangeBtnPress(MouseEvent event) {
    	ShadowEffect.setColor(orangePressShadowColor);
    	System.out.println(event.getButton());
    	//ShadowEffect.setInnerShadow(event.getButton());
    }
    @FXML
    public void onOrangeBtnExit(MouseEvent event) {
    	ShadowEffect.setColor(orangeExitShadowColor);
    	//ShadowEffect.setDropShadow(event.getButton());
    }
}
