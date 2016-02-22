import java.lang.Math;

public class Problem4 {


	public static void main(String[] args) {
		System.out.println(getLargestPalindrome(100 * 100, 999 * 999));
		// Answer: 906609
	}

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
		for (int i = upper; i >= lower; i--) {
			if (isPalindrome(i) && hasTwoThreeDigitFactors(i)) {
				return i;
			}
		}
		return 0;
	}

	private static boolean hasTwoThreeDigitFactors(int n) {
		for (int i = 100; i < 999; i++) {
			if ((n % i == 0) && (isThreeDigits(n / i))) {
				return true;
			}
		}
		return false;
	}

	private static boolean isThreeDigits(int n) {
		return n >= 100 && n < 1000;
	}

}