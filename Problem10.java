
public class Problem10 {


	public static void main(String[] args) {
		System.out.println(sumPrimesUnder(2000000));
	}



	public static long sumPrimesUnder(int n) {
		long sum = 0;

		ExistingNumber[] numbers = new ExistingNumber[n];

		// Initialize the array that will track which numbers are alive and which have been eliminated.
		// We include all values even though 0 and 1 are not going to be used in order
		// to make the accessing of values simpler and more logical.
		for (int i = 0; i < n; i++) {
			numbers[i] = new ExistingNumber(i);
		}

		// 2 is the first prime number, so start there
		for (int i = 2; i < numbers.length; i++) {
			ExistingNumber num = numbers[i];

			// If this number is still valid, then it is prime. Thus, we will add this to our running sum
			// and the invalidate all multiples of this value that are under the limit of n, as these multiples
			// are by definition not prime
			if (num.isAlive()) {
				sum += num.getValue();
				removeMultiples(numbers, num.getValue(), n);
			}
		}

		return sum;

	}


	private static void removeMultiples(ExistingNumber[] numbers, int val, int limit) {
		// invalidates all of the multiples of this value, as the multiples cannot be primes
		for (int i = val; i < limit; i += val) {
			numbers[i].eliminate();
		}
	}

	public static class ExistingNumber {
		private int value;
		private boolean alive;

		public ExistingNumber(int val) {
			value = val;
			alive = true;
		}

		public int getValue() {
			return value;
		}

		public boolean isAlive() {
			return alive;
		}

		public void eliminate() {
			alive = false;
		}
	}

}
