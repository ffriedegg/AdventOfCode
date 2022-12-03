package packaged;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BackpackHate {

	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\fajle\\eclipse-workspace\\AdventOfCode\\src\\backpackMadness.txt")));

		String line = br.readLine();
		while(line != null) {
			
			String firstCompartment = line.substring(0, line.length()/2);
			String secondCompartment = line.substring(line.length()/2, line.length());
			
			System.out.println(firstCompartment + " Second: " + secondCompartment);
			
			
			System.exit(0);
			
			line = br.readLine();
		}
	}
}
