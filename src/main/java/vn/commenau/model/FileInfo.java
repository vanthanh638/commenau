package vn.commenau.model;

public class FileInfo {

	private String fileName;
	private long fileSize;
	
	public FileInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileInfo(String fileName, long fileSize) {
		super();
		this.fileName = fileName;
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	 
	
}
