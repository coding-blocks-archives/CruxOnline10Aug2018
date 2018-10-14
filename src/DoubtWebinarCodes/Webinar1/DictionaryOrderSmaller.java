package DoubtWebinarCodes.Webinar1;

import java.util.Scanner;

public class DictionaryOrderSmaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		printsmaller(str, str, "", false);
	}

	public static void printsmaller(String str, String tocheck, String res, boolean isSmaller) {
         if(str.length()==0) {
        	 if(!res.equals(tocheck)) {
        		 System.out.println(res);
        	 }
        	 return;
         }
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(isSmaller) {
				String ros=str.substring(0,i)+str.substring(i+1);
				printsmaller(ros, tocheck, res+ch,isSmaller);
			}else {
				if(ch<=str.charAt(0)) {
					String ros=str.substring(0,i)+str.substring(i+1);
					printsmaller(ros, tocheck, res+ch, ch<str.charAt(0));
				}else {
					//dont include
				}
			}
		}
	}

}
