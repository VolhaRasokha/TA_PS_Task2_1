package by.epam.ta.ps.task2_1.service.find;

import java.util.ArrayList;
import java.util.List;

import by.epam.ta.ps.task2_1.entity.Candy;
import by.epam.ta.ps.task2_1.entity.Sweets;

public class FindCandyByTypeManufacturer implements Findable {
	private String candyType;
	private String manufacturer;

	public FindCandyByTypeManufacturer(String candyType, String manufacturer) {
		this.candyType = candyType;
		this.manufacturer = manufacturer;
	}

	@Override
	public List<Sweets> find(List<Sweets> presents) {
		List<Sweets> sweetInPresents = new ArrayList<Sweets>();

		for (int i = 0; i < presents.size(); i++) {
			if (presents.get(i) instanceof Candy) {
				Candy obj = (Candy) presents.get(i);
				if (candyType == obj.getCandyType() & manufacturer == obj.getManufacturer()) {
					
					sweetInPresents.add(obj);
				}
			}
		}
		return sweetInPresents;
	}

}
