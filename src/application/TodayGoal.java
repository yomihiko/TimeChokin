package application;

public class TodayGoal {
	private int goalID;
	private String goalName;
	private int amount;
	private int coinID;
	private int todayAmount;
	public TodayGoal(int gid,String gname,int amount,int cid,int tdamout) {
		this.goalID = gid;
		this.goalName = gname;
		this.amount = amount;
		this.coinID = cid;
		this.todayAmount = tdamout;
	}
	public int getAchievementRate() {
		double result;
		result = (double) todayAmount / (double) amount;
		result = result * 100;
		return (int) result;
	}
	public double getAchievementRateDouble() {
		double result;
		result = (double) todayAmount / (double) amount;

		return result;
	}
	public String getGoalName() {
		return goalName;
	}

}
