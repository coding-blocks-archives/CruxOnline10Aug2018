package DoubtWebinarCodes.Webinar1;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aaabbccds";

		String ans = "";
		int i = 0;
		while (i < str.length()) {
			int count = 1;
			int j = i + 1;
			char ch = str.charAt(i);
			while (j < str.length() && ch == str.charAt(j)) {
				j++;
				count++;
			}
			if (count == 1) {
				ans = ans + ch;
			} else {
				ans = ans + ch + count;
			}
			i = i + count;
		}
		System.out.println(ans);

	}

}
