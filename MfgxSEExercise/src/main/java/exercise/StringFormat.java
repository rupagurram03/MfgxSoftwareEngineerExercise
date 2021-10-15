package exercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StringFormat {

	public static void main(String[] args) {
		JSONParser jsonParser = new JSONParser();
		
		try {
			FileReader reader = new FileReader(".\\chirpViews.json");

			Object obj = jsonParser.parse(reader);
			JSONArray chirpArray = (JSONArray) obj;
			
			for (int i = 0; i < chirpArray.size(); i++) {
				JSONObject chirpViews = (JSONObject) chirpArray.get(i);

				String message = (String) chirpViews.get("message");
				System.out.println("Messge: "+ message);
				
				String author = (String) chirpViews.get("author");
				System.out.println("Author: "+author);
				
				Long views = (Long) chirpViews.get("views");
				System.out.println("Views: "+views);
				
				String date = (String) chirpViews.get("date");
				System.out.println("Date: "+date);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
