package ner.me.dev.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Zchumager
 *
 */

public class ProjectUtils {
	private static String workingDirectory = "";
	private static File file = null;
	private static FileInputStream fis = null;
	private static FileReader fr = null;
	private static BufferedReader br = null;
	private static FileOutputStream fos = null;
	private static FileWriter fw = null;
	private static BufferedWriter bw = null;
	
	static {
		workingDirectory = System.getProperty("user.dir");
	}	
	
	public static String getWorkingDirectory() {
		return workingDirectory;
	}
	
	/**
	 * 
	 * @param path example C:\Users\Zchumager\Software Development\
	 * @param filename example lorem_ipsum.txt
	 * @return
	 */
	public static File createFile(String path, String filename) {
		String filePath = path + "\\" + filename;
		System.out.println("File path : " + filePath);
		file = new File(filePath);
		return file;
	}
	
	public static FileInputStream createFileInputStream(File file) {
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.err.println("File" + file.getName()
				+ " cannot be loaded into the FileInputStream");
			e.printStackTrace();
		}
		return fis;
	}
	
	public static FileReader createFileReader(File file) {
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.err.println("File" + file.getName()
				+ " cannot be loaded into the FileReader");
			e.printStackTrace();
		}
		return fr;
	}
	
	public static BufferedReader createBufferedReader(File file) {
		br = new BufferedReader(createFileReader(file));
		return br;
	}
	
	
	public static FileOutputStream createFileOutputStream(File file) {
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			System.err.println("File" + file.getName()
				+ " cannot write into the FileOutputStream");
			e.printStackTrace();
		}
		return fos;
	}
	
	public static FileWriter createFileWriter(File file) {
		try {
			fw = new FileWriter(file);
		} catch (IOException e) {
			System.err.println("File" + file.getName()
				+ " cannot write into the FileWriter");
			e.printStackTrace();
		}
		return fw;
	}
	
	public static BufferedWriter createBufferedWriter(File file) {
		bw = new BufferedWriter(ProjectUtils.createFileWriter(file));
		return bw;
	}
}
