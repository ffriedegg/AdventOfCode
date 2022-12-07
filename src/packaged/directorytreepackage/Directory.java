package packaged.directorytreepackage;

import java.util.ArrayList;
import java.util.List;

public class Directory {
	
	public Directory(String name) {
		super();
		file = new ArrayList<ElfFile>();
		directories = new ArrayList<>();
		this.name = name;
	}
	
	private String name;
	private List<ElfFile> file;
	private List<Directory> directories;
	
	
	public String getName() {
		return this.name;
	}
	
	public List<ElfFile> getFiles() {
		return file;
	}
	public void setFile(List<ElfFile> file) {
		this.file = file;
	}
	public List<Directory> getSubDirectory() {
		return directories;
	}
	public void setSubDirectory(List<Directory> subDirectory) {
		this.directories = subDirectory;
	}
	
	@Override
	public String toString() {
		return "Directory name " + name + " directory total size" + getTotalFileSizes();
	}
	
	public int getTotalFileSizes() {
		return file.stream().mapToInt(f -> f.getFileSize()).sum();
	}
}