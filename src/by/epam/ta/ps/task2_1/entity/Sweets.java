package by.epam.ta.ps.task2_1.entity;

public class Sweets {
	private String sweetName;	
	private double weight;
	private int count;
	private String manufacturer;
	
	public Sweets(String sweetName, double weight, int count, String manufacturer){
		this.sweetName = sweetName;
		this.setManufacturer(manufacturer);
		this.weight = weight;
		this.count = count;
	}
	
	public Sweets() {
	}

	public String getSweetName() {
		return sweetName;
	}
	public void setSweetName(String sweetName) {
		this.sweetName = sweetName;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@Override
	public String toString() {
		return "\n" + sweetName + " " + weight + " gr. " + count + " pieces " + "by " + manufacturer;
	}

	
}
