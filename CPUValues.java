package hackthon;

import java.util.*;
import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class CPUValues {

	public static void main(String[] args) throws IOException {
		JSONObject ob = new JSONObject();
		JSONObject ob1 = new JSONObject();
		JSONObject ob2 = new JSONObject();
		double[] array1 = new double[10000];
		File file = new File("C:\\Users\\nadarajan\\Desktop\\CPU.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			int val = 0,j,i=0;
			int cnt = 0, start = 0;
			String Str, Str1,result,value;
			String readLine;
			double Tempval, maxi = 0.0, total = 0.0;
			while ((readLine = br.readLine()) != null) {
				cnt += 1;
				StringTokenizer StringToken = new StringTokenizer(readLine);
				while (StringToken.hasMoreTokens()) {
					Str1 = StringToken.nextToken();
					start += 1;
					if (start == 9) {
						value = Str1;
						Tempval = Double.parseDouble(value);
						array1[i++] = Tempval;
						start = 0;
						break;
					}
				}
			}
			for (j = 0; j < cnt; j++) {
				val = j + 1;
				Str = String.format("%d", val);
				result = String.format("%.1f", array1[j]);
				ob1.put(Str + "s", result);
				if (array1[j] > maxi) {
					maxi = array1[j];
				}
				total = total + array1[j];
				val = 0;
			}
			double avg = total / cnt;
			String avg1 = String.format("%.2f", avg);
			String maximum = String.format("%.2f", maxi);
			ob.put("values: ", ob1);
			ob.put("maxcpu", maximum);
			ob.put("avgcpu", avg1);
			ob2.put("sampletransaction", ob);
			JSONArray jlist = new JSONArray();
			jlist.add(ob2);
			try (FileWriter file1 = new FileWriter("C:\\Users\\nadarajan\\Desktop\\op.json")) {
				file1.write(jlist.toString());
				file1.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
