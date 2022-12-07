package packaged;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Stack;

import packaged.directorytreepackage.Directory;
import packaged.directorytreepackage.ElfFile;

public class DirectoryTree {

	public static void main(String[] args) throws Exception {

		findThisNode();
		
		System.exit(0);
		
		BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\fajle\\eclipse-workspace\\AdventOfCode\\src\\directoryTreeInput.txt"));

		Directory mainDir = createDirectory(br);
		
		

	}

	private static Directory createDirectory(BufferedReader br) throws Exception {
		String line = br.readLine();
		line = br.readLine();

		Stack<String> directoryDepth = new Stack<>();
		directoryDepth.push("/");

		Directory main = new Directory("name");
		while (line != null) {
			if (line.contains("$")) {
				if (line.contains("ls")) {
					line = br.readLine();
				} else {
					if (line.contains("..")) {
						directoryDepth.pop();
						line = br.readLine();
					} else {
						String[] dirToFind = line.split(" ");
						Directory useMe = traverseTree(dirToFind[2], main);
						directoryDepth.push(useMe.getName());
						line = br.readLine();
					}
				}
			} else if (line.contains("dir")) {
				if (directoryDepth.peek().contains("/")) {
					main.getSubDirectory().add(new Directory(line.substring(4, line.length())));
					line = br.readLine();

				} else {
					Directory addHere = traverseTree(directoryDepth.peek(), main);

					addHere.getSubDirectory().add(new Directory(line.substring(4, line.length())));
					line = br.readLine();
				}
			} else if (Character.isDigit(line.charAt(0))) {
				String[] fileInfo = line.split(" ");

				if (directoryDepth.peek().contains("/")) {
					main.getFiles().add(new ElfFile(fileInfo[1], Integer.parseInt(fileInfo[0])));
					line = br.readLine();
				} else {
					Directory addHere = traverseTree(directoryDepth.peek(), main);
					addHere.getFiles().add(new ElfFile(fileInfo[1], Integer.parseInt(fileInfo[0])));
					line = br.readLine();
				}
			}
		}
		
		return main;
	}


	
	
	public static void findThisNode() {
		Directory directories = new Directory("main");
		for(int i = 0; i < 5; ++i) {
			directories.getSubDirectory().add(new Directory("thisNode" + i));
		}
		Directory turtle = new Directory("turtle");
		turtle.getFiles().add(new ElfFile("poopoohead.txt", 9001));
		directories.getSubDirectory().get(3).getSubDirectory().add(turtle);
		Map<String, Integer> total = findAllNodes(directories);
		int gimme = total.values().stream().mapToInt(Integer::intValue).sum();
		System.out.println(gimme);
	}
	
	private static int findAllNodes(Directory directories) {

		if(directories.getFiles().isEmpty()) return 0;
		
		for (Directory d : directories.getSubDirectory()) {
			if (d.getName().equals(nodeToFind)) {
				return d;
			} else {
				if (traverseTree(nodeToFind, d).getName().equals(nodeToFind)) {
					return traverseTree(nodeToFind, d);
				}
			}

		}

		return -1;
	}
	
	private static Directory traverseTree(String nodeToFind, Directory directories) {

		if (directories.getName().equals(nodeToFind))
			return directories;

		for (Directory d : directories.getSubDirectory()) {
			if (d.getName().equals(nodeToFind)) {
				return d;
			} else {
				if (traverseTree(nodeToFind, d).getName().equals(nodeToFind)) {
					return traverseTree(nodeToFind, d);
				}
			}

		}
		return directories;
	}

}
