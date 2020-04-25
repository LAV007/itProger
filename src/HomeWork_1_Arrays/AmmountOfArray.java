package HomeWork_1_Arrays;

import java.util.Arrays;

public class AmmountOfArray {

	public static void main(String[] args) {
		int[] arr = new int[1000];
		init(arr);
		int am = ammount(arr);
		System.out.println(
				Arrays.toString(arr) + "\n" +
				am
		);

	}

	static int[] init(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		return arr;
	}


		static int ammount ( int[] ar){
			int res = 0;
			for (int i = 0; i < ar.length; i++) {
				if (ar[i] % 3 != 0 && ar[i] % 5 != 0) continue;
				res += ar[i];
			}
			return res;
		}
}
