package by.epam.ta.ps.task2_1.entity;

public class OtherSweets extends Sweets{
	private String kindSweets;
	
	public OtherSweets(String sweetName, double weight, int count, String manufacturer, String kindSweets){
		super(sweetName, weight, count, manufacturer);
		this.setKindSweets(kindSweets);
	}

	public String getKindSweets() {
		return kindSweets;
	}

	public void setKindSweets(String kindSweets) {
		this.kindSweets = kindSweets;
	}

}
