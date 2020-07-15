package com.pokhrel.stringManipulation;

public class StringManipulation {

	public static void main(String[] args) {
		
		String str = " Hello World. This is the first statement that programmers learn to print.";
		
		String upperStr = str.toUpperCase();
		
		String subStr = str.substring(2,5);
		
		String trimmedStr = str.trim();
		
		int strLen = str.length();
		
		
		System.out.println("The str in Upper Case is: \n"+upperStr +"\nThe subString from 2,5 is \n"+subStr+"\nThe trimmed str is: \n"+trimmedStr+"\nThe length of str is: \n"+strLen+"\n");
		
		
		
		String [] strArr = str.split(" ");
		
		for(int i=0; i<strArr.length;i++)
		{
			System.out.println(strArr[i]);
		}
		
		StringBuffer strBuf = new StringBuffer(trimmedStr);
		StringBuffer revStr = strBuf.reverse(); 
		
		String reversedString = revStr.toString();
		
		System.out.println("\nThe reversed String is: \n"+reversedString);
		
		char ch = trimmedStr.charAt(3);
		System.out.println("The char at 3 of trimmedStr is: "+ ch);
		
		
		String a = "100";
		String b = "200";
		
		System.out.println(Integer.parseInt(a)+Integer.parseInt(b));
		
		Integer int1 = new Integer(a);
		Integer int2 = new Integer(b);
		
		System.out.println(int1+int2);
		
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		int[] indexes = { 7, 4, 11, 11, 14, 22, 14, 17, 11, 3};
		
		String result = "";
		
		for(int index : indexes)
		{
			result += alphabets.charAt(index);
		}
		
		System.out.println("Using + : " + result);
		
		StringBuilder sb = new StringBuilder();
		
		for(int index : indexes)
		{
			sb.append(alphabets.charAt(index));
		}
		
		System.out.println("Using StringBuilder: " + sb.toString());
		
		
		

	}

}
