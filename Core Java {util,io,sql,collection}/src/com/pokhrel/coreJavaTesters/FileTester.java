package com.pokhrel.coreJavaTesters;

import com.pokhrel.io.FileHandler;

public class FileTester {

	public static void main(String[] args) {
		
		try {
		FileHandler fh = new FileHandler();
		
		fh.readFile("C:\\Users\\pokhr\\eclipse-workspace\\com.pokhrel.coreJava\\src\\com\\pokhrel\\io\\in.txt"); 
		
		fh.writeFile("C:\\Users\\pokhr\\eclipse-workspace\\com.pokhrel.coreJava\\src\\com\\pokhrel\\io\\out.txt");
		
		fh.writeFileWithAppend("C:\\Users\\pokhr\\eclipse-workspace\\com.pokhrel.coreJava\\src\\com\\pokhrel\\io\\appendOut.txt");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
