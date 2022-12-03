package packaged;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class CaloricElves {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\fajle\\eclipse-workspace\\AdventOfCode\\src\\elfCalories.txt")));
		TreeSet<Integer> elfTotals = new TreeSet<Integer>();

		int currElfTotal = 0;
		String line = br.readLine();
		while(line != null) {

			if (!line.isBlank()) {
				currElfTotal += Integer.parseInt(line);
			} else {
				elfTotals.add(currElfTotal);
				currElfTotal = 0;
			}
			line = br.readLine();
		}
		
		int last = elfTotals.last();
		
		int returnMe = elfTotals.pollLast();
		returnMe += elfTotals.pollLast();
		returnMe += elfTotals.pollLast();
		
		System.out.println(last + " " + returnMe);

	}

}
