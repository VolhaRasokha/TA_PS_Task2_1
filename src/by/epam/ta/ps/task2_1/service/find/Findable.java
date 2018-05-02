package by.epam.ta.ps.task2_1.service.find;

import java.util.List;

import by.epam.ta.ps.task2_1.entity.Sweets;

public interface Findable {
	List<Sweets> find(List<Sweets> presents);
}
