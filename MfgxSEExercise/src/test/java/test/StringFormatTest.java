package test;

import static org.junit.Assert.assertEquals;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import exercise.StringFormat;

public class StringFormatTest {

	StringFormat format = new StringFormat();
	
	@Test
	public void messageFormatTest() {
		String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam consequat quis turpis non consectetur. Sed accumsan dui rhoncus, cursus quis.";
		
		String expectedMsg = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam consequat quis turpis non consectetur. S...";
		
		String actual = format.formatMessage(message, 140 - 33);
		
		assertEquals(expectedMsg, actual);
	}
	
	@Test
	public void dateFormatTest() throws ParseException, java.text.ParseException {
		String date = "2021-03-04T04:00:00.000Z";
		
		String expectedDate = "03/04/2021";
		
		String actual = format.formatDate(date);
		
		assertEquals(expectedDate, actual);
	}


}
