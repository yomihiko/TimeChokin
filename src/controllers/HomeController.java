package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Bank;
import application.EternalGoal;
import application.Master;
import application.ShadowEffect;
import application.TodayGoal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;

public class HomeController extends MasterController implements Initializable {


	int maxAmount = 4;
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

    private Label[] goalLabels;
    private ProgressBar[] progressBars;
    private Label[] rateLabels;
	private TodayGoal t;

	@FXML
    public void onTestBtn(ActionEvent event) {
		Master.newStage(400, 150, "貯金追加", "FXML/BankAdd.fxml");
		load();
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
    private void setVisible(boolean f,int index) {
    	goalLabels[index].setVisible(f);
    	progressBars[index].setVisible(f);
    	rateLabels[index].setVisible(f);
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO 自動生成されたメソッド・スタブ
		load();

	}
	private void load() {
		Label[] goalLabels = {goalLabel_1,goalLabel_2,goalLabel_3,goalLabel_4};
		ProgressBar[] progressBars = {progressBar_1,progressBar_2,progressBar_3,progressBar_4};
	    Label[] rateLabels = {rateLabel_1,rateLabel_2,rateLabel_3,rateLabel_4};
	    this.goalLabels = goalLabels;
	    this.progressBars = progressBars;
	    this.rateLabels = rateLabels;



	    String date;

	    EternalGoal[] egs = new EternalGoal[maxAmount];

	    date = Bank.getDate();

	    for(int index = 0;index < maxAmount;index++) {
	    	setVisible(false, index);
	    }

	    egs = EternalGoal.select(maxAmount);
	    for(int index = 0;index < maxAmount;index++) {
	    	if(egs[index] != null) {
	    		goalLabels[index].setText(egs[index].getCoinName());
	    		double rate = egs[index].rate(Bank.oneDaySum(Bank.getDate(),egs[index].getCoinID()));
	    		progressBars[index].setProgress(rate);
	    		rateLabels[index].setText((int)(rate * 100) + "%");
	    		setVisible(true, index);
	    	}
	    }
	}
}
