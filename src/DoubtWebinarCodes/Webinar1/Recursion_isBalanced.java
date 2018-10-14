package DoubtWebinarCodes.Webinar1;

import java.util.Scanner;

public class Recursion_isBalanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		System.out.println(isbalanced(str, ""));
	}

	public static boolean isbalanced(String str, String ob) {
        if(str.length()==0) {
        	if(ob.length()==0) {
        		return true;
        	}else {
        		return false;//if opening brackets are greater than closing
        	}
        }
		char cc = str.charAt(0);
		String ros = str.substring(1);
		if (cc == '(' || cc == '{' || cc == '[') {
           return isbalanced(ros, ob+cc);
		} else if (cc == ')' || cc == ']' || cc == '}') {
             if(ob.length()==0) {
            	 return false;
             }else {
            	 char lc=ob.charAt(ob.length()-1);
            	 if((cc==')'&&lc!='(')||(cc==']'&&lc!='[')||(cc=='}'&&lc!='{')) {
            		 return false;
            	 }else {
            		 return isbalanced(ros, ob.substring(0,ob.length()-1));
            	 }
             }
		} else {
           return isbalanced(ros, ob);
		}
	}

}
