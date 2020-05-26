package mock;

import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.math.RoundingMode;

import org.json.JSONException;
import org.json.JSONObject;

public class ReadWrite {

	public static void main(String[] args) throws IOException, JSONException {
		double[] arr = new double[10000];
		String sentence, word1;
		int cnt = 0;
		int i = 0;
		double total = 0.0;
		double maxi = 0.0;
		double temp;
		JSONObject ob = new JSONObject();
		JSONObject ob1 = new JSONObject();
		File file = new File("C:\\Users\\nadarajan\\Desktop\\Memory.txt");
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {

			while ((sentence = bf.readLine()) != null) {
				if (cnt % 2 != 0) {

					String word = sentence;
					word = word.replaceAll("[^0-9]", "");
					word = word.trim();

					temp = Integer.parseInt(word);

					arr[i++] = temp / 10000;

				}
				cnt++;
			}

			for (int j = 0; j < 938; j++) {
				word1 = String.format("%d", j);
				ob1.put(word1 + "s", arr[j]);
				if (maxi < arr[j])
					maxi = arr[j];
				total = total + arr[j];
			}

			double avg = total / 938;
			DecimalFormat decimal = new DecimalFormat("#.###");
			decimal.setRoundingMode(RoundingMode.CEILING);
			ob.put("AverageMemory(MB)", decimal.format(avg));
			ob.put("values: ", ob1);
			ob.put("MaximumMemory(MB)", decimal.format(maxi));
			System.out.println(ob);
			
			
		}
	}
}
