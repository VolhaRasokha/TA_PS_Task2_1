package by.epam.ta.ps.task2_1.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import by.epam.ta.ps.task2_1.entity.Candy;
import by.epam.ta.ps.task2_1.entity.NewYearPresent;
import by.epam.ta.ps.task2_1.entity.OtherSweets;
import by.epam.ta.ps.task2_1.entity.Sweets;
import by.epam.ta.ps.task2_1.exception.ExceptioNegativeWeight;
import by.epam.ta.ps.task2_1.exception.ExceptionOverloadWeight;
import by.epam.ta.ps.task2_1.service.NewYearPresentService;
import by.epam.ta.ps.task2_1.service.find.FindCandyByTypeManufacturer;
import by.epam.ta.ps.task2_1.service.find.Findable;
import by.epam.ta.ps.task2_1.service.read.ReadFromDB;
import by.epam.ta.ps.task2_1.service.read.ReadFromXml;
import by.epam.ta.ps.task2_1.service.sort.SweetsNameComparator;

public class AppTestDrive {

	public static void main(String[] args) {

		NewYearPresent myPresent = new NewYearPresent();
		myPresent.add(new Candy("Fudgenta", 100, 5, "Roshen", "Chocolate Candy"));
		myPresent.add(new Candy("Sweet lollipop", 150, 16, "Kommunarka", "Caramel"));
		myPresent.add(new Candy("Stolichnue Elite", 50, 4, "Kommunarka", "Chocolate Candy"));
		myPresent.add(new Candy("South night", 100, 2, "Kommunarka", "Chocolate Candy"));
		myPresent.add(new Candy("Madcap", 100, 5, "Kommunarka", "Iris"));
		myPresent.add(new Candy("Crazy bee", 80, 10, "Roshen", "Caramel"));
		myPresent.add(new OtherSweets("Vanilla", 100, 1, "Krasnu pishevik", "Marshmallows"));
		myPresent.add(new Candy("Belorusochka Bilberry", 120, 5, "Krasnu pishevik", "Chocolate Candy"));
		
		myPresent.add(new Candy("Belorusochka Bilberry", 120, 5, "Krasnu pishevik", "Chocolate Candy"));


		NewYearPresentService presentService = new NewYearPresentService();

		ReadFromXml readResultXML = new ReadFromXml();
		try {
			presentService.addCandyFromXML(myPresent, readResultXML);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		ReadFromDB readResultDB = new ReadFromDB();
		try {
			presentService.addCandyFromDB(myPresent, readResultDB);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			String[] newSweetsfromFile = new String[4];
			Path file_path = Paths.get("D:/workspace/TA_PS_Task2_1/src", "List_of_sweets.txt");

			List<String> lines = Files.readAllLines(file_path);

			for (String line : lines) {
				for (int i = 0; i < newSweetsfromFile.length; i++) {
					newSweetsfromFile = line.split(",");
				}
				myPresent.add(new Candy(newSweetsfromFile[0], Double.parseDouble(newSweetsfromFile[1]),
						Integer.parseInt(newSweetsfromFile[2]), newSweetsfromFile[3], newSweetsfromFile[0]));
			}
		} catch (IOException e) {
			System.out.println("\n");
			System.out.println("********************************************************");
			System.out.println("File has not been found! Please, check if the file exits");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("\n");
			System.out.println("********************************************************");
			System.out.println("Data from the file is not correct! Please, check!");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("\n");
			System.out.println("********************************************************");
			System.out.println("Something goes wrong. No present has been found...");
			e.printStackTrace();
		}

		
		System.out.println("******************************************************");
		System.out.println("Present (Sweets sorted by name)");
		System.out.println("******************************************************");

		Comparator<Sweets> comparatorByName = new SweetsNameComparator();
		Set<Sweets> sweetsSortedByName = new TreeSet<Sweets>(comparatorByName);
		for (int i = 0; i < myPresent.getPresent().size(); i++) {
			sweetsSortedByName.add(myPresent.getPresent().get(i));
		}
		for (Sweets elements : sweetsSortedByName) {
			System.out.print(elements.toString());
		}

		double weightOfPresent;
		try {
			weightOfPresent = presentService.counWeight(myPresent);
			System.out.println("\n----------------------------------------");
			System.out.println("Weight of Present is " + weightOfPresent + " gr.");
		} catch (ExceptioNegativeWeight e) {
			System.out.println("\n\nWeight of present cannot be < 0");
			e.printStackTrace();
		} catch (ExceptionOverloadWeight e) {
			System.out.println("\n\nWeight of present cannot be > 2000, plese remove some Sweets!");
			e.printStackTrace();
		}
		

		System.out.println("\n");
		System.out.println("******************************************************");
		System.out.println("Find candy in a present by type and manufacturer");
		System.out.println("******************************************************");

		Findable matcher = new FindCandyByTypeManufacturer("Chocolate Candy", "Kommunarka");
		List<Sweets> findResult = presentService.find(myPresent, matcher);

		System.out.println("O! We've found " + findResult.size() + " sweets!");
		for (Sweets elements : findResult) {
			System.out.print(elements);
		}

		System.out.println("\n");
		System.out.println("********************************************************");
		// Exception handling if the item is not in the collection
		try {
			System.out.println("Try to print Sweets, which does not exists on the index...");
			System.out.println(myPresent.getPresent().get(100));
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Sweets does not exist on this index! " + ex);
		}

		
	}

}
