package application;

public class Coin {
	private int index;
	private int coinID;
	private String coinName;
	public Coin(int index,int id,String name) {
		this.index = index;
		coinID = id;
		coinName = name;
	}
	public void setCoinName(String name) {
		coinName = name;
	}
	public int getCoinID() {
		return coinID;
	}
	public int getIndex() {
		return index;
	}
	@Override
	public String toString() {
		return coinName;
	}

}
