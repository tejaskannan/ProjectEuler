
public class Problem1 {

	public static void main(String[] args) {
		System.out.println(sumMultiples(3, 5, 1000));
		//Answer: 233168
	}


	/**
	 * Finds the sum of all multiple of x and y under the given limit
	 */
	public static int sumMultiples(int x, int y, int limit) {
		int sum = 0;
		for (int i = 1; i < limit; i++) {
			int xMod = i % x;
			int yMod = i % y;
			if ((xMod == 0 && yMod == 0) || (xMod == 0 && yMod != 0) || (xMod != 0 && yMod == 0)) {
				sum += i;
			}
		}
		return sum;
	}

}
