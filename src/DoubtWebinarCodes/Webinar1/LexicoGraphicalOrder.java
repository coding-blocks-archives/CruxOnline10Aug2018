package DoubtWebinarCodes.Webinar1;

import java.util.Scanner;

public class LexicoGraphicalOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		printlexico(n, 0);
	}

	public static void printlexico(int end, int curr) {
		if (curr > end) {
			return;
		}
		System.out.print(curr + " ");
		if (curr == 0) {
			for (int i = 1; i <= 9; i++) {
				printlexico(end, curr * 10 + i);
			}
		} else {
			for (int i = 0; i <= 9; i++) {
				printlexico(end, curr * 10 + i);
			}
		}
	}

}
