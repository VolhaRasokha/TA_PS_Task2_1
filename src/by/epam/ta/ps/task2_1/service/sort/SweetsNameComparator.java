package by.epam.ta.ps.task2_1.service.sort;

import java.util.Comparator;

import by.epam.ta.ps.task2_1.entity.Sweets;

public class SweetsNameComparator implements Comparator<Sweets> {
	
	@Override
	public int compare(Sweets obj1, Sweets obj2) {

		return obj1.getSweetName().compareTo(obj2.getSweetName());
	}
 
}
