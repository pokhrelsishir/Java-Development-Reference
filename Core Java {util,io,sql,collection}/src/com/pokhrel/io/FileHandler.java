package com.pokhrel.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	
	
	
	public void readFile(String fileName) {

		FileReader fr = null;

		BufferedReader br = null;

		try {
			File file = new File(fileName);

			fr = new FileReader(file);

			br = new BufferedReader(fr);

			String line = null;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();

			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}



	public void writeFile(String fileName) {
		
		File file = new File(fileName);
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file);

			bw = new BufferedWriter(fw);

			bw.write("Hello World...");
			bw.newLine();
			bw.write("Hello World...From Line 2");
			bw.newLine();
			bw.write("Hello World...From Line 3");
			bw.newLine();
			bw.write("This is writing to file from java...");

			bw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
public void writeFileWithAppend(String fileName) {
		
		File file = new File(fileName);
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file,true);

			bw = new BufferedWriter(fw);

			bw.write("Hello World...");
			bw.newLine();
			bw.write("Hello World...From Line 2");
			bw.newLine();
			bw.write("Hello World...From Line 3");
			bw.newLine();
			bw.write("This is writing to file from java with append which basically updates the file without replacing...");
			bw.newLine();
			bw.write("Hello World...I am a new append...!!!");
			
			bw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

	
