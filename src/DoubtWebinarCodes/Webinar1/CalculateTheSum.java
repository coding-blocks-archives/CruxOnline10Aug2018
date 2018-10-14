package DoubtWebinarCodes.Webinar1;

import java.util.Scanner;

public class CalculateTheSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int p = 0; p < arr.length; p++) {
			arr[p] = s.nextInt();
		}

		int query = s.nextInt();
		int divisor = 1000000007;

		for (int i = 1; i <= query; i++) {
			int x = s.nextInt();
			int[] ans = new int[n];
			if (x == 0) {
				for (int j = 0; j < arr.length; j++) {
					ans[j] = (arr[j] * 2) % divisor;
				}
			} else {
				ans[x] = (arr[x] + arr[0]) % divisor;
				int j = x - 1;
				while (j != x) {
					int index = j - x;
					if (index < 0) {
						index = index + arr.length;
					}
					ans[j] = (arr[index] + arr[j]) % divisor;
					j--;
					if (j < 0) {
						j = j + arr.length;
					}
				}
			}
			arr = ans;
		}

		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = (sum + arr[i]) % divisor;
		}

		System.out.println(sum);
	}

}
