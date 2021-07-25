import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class Inventory {
	public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
//read the json file
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader("C:\\Users\\HP\\java\\json\\Json\\JSON\\Inventory.json");

// Java Object variable
		Object inventory = jsonparser.parse(reader); // THis is my Main Object i.e which includes JSONParser,
														// JSONObject, JSONarray

// JSON Object ( after type casting)
		JSONObject inventoryobj = (JSONObject) inventory; // FIle Inventory.json it will parse the object to JSONObject
		JSONArray array = (JSONArray) inventoryobj.get("inventoryDetails"); // Change JSON Object to JSON Array.
		// getting inventory details
		for (int i = 0; i < array.size(); i++) {
			JSONObject inventoryDetails = (JSONObject) array.get(i);

			String name = (String) inventoryDetails.get("name");
			double weight = (double) inventoryDetails.get("weight");
			double pricePerKg = (double) inventoryDetails.get("pricePerKg");
			String type = (String) inventoryDetails.get("type");

			System.out.println("InventoryDetail " + i + " is ......");

			System.out.println("Name:" + name);
			System.out.println("Weight:" + weight);
			System.out.println("Price Per Kg:" + pricePerKg);
			System.out.println("Type:" + type);

			double value = weight * pricePerKg;
			System.out.println("Value for Inventory is:" + value);
		}

	}

}
