/**
 * 
 */
package com.ObjectOrientedProblems.InventoryJSON;
import java.io.FileReader;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
/**
 * @author BALU
 *
 */
public class InventoryJSON {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(".//JSONfile/Inventory.json"));
			JSONObject jsonObj=(JSONObject) obj;
			JSONArray inventoryDetails = (JSONArray) jsonObj.get("inventoryDetails");
			System.out.println(inventoryDetails);
			for (int i=0;i<3;i++) {
				JSONObject jsonObj1=(JSONObject) inventoryDetails.get(i);
				double value = jsonObj1.pricePerKg()*jsonObj1.weight();
				System.out.println("Total Value of "jsonObj1.type()+" of "+jsonObj1.name()+": "+value+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
