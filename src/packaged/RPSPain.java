package packaged;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class RPSPain {

	private static final int ROCK_SCORE = 1;// A
	private static final int PAPER_SCORE = 2;// B
	private static final int SCISSOR_SCORE = 3;// C

	private static final int ROUND_WON = 6;
	private static final int ROUND_DRAW = 3;

	public static void main(String[] args) throws Exception {

		// X = Enemy Rock
		// Y = Enemy Paper
		// Z = Enemy Scissor
		BufferedReader br = new BufferedReader(
				new FileReader(new File("C:\\Users\\fajle\\eclipse-workspace\\AdventOfCode\\src\\RPSPain.txt")));

		String line = br.readLine();
		int lineCount = 0;
		int finalScore = 0;

		while (line != null) {
			lineCount++;
			if (line.contains("X")) {//rockpath
				
				if(line.contains("A")) { 
					finalScore += SCISSOR_SCORE;
				} else if(line.contains("B")) {
					finalScore += ROCK_SCORE;
				} else if (line.contains("C")) { //scisssor beat who
					finalScore += PAPER_SCORE;
				}
				
			} else if (line.contains("Y")) { //draw
				
				finalScore += ROUND_DRAW;
				
				if(line.contains("A")) { 
					finalScore += ROCK_SCORE;
				} else if(line.contains("B")) {
					finalScore += PAPER_SCORE;
				} else if (line.contains("C")) { //scisssor beat who
					finalScore += SCISSOR_SCORE;
				}
				
				
			} else if(line.contains("Z")) {//win 
				
				finalScore += ROUND_WON;
				
				if(line.contains("A")) { 
					finalScore += PAPER_SCORE;
				} else if(line.contains("B")) {
					finalScore += SCISSOR_SCORE;
				} else if (line.contains("C")) { //scisssor beat who
					finalScore += ROCK_SCORE;
				}
				
			}
			
			line = br.readLine();
		}
		
		System.out.println(finalScore + " " + lineCount);
		
	}

}
