package by.epam.ta.ps.task2_1.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import by.epam.ta.ps.task2_1.entity.NewYearPresent;
import by.epam.ta.ps.task2_1.entity.Sweets;
import by.epam.ta.ps.task2_1.exception.ExceptioNegativeWeight;
import by.epam.ta.ps.task2_1.exception.ExceptionOverloadWeight;
import by.epam.ta.ps.task2_1.service.find.Findable;
import by.epam.ta.ps.task2_1.service.read.ReadFromDB;
import by.epam.ta.ps.task2_1.service.read.ReadFromXml;

public class NewYearPresentService {

	public List<Sweets> find(NewYearPresent newYearPresent, Findable findMatcher) {
		List<Sweets> presents = newYearPresent.getPresent();
		List<Sweets> hasFined = null;
		hasFined = findMatcher.find(presents);
		return hasFined;
	}

	public double counWeight(NewYearPresent newYearPresent) throws ExceptioNegativeWeight, ExceptionOverloadWeight {
		double weightOfPresent = 0;
		for (int i = 0; i < newYearPresent.getPresent().size(); i++) {
			weightOfPresent = weightOfPresent + newYearPresent.getPresent().get(i).getWeight();
		}
		if (0 > weightOfPresent){
			throw new ExceptioNegativeWeight();
		} else if (weightOfPresent > 2000) {
			throw new ExceptionOverloadWeight();
		} else { return weightOfPresent;}
	}

	public void addCandyFromXML(NewYearPresent newYearPresent, ReadFromXml readResult)
			throws ParserConfigurationException, SAXException, IOException {

		for (Sweets newCandy : readResult.read()) {
			newYearPresent.add(newCandy);
			;
		}
	}

	public void addCandyFromDB(NewYearPresent newYearPresent, ReadFromDB readResult) throws SQLException {

		for (Sweets newCandy : readResult.read()) {
			newYearPresent.add(newCandy);
			;
		}

	}

}
