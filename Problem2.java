
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
		int curr = 1;
		int next = 2;
		while (curr <= limit) {
			if (curr % 2 == 0) {
				sum += curr;
			}
			int temp = next;
			next += curr;
			curr = temp;
		}
		return sum;
	}



}