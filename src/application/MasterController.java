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
import javafx.scene.layout.AnchorPane;

public class MasterController implements Initializable  {
	@FXML
	protected AnchorPane masterPane;
	@FXML
    protected AnchorPane homePane;

	@FXML
    protected AnchorPane coinPane;

	@FXML
    protected AnchorPane homeSelectSwitch;

    @FXML
    protected AnchorPane coinSelectSwitch;
	@FXML
    protected Button testBtn;

	@FXML
    protected Label goalLabel_1;

    @FXML
    protected Label goalLabel_2;

    @FXML
    protected Label goalLabel_3;

    @FXML
    protected Label goalLabel_4;

    @FXML
    protected ProgressBar progressBar_1;

    @FXML
    protected ProgressBar progressBar_2;

    @FXML
    protected ProgressBar progressBar_3;

    @FXML
    protected ProgressBar progressBar_4;

    @FXML
    protected Label rateLabel_1;

    @FXML
    protected Label rateLabel_2;

    @FXML
    protected Label rateLabel_3;

    @FXML
    protected Label rateLabel_4;

    protected Label[] goalLabels = {goalLabel_1,goalLabel_2,goalLabel_3,goalLabel_4};
    protected ProgressBar[] progressBars = {progressBar_1,progressBar_2,progressBar_3,progressBar_4};
    protected Label[] rateLabels = {rateLabel_1,rateLabel_2,rateLabel_3,rateLabel_4};
	protected TodayGoal t;
	/**
	 * nowDisplay 現在表示している画面
	 */
	private AnchorPane nowDisplay;
	/**
	 * nowSwitch 現在表示しているページのスイッチ
	 */
	private AnchorPane nowSwitch;
	/**
	 * 押しているときの影エフェクトの色(オレンジ系統)
	 */
	private String orangePressShadowColor = "903700";
	/**
	 * 離しているときの影エフェクトの色(オレンジ系統)
	 */
	private String orangeExitShadowColor = "5b2100";
	private HomePane homePaneIns;

	@FXML
    public void onTestBtn(ActionEvent event) {
    	DatabaseConnection maindb = new DatabaseConnection("database/.database");
    	goalLabel_1.setText(maindb.getUser());

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
    @FXML
    void onCoinSelectSwitch(MouseEvent event) {
    	displaySwitching(coinPane,coinSelectSwitch);
    }

    @FXML
    void onHomeSelectSwitch(MouseEvent event) {
    	displaySwitching(homePane,homeSelectSwitch);
    	homePaneIns = new HomePane();

    }
    private void displaySwitching(AnchorPane mainPane,AnchorPane switchPane) {
    	nowDisplay.setVisible(false);
    	nowSwitch.setId("");
    	nowSwitch.setEffect(null);
    	nowDisplay = mainPane;
    	nowSwitch = switchPane;
    	mainPane.setVisible(true);
    	switchPane.setId("selectedSwitch");
    	ShadowEffect.setColor(orangePressShadowColor);
    	ShadowEffect.setInnerShadow(switchPane);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO 自動生成されたメソッド・スタブ
		nowDisplay = homePane;
		nowSwitch = homeSelectSwitch;
		nowSwitch.setId("selectedSwitch");

		ShadowEffect.setColor(orangePressShadowColor);
    	ShadowEffect.setInnerShadow(nowSwitch);
	}
}
