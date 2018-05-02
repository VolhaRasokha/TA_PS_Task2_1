package by.epam.ta.ps.task2_1.entity;

public class Candy extends Sweets {
	private String candyType;

	public Candy(String sweetName, double weight, int count, String manufacturer, String candyType) {
		super(sweetName, weight, count, manufacturer);
		this.candyType = candyType;

	}

	public Candy() {
	}

	public String getCandyType() {
		return candyType;
	}

	public void setCandyType(String candyType) {
		this.candyType = candyType;
	}
	
	

}
