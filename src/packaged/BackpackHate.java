package packaged;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BackpackHate {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
				new FileReader(new File("/Users/ffriedegg/eclipse-workspace/AdventOfCode/src/backpackMadness.txt")));

		getElfBadgePrio(br);

	}

	public static void getElfBadgePrio(BufferedReader br) throws Exception {

		String elf = br.readLine();
		String elf2 = "";
		String elf3 = "";
		int numInElfGroup = 1;
		int totalElfGroups = 0;

		int badgeTotal = 0;
		boolean foundBadge = false;

		
		Map<Character, Integer> hs = new HashMap();

		while (elf != null) {
			
			if(numInElfGroup == 3) {
				for(int i = 0; i < elf.length(); ++i) {
					for(int j = 0; j < elf2.length(); ++j) {
						if(elf.charAt(i) == elf2.charAt(j)) {
							for(int k = 0; k < elf3.length(); ++k) {
								if(elf.charAt(i) == elf3.charAt(k)) {
									badgeTotal += getCharIntValue(elf.charAt(i));
									foundBadge = true;
									++totalElfGroups;
									break;
								}
							}
						}
						if(foundBadge) {
							break;
						}
					}
					if(foundBadge) {
						break;
					}
				}
				
				foundBadge = false;
				elf = br.readLine();
				numInElfGroup = 1;
			} else if (numInElfGroup == 2) {
				elf3 = br.readLine();
				++numInElfGroup;
			} else if (numInElfGroup == 1) {
				elf2 = br.readLine();
				++numInElfGroup;
			} else {
				
			}

//			for (int i = 0; i < elf.length(); ++i) {
//
//				if (!hs.keySet().contains(elf.charAt(i))) {
//					hs.put(elf.charAt(i), 1);
//					elfWhoInputKey = true;
//					keySeenForElf = true;
//				} else {
//					if (!keySeenForElf && !elfWhoInputKey) {
//						int currVal = hs.get(elf.charAt(i)) + 1;
//						currVal++;
//						hs.put(elf.charAt(i), currVal);
//						keySeenForElf = true;
//					}
//				}
//				elfWhoInputKey = false;
//			}
//
//			if (numInElfGroup == 3) {
//				for (Character c : hs.keySet()) {
//					if (hs.get(c) == 3) {
//						System.out.println(c);
//						badgeTotal += getCharIntValue(c);
//					}
//				}
//				++totalElfGroups;
//				numInElfGroup = 0;
//				hs.clear();
//			}
//			keySeenForElf = false;
//			++numInElfGroup;
//			elf = br.readLine();
		}

		System.out.println(badgeTotal + " " + totalElfGroups);
	}

	public static void getDuplicateItemPrio(BufferedReader br) throws Exception {
		int totalPriority = 0;
		int timesAddedToPriority = 0;

		boolean foundAMatch = false;

		String line = br.readLine();
		while (line != null) {

			String firstCompartment = line.substring(0, line.length() / 2);
			String secondCompartment = line.substring(line.length() / 2, line.length());

			for (int i = 0; i < firstCompartment.length(); ++i) {

				for (int j = 0; j < secondCompartment.length(); ++j) {
					if (firstCompartment.charAt(i) == secondCompartment.charAt(j)) {
						if (firstCompartment.charAt(i) >= 65 && firstCompartment.charAt(i) <= 90) {
							totalPriority += (firstCompartment.charAt(i) - 38);
							timesAddedToPriority++;
							System.out.println(firstCompartment.charAt(i));
							foundAMatch = true;
							break;
						} else {
							foundAMatch = true;
							timesAddedToPriority++;
							totalPriority += firstCompartment.charAt(i) - 96;
							break;
						}
					}
				}
				if (foundAMatch) {
					foundAMatch = false;
					break;
				}
			}
			System.out.println(
					firstCompartment + " Second: " + secondCompartment + " Current num added: " + timesAddedToPriority);

			line = br.readLine();
		}

		System.out.println(totalPriority + " " + timesAddedToPriority);

	}

	public static int getCharIntValue(char c) {
		if (c >= 65 && c <= 90) {
			System.out.println(c + "" + (c - 38));
			return c - 38;
		} else {
			return c - 96;
		}
	}
}
