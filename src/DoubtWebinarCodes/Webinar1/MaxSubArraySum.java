package DoubtWebinarCodes.Webinar1;

public class MaxSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4 };
		System.out.println(maxcontigsum(arr));
	}

	public static int maxcontigsum(int[] arr) {
		int max_endinghere = 0;
		int max_so_far = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			max_endinghere = max_endinghere + arr[i];
			if (max_endinghere > max_so_far) {
				max_so_far = max_endinghere;
			}
			if (max_endinghere < 0) {
				max_endinghere = 0;
			}
		}

		return max_so_far;
	}

}
