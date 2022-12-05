package packaged;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElfCleaningSeason {

	public static void main(String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\fajle\\eclipse-workspace\\AdventOfCode\\src\\elfCleaning.txt"));

		cleanUpAnyOverlap(br);
		
	}
	
	public static void cleanUpAnyOverlap (BufferedReader br) throws Exception {
		String line = br.readLine();
		int overLap = 0;
		List<Integer> elfNums = new ArrayList<>();
		
		while(line != null) {
			String numberString = "";
			
			elfNums = getLineNumbers(line, numberString);
			
			int num1 = elfNums.get(0);
			int num2 = elfNums.get(1);
			int num3 = elfNums.get(2);
			int num4 = elfNums.get(3);
			
			if(  ((num1 >= num3) && (num1 <= num4)) 
					|| ((num2 >= num3) && num2 <= num4)) {
				++overLap;
			} else if(((num3 >= num1) && (num3 <= num2)
					|| ((num4 >=num1) && num4 <= num2))) {
				++overLap;
			}
							
			elfNums.clear();
			line = br.readLine();

		}
		System.out.println(overLap);
	}

	//24-37,24-95
	
	
	private static List<Integer> getLineNumbers(String line, String numberString) {
		List<Integer> elfNums = new ArrayList<>();

		String [] stringList = line.split("-");
		
		Arrays.stream(stringList).forEach(System.out::println);
		
		System.exit(0);
		
		
//		
//		for(int i = 0; i < line.length(); ++i) { //this can all be reduced with regex
//			if(line.charAt(i) == '-' || line.charAt(i) == ',' || i+1 == line.length()) {
//				if(line.length() == i+1) {
//					numberString += line.charAt(i);
//				}
//				elfNums.add(Integer.parseInt(numberString));
//				numberString = "";
//			} else {
//				numberString += line.charAt(i);
//			}
//		}
		return elfNums;
	}
	
	public static void cleanUpFullOverlap(BufferedReader br) throws Exception {
		String line = br.readLine();
		int overLap = 0;
		List<Integer> elfNums = new ArrayList<>();
		
		while(line != null) {
			String numberString = "";
			
			elfNums = getLineNumbers(line, numberString);
			
			if((elfNums.get(0) >= elfNums.get(2)) && (elfNums.get(1) <= elfNums.get(3))) {
				++overLap;
			} else if((elfNums.get(2) >= elfNums.get(0)) && (elfNums.get(3) <= elfNums.get(1))) {
				++overLap;
			}		
							
			elfNums.clear();
			line = br.readLine();

		}
		
		System.out.println(overLap);
	}
}


//2-98,1-99