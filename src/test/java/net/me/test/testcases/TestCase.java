package net.me.test.testcases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ner.me.dev.utils.ProjectUtils;

public class TestCase {
	private String workingDirectory = ProjectUtils.getWorkingDirectory();
	private String filesDirectory = workingDirectory + "\\files";
	private String sourceFilename = "lorem_ipsum.txt";
	
	private File sourceFile = null;
	private File targetFile = null;
	private FileInputStream fis = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	
	@BeforeTest
	public void setup() {
		System.out.println("Working Directory : " + this.workingDirectory);
		System.out.println("Files Directory" + this.filesDirectory);
	}
	
	@Test(priority=1)
	public void createFiles() {
		this.sourceFile = ProjectUtils.createFile(filesDirectory, sourceFilename);
		this.fis = ProjectUtils.createFileInputStream(this.sourceFile);
		this.fr = ProjectUtils.createFileReader(this.sourceFile);
		this.br = ProjectUtils.createBufferedReader(this.sourceFile);
	}
	
	@Test(priority=2)
	public void testFileInputStream() {
		this.targetFile = ProjectUtils.createFile(this.filesDirectory, "targetFOS.txt");
		FileOutputStream fos = ProjectUtils.createFileOutputStream(targetFile);
		int b = 0;
		
		System.out.println("***************************************************************");
		try {
			while ((b = fis.read()) != -1) {
				System.out.print("|" + b + "|");
				fos.write(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=3)
	public void testFileWriter() {
		this.targetFile = ProjectUtils.createFile(this.filesDirectory, "targetFW.txt");
		FileWriter fw = ProjectUtils.createFileWriter(targetFile);
		
		System.out.println("***************************************************************");
		int c = 0;
		try {
			while((c = fr.read()) != -1) {
				System.out.print("|" + (char) c +"|");
				fw.write(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=4)
	public void testBufferedWriter() {
		this.targetFile = ProjectUtils.createFile(this.filesDirectory, "targetBW.txt");
		BufferedWriter bw = ProjectUtils.createBufferedWriter(targetFile);
		String line = null;
		
		System.out.println("***************************************************************");
		try {
			while((line = br.readLine())!= null){
				System.out.println("|" + line + "|");
				bw.write(line + "\n"); //Buffered Writer nativamente no reconoce los saltos de linea
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
