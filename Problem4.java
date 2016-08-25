import java.lang.Math;

public class Problem4 {

	public static final int UPPER = 999;
	public static final int LOWER = 100;

	public static void main(String[] args) {
		System.out.println(getLargestPalindrome(LOWER * LOWER, UPPER * UPPER));
		// Answer: 906609
	}

	/*
	 * Returns whether or not the given integer is a palindrome
	 */
	private static boolean isPalindrome(int x) {
		String s = String.valueOf(x);
		int len = s.length();
		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}

	private static int getLargestPalindrome(int lower, int upper) {
		// For each palindrome between the upper and lower limits, we see if it has two three-digit factors
		// if so, then the first one returned will be the largest palindrome with two three-digit factors
		// because we are starting at the upper limit
		for (int i = upper; i >= lower; i--) {
			if (isPalindrome(i) && hasTwoOrThreeDigitFactor(i)) {
				return i;
			}
		}
		return 0;
	}

	private static boolean hasTwoOrThreeDigitFactor(int n) {
		for (int i = LOWER; i < UPPER; i++) {

			// If n is divisible by i and (n / i) is a three digit number, then
			// n is the product of two three digit numbers, as i is a three-digit 
			// number by construction
			if ((n % i == 0) && (isThreeDigits(n / i))) {
				return true;
			}
		}
		return false;
	}

	private static boolean isThreeDigits(int n) {
		return n >= LOWER && n <= UPPER;
	}

}