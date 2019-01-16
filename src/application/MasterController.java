package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;

public class MasterController implements Initializable  {
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
	private TodayGoal t;

	@FXML
    public void onTestBtn(ActionEvent event) {
    	DatabaseConnection.connect();
    	goalLabel_1.setText(DatabaseConnection.getUser());
    }
    @FXML
    public void onTestBtnPress(MouseEvent event) {
    	testBtn.setEffect(ShadowEffect.pushBtnMouseEffect());
    }
    @FXML
    public void onTestBtnExit(MouseEvent event) {
    	testBtn.setEffect(ShadowEffect.releaseBtnMouseEffect());
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO 自動生成されたメソッド・スタブ
		t = new TodayGoal(1, "英語勉強", 100, 1, 74);
		goalLabel_1.setText(t.getGoalName());
		rateLabel_1.setText(t.getAchievementRate() + "%");
		progressBar_1.setProgress(t.getAchievementRateDouble());
	}
}
