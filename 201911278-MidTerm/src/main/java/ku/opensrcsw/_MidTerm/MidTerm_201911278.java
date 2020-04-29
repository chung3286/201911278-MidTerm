package ku.opensrcsw._MidTerm;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class MidTerm_201911278 {
	public static void main(String[] args) {
		JSONParser jsonParser = new JSONParser();
		try {
			Scanner scan = new Scanner(System.in);
			String str = "";
			FileReader reader = new FileReader("midterm.json");

			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray infoArray = (JSONArray) jsonObject.get("poem");
			
			System.out.print("Enter the keyword you are looking for : ");
			String find = scan.nextLine();
			
			for(int i=0; i<infoArray.size(); i++) {
				JSONObject itemObject = (JSONObject) infoArray.get(i);
				str = itemObject.values().toString();
				String str2 = str.substring(1, str.length()-1);
				if(str2.contains(find)) {
					System.out.println("item " + i + ": " + str2);
					
				}
			}
			scan.close();
		}catch(IOException e) {
			System.out.println("Exception : " + e);
		}catch(ParseException pe) {
			System.out.println("Exception : " + pe);
		}
		
	}
}
