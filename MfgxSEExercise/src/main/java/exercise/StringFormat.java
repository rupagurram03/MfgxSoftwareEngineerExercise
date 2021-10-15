package exercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.vdurmont.emoji.EmojiParser;

public class StringFormat {

	public static void main(String[] args) throws java.text.ParseException {
		
		String formatSubString = new String();
		int maxViews = 100000;
		int maxLength = 140;
		
		JSONParser jsonParser = new JSONParser();
		
		try {
			FileReader reader = new FileReader(".\\chirpViews.json");

			Object obj = jsonParser.parse(reader);
			JSONArray chirpArray = (JSONArray) obj;
			
			for (int i = 0; i < chirpArray.size(); i++) {
				JSONObject chirpViews = (JSONObject) chirpArray.get(i);

				String message = (String) chirpViews.get("message");
				
				String author = (String) chirpViews.get("author");
				
				Long views = (Long) chirpViews.get("views");
				
				String date = (String) chirpViews.get("date");
				String formattedDate = formatDate(date); 
				
				if(views > maxViews) {
					String fire = EmojiParser.parseToUnicode("🔥");
					formatSubString = String.format("%s %d %s %s", formattedDate, views, author, fire);
				} else {
					formatSubString = String.format("%s %d %s", formattedDate, views, author);
				}
				
				if(formatSubString.length() + message.length() >= maxLength) {
					String msg = formatMessage(message, maxLength - formatSubString.length());
					System.out.println("Formatted Output: "+ String.format("%s %s", msg, formatSubString));
				} else {
					System.out.println("Formatted output: " + String.format("%s %s", message, formatSubString));
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	static String formatMessage(String message, int n ) {
		message = message.substring(0, n-4);
		String s = new String("...");
		message = String.format("%s%s", message, s);
		
		return message;
	}
	
	static String formatDate(String date) throws java.text.ParseException {
		String[] dates = date.split("T");
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-MM-dd");
		Date fDate = dt.parse(dates[0]);
		SimpleDateFormat dt1 = new SimpleDateFormat("MM/dd/yyyy");
		return dt1.format(fDate);
	}

}
