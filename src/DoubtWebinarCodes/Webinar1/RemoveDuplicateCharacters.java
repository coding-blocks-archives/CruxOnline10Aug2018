package DoubtWebinarCodes.Webinar1;

import java.util.Scanner;

public class RemoveDuplicateCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner s=new Scanner(System.in);
       String str=s.next();
       System.out.println(removeduplicate(str));
	}
	
	public static String removeduplicate(String str) {
		if(str.length()<=1) {
			return str;
		}
		
		char ch1=str.charAt(0);
		char ch2=str.charAt(1);
		String recResult=removeduplicate(str.substring(1));
		String myresult="";
		if(ch1==ch2) {
			myresult=recResult;
		}else {
			myresult=ch1+recResult;
		}
		return myresult;
	}

}
