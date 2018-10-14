package DoubtWebinarCodes.Webinar1;

public class CountSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(countSS("abc",""));
	}
	
	public static int countSS(String str,String res) {
		if(str.length()==0) {
			return 1;
		}
		
		int count=0;
		char ch=str.charAt(0);
		String ros=str.substring(1);
		count=count+countSS(ros,res);
		count=count+countSS(ros, res+ch);
		return count;
	}

}
