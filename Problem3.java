import java.lang.Math;
import java.util.ArrayList;

public class Problem3 {

	public static void main(String[] args) {
		long n = 600851475143L;
		System.out.println(largestPrimeFactor(getFactors(n), n));
		// Answer: 6857
	}

	/*
	 * Gets a list of factors for the given number
	 */
	public static ArrayList<Long> getFactors(long n) {
		ArrayList<Long> factors = new ArrayList<Long>();
		long limit = (long) Math.sqrt(n);

		for (long i = 1; i < limit + 1; i++) {
			if (n % i == 0) {
				factors.add(i);
				factors.add(n / i);
			}
		}
		return factors;

	}

	/*
	 * Given the list of factors, the largest prime factor will be returned
	 */
	public static long largestPrimeFactor(ArrayList<Long> factors, long n) {
		long largest = 1;
		for (int i = 0; i < factors.size(); i++) {
			long val = factors.get(i);
			if (val > largest && isPrime(val)) {
				largest = val;
			}
		}
		return largest;
	}

	/*
	 * Computes whether the given number is prime
	 */
	public static boolean isPrime(long n) {
		long limit = (long) Math.sqrt(n);

		for (long i = 2; i <= limit + 1; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}




}