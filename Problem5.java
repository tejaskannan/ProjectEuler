
public class Problem5 {

	public static void main(String[] args) {
		System.out.println(evenlyDivisibleUpTo(20));
		// Answer: 232792560
	}

	public static int evenlyDivisibleUpTo(int n) {
		int x = n;
		while(!isDivisible(x, n)) {
			x += n;
		}
		return x;
	}

	private static boolean isDivisible(int x, int n) {
		for (int i = 2; i < n; i++) {
			if (x % i != 0) {
				return false;
			}
		}
		return true;
	}

}

