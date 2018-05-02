package by.epam.ta.ps.task2_1.service.read;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import by.epam.ta.ps.task2_1.entity.Sweets;

public interface Readable {
	List<Sweets> read() throws ParserConfigurationException, SAXException, IOException, SQLException;

}
