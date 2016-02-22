
public class Problem7 {

	public static void main(String[] args) {
		System.out.println(nthLargestPrime(10001));
		// Answer: 104743
	}


	public static int nthLargestPrime(int n) {
		int count = 2; // 2 and 3 are prime
		int i = 5; // start off with 5
		while (count < n) {
			if (isPrime(i)) {
				count += 1;
			}
			i += 2;
		}
		return i - 2;
	}

	// All numbers can be described as (6k + i) for i = -1, 0, 1, 2, 3, 4. If i is 0, 2, or 4, it is divisible by 2 
	// and if i is 3, it is divisible by three. So we only need to check numbers of the form (6k - 1) and (6k + 1) that 
	// are less than sqrt(n) if we make sure that n isn't divisible by 2 or 3.
	private static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		} else if (n <= 3) {
			return true;
		} else if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}

		// Continue until 6i - 1 is sqrt(n). This is the same as (6i - 1)^2 = n
		for (int i = 6; (i - 1)*(i - 1) <= n; i += 6) {
			if ((n % (i - 1) == 0) || (n % (i + 1) == 0)) {
				return false;
			}
		}
		return true;
	}





}



