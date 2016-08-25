
public class Problem2 {

	public static void main(String[] args) {
		System.out.println(sumOfEvenFibonacci(4000000));
		// Answer: 4613732
	}

	/**
	 * Returns the sum of the even fibonacci numbers under the given limit
	 */
	public static int sumOfEvenFibonacci(int limit) {
		int sum = 0;

		// start the sequence with 1 and 2
		int curr = 1;
		int next = 2;

		while (curr <= limit) {

			// If the fibonacci number is even, then add it to our sum counter
			if (curr % 2 == 0) {
				sum += curr;
			}

			// Find the next fibonacci number
			int temp = next;
			next += curr;
			curr = temp;
		}
		return sum;
	}



}