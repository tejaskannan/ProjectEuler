import java.lang.Math;

public class Problem12 {




	public static void main(String[] args) {
		System.out.println(findTriangleNumberWithOverDivisors(500));
	}


	// finds the first triangle number with over n divisors
	public static int findTriangleNumberWithOverDivisors(int n) {

		int triangleNum = 1;
		int counter = 2;

		while (true) {

			// find the next triangle number, and update the counter
			triangleNum += counter;
			counter += 1;

			// if the number is less than n, then it is impossible for it to have n divisors
			// if it is over n and the number of factors is at least n, then we found the answer
			if (triangleNum > n && findNumberOfFactors(triangleNum) >= n) {
				return triangleNum;
			}
		}

	}

	// Finds the number of factors of n
	private static int findNumberOfFactors(int n) {

		double sqrt = Math.sqrt(n);
		int factorCount = 0;

		for (int i = 1; i < sqrt; i++) {
			if (n % i == 0) {
				factorCount += 1;
			}
		}

		// multiply by 2 to account for divisors above sqrt
		factorCount *= 2;

		if (Math.floor(sqrt) == sqrt) {
			// if the sqrt is a whole number, then add 1 for this
			factorCount += 1;
		}

		return factorCount;

	}






}


