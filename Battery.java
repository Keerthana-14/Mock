package hackthon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Battery {

	public static void main(String[] args) throws IOException, JSONException {
		JSONObject ob = new JSONObject();
		String sentence = "", str = "", str1 = "";
		File file = new File("C:\\Users\\nadarajan\\Desktop\\battery.txt");
		BufferedReader bf = new BufferedReader(new FileReader(file));
		while ((sentence = bf.readLine()) != null) {
			if (sentence.equals(" Foreground activities:")) {
				str1= sentence.substring(27, 60);
			}
			//if (sentence.equals("Uid u0a202")) {
	
			//}

		}
    //double Battery_drain = Double.parseDouble(batteryDrain);
		//double percentage = Battery_drain / (double) 1000;
		

		ob.put("Foreground_time", str1);
		//System.out.println(str1);
	}
}
