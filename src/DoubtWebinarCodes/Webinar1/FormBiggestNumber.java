package DoubtWebinarCodes.Webinar1;

import java.util.Scanner;

public class FormBiggestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		for (int i = 1; i <= tc; i++) {
			int n = s.nextInt();
			int[] arr = new int[n];
			for (int k = 0; k < arr.length; k++) {
				arr[k] = s.nextInt();
			}
			bubblesort(arr);
			for (int val : arr) {
				System.out.print(val);
			}
			System.out.println();
		}
	}

	public static void bubblesort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length-i; j++) {
				if (compareTo(arr[j], arr[j + 1]) > 0) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static int compareTo(int first, int second) {
		String fps = first + "" + second;
		String spf = second + "" + first;

		int fpsval = Integer.valueOf(fps);
		int spfval = Integer.valueOf(spf);

		if (fpsval > spfval) {
			return -1;
		} else {
			return 1;
		}
	}

}
