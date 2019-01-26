package controllers;

import application.ShadowEffect;
import application.TodayGoal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;

public class HomeController extends MasterController {
	@FXML
	private Button testBtn;

	@FXML
    private Label goalLabel_1;

    @FXML
    private Label goalLabel_2;

    @FXML
    private Label goalLabel_3;

    @FXML
    private Label goalLabel_4;

    @FXML
    private ProgressBar progressBar_1;

    @FXML
    private ProgressBar progressBar_2;

    @FXML
    private ProgressBar progressBar_3;

    @FXML
    private ProgressBar progressBar_4;

    @FXML
    private Label rateLabel_1;

    @FXML
    private Label rateLabel_2;

    @FXML
    private Label rateLabel_3;

    @FXML
    private Label rateLabel_4;

    private Label[] goalLabels = {goalLabel_1,goalLabel_2,goalLabel_3,goalLabel_4};
    private ProgressBar[] progressBars = {progressBar_1,progressBar_2,progressBar_3,progressBar_4};
    private Label[] rateLabels = {rateLabel_1,rateLabel_2,rateLabel_3,rateLabel_4};
	private TodayGoal t;

	@FXML
    public void onTestBtn(ActionEvent event) {

    }
    @FXML
    public void onTestBtnPress(MouseEvent event) {
    	ShadowEffect.setColor(orangePressShadowColor);
    	ShadowEffect.setInnerShadow(testBtn);
    }
    @FXML
    public void onTestBtnExit(MouseEvent event) {
    	ShadowEffect.setColor(orangeExitShadowColor);
    	ShadowEffect.setDropShadow(testBtn);
    }
}
