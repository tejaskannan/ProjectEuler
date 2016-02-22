
public class Problem6 {

	public static void main(String[] args) {
		System.out.println(differenceOfSums(100));
		// Answer: 25164150
	}

	public static int differenceOfSums(int n) {
		int sumOfSquares = 0;

		for (int i = 1; i <= n; i++) {
			sumOfSquares += i * i;
		}

		int sum = (n * (n + 1)) / 2;
		int squareOfSums = sum * sum;

		return squareOfSums - sumOfSquares;

	}



}