
public class Problem9 {
	

	public static void main(String[] args) {
		System.out.println(findTriple(1000));
	}


	public static int findTriple(int sum) {
		// if a > midpoint, then a > c, which means that c^2 < a^2 + b^2, so this 'a' cannot be
		// part of a pythagorean triple. We can thus limit our values of a to below the midpoint.
		int midpoint = sum / 2;
		for(int a = 2; a < midpoint; a++) {

			// if b > midpoint, then b > c, which means that c^2 < a^2 + b^2, so this 'a' cannot be
			// part of a pythagorean triple. We can thus limit our values of b to below the midpoint.
 			for (int b = 2; b < midpoint; b++) {
				int c = sum - a - b;

				if (square(c) == (square(a) + square(b))) {
					return a * b * c;
				}
			}

		}

		return 0; // default value
	}

	private static int square(int x) {
		return x * x;
	}

}

