package DoubtWebinarCodes.Webinar1;

import java.util.Scanner;

public class AlexGoesShopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}

		int queries = s.nextInt();
		int query = 1;
		while (query <= queries) {
			int money = s.nextInt();
			int min_items = s.nextInt();
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (money % arr[i] == 0) {
					count++;
				}
			}
			if (count >= min_items) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			query++;
		}
	}

}
