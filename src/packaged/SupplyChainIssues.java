package packaged;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SupplyChainIssues {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\fajle\\eclipse-workspace\\AdventOfCode\\src\\stackedTall.txt"));

		List<Deque<Character>> stacks = stackCreator(br);

		String line = br.readLine();

		String numToMove = "";
		String columnFrom = "";
		String columnTo = "";

		while (line != null) {
			int moveThisMany = 0;
			int col1 = 0;
			int col2 = 0;

			boolean madeNum = false;
			
			for (int i = 0; i < line.length(); ++i) {

				if (isNum(line.charAt(i)) && moveThisMany == 0) {
					moveThisMany = getNumber(line, i);
					madeNum = true;
				} else if (moveThisMany != 0 && col1 == 0) {
					if (isNum(line.charAt(i))) {
						col1 = getNumber(line, i);
						madeNum = true;
					}
				} else if (moveThisMany != 0 && col1 != 0) {
					if (isNum(line.charAt(i))) {
						col2 = getNumber(line, i);
						break;
					}
				}
				
				if(madeNum) {
					++i;
					madeNum = false;
				}
				
			}

			int hi = 0;
			
			Deque<Character> fromMe = stacks.get(col1 - 1);
			Deque<Character> toMe = stacks.get(col2 - 1);

			Stack<Character> tempStack = new Stack();
			for(int i = 0; i < moveThisMany; ++i) {
				if(fromMe.peekFirst() != null){
					tempStack.push(fromMe.pollFirst());
				}
			}
			
			while(!tempStack.isEmpty()){
				toMe.addFirst(tempStack.pop());
			}

			line = br.readLine();
		}

		stacks.forEach(s -> System.out.println(s.peek()));

		System.exit(0);
	}

	private static boolean isNum(char c) {
		return Character.isDigit(c);
	}

	private static List<Deque<Character>> stackCreator(BufferedReader br) throws IOException {

		List<Deque<Character>> stacks = new ArrayList<>();
		String line = br.readLine();

		for (int i = 0; i < 9; ++i) {
			stacks.add(new LinkedList<Character>());
		}

		while (line != null) {
			int stackColumn = 0;

			if (line.contains("[")) {
				for (int i = 1; i <= 34; i += 4) {
					if (line.charAt(i) != ' ') {
						stacks.get(stackColumn).addLast(line.charAt(i));
					}
					++stackColumn;
				}
			}

			if (line.isBlank()) {
				break;
			}
			// am i having a stroke?
			line = br.readLine();
		}
		
//		List<List<Character>> stacks = new ArrayList<>();
//		String line = br.readLine();
//
//		for (int i = 0; i < 9; ++i) {
//			stacks.add(new LinkedList<Character>());
//			stacks.get(i).add('-');
//		}
//
//		while (line != null) {
//			int stackColumn = 0;
//
//			if (line.contains("[")) {
//				for (int i = 1; i <= 34; i += 4) {
//					if (line.charAt(i) != ' ') {
//						
//						List<Character> l = stacks.get(stackColumn);
//						l.add(l.size() - 1, line.charAt(i));
//					}
//					++stackColumn;
//				}
//			}
//
//			if (line.isBlank()) {
//				break;
//			}
//			// am i having a stroke?
//			line = br.readLine();
//		}

		return stacks;
	}

	private static int getNumber(String line, int i) {
		String numToMove = "";

		if (isNum(line.charAt(i))) {
			numToMove += line.charAt(i);
			++i;
			if (line.length() != i && isNum(line.charAt(i))) {
				numToMove += line.charAt(i);
			} else {
				return Integer.parseInt(numToMove);
			}
			return Integer.parseInt(numToMove);
		}

		return -1;
	}


}
