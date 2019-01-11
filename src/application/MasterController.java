package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;

public class MasterController implements Initializable  {
	@FXML
    private Button testBtn;
	@FXML
    private Label goalLabel_1;

    @FXML
    private Label rateLabel_1;
    @FXML
    private ProgressBar progressBar_1;
	private TodayGoal t;

    @FXML
    void OnTestBtn(ActionEvent event) {
    	System.out.println(t.getAchievementRate() + "%");
    	InnerShadow s = new InnerShadow();
    	s.setColor(Color.web("5b2100"));
    	s.setBlurType(BlurType.THREE_PASS_BOX);
    	testBtn.setEffect(s);
    	DatabaseConnection d = new DatabaseConnection();
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
