package DoubtWebinarCodes.Webinar1;

import java.util.Scanner;

public class TOH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(TOH(n, "src", "dest", "helper"));
	}

	public static int TOH(int n, String src, String dest, String helper) {
		if (n == 0) {
			return 0;
		}
		int count = 0;
		count = count + TOH(n - 1, src, helper, dest);
		System.out.println("move " + n + " th disc from " + src + " to " + dest);
		count++;
		count = count + TOH(n - 1, helper, dest, src);
		return count;
	}

}
