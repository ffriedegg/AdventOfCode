package packaged.directorytreepackage;

public class ElfFile {
	
	private int fileSize;
	
	private String fileName;
	
	public ElfFile(String name, int size) {
		this.fileName = name;
		this.fileSize = size;
	}
	
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String toString() {
		return "ElfFile name: " + fileName + " elfFile size: " + fileSize;
	}
}