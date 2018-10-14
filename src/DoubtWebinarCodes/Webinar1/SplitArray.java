package DoubtWebinarCodes.Webinar1;

public class SplitArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		splitarray(arr, 0, 0, "", 0, "");
	}

	public static void splitarray(int[] arr, int i, int sum1, String psf1, int sum2, String psf2) {
		if (i == arr.length) {
			if (sum1 == sum2) {
				System.out.println(psf1 + " and " + psf2);
			}
			return;
		}

		splitarray(arr, i + 1, sum1+ arr[i], psf1 +" "+ arr[i], sum2, psf2);
		splitarray(arr, i + 1, sum1, psf1, sum2 + arr[i], psf2 +" "+ arr[i]);
	}

}
