
public class Problem8 {

	private static String num = "73167176531330624919225119674426574742355349194934" + 
								"96983520312774506326239578318016984801869478851843" +
								"85861560789112949495459501737958331952853208805511" +
								"12540698747158523863050715693290963295227443043557" +
								"66896648950445244523161731856403098711121722383113" +
								"62229893423380308135336276614282806444486645238749" +
								"30358907296290491560440772390713810515859307960866" +
								"70172427121883998797908792274921901699720888093776" +
								"65727333001053367881220235421809751254540594752243" +
								"52584907711670556013604839586446706324415722155397" +
								"53697817977846174064955149290862569321978468622482" +
								"83972241375657056057490261407972968652414535100474" +
								"82166370484403199890008895243450658541227588666881" +
								"16427171479924442928230863465674813919123162824586" +
								"17866458359124566529476545682848912883142607690042" +
								"24219022671055626321111109370544217506941658960408" +
								"07198403850962455444362981230987879927244284909188" +
								"84580156166097919133875499200524063689912560717606" +
								"05886116467109405077541002256983155200055935729725" +
								"71636269561882670428252483600823257530420752963450";

	//private static String num = "123456789001236";

		public static void main(String[] args) {
			System.out.println(findLargestProductOptimized(13));
		}

		// Finds the largest product using a sliding window. n is number of adjacent values to consider
		public static long findLargestProductOptimized(int n) {
			int length = num.length();
			int i = 0;
			long maxProduct = 0;

			// Finds the first product. Goes until the product is not zero
			while (maxProduct == 0) {
				maxProduct = 1;
				for (int j = 0; j < n; j++) {

					int index = i + j;
					maxProduct *= getNumFromString(index); // Gets the int value for the character

					// If we have a 0, then we know this is defintely not the max, so just end here
					if (maxProduct == 0) {
						i += j + 1; // advance the counter beyond the zero
						break;
					}
				}
			}

			// Advances the counter to beyond the section that was just computed
			i += n;
			long prod = maxProduct;

			while (i < length) {

				int currentNum = getNumFromString(i);

				// If the current number is 0, then the product will become 0. We can simply
				// ignore all products taht will involve this value, so we move the counter
				// beyond this index and recompute the product.
				if (currentNum == 0) {
					i += 1; // move the counter beyond the zero
					prod = 0; // the product will become zero

					// find the next product that is not zero and move the counter accordingly
					while (prod == 0) {
						prod = 1;
						for (int j = 0; j < n; j++) {

							int index = i + j;

							// If the index is beyond the length, then return the max product
							if (index >= length) {
								return maxProduct;
							}

							prod *= getNumFromString(index); // Gets the int value for the character

							// If we have a 0, then we know this is defintely not the max, so just end here
							if (prod == 0) {
								i += j + 1; // advance the counter beyond the zero
								break;
							}
						}
					}
					i += n; // Move the counter to the end of the window
				} else {
					// if new value is not zero, then we will divide by the value that has expired and 
					// multiply by the new value that has been added to the window
					int numToRemove = getNumFromString(i - n);
					prod = (prod / numToRemove) * currentNum;
					i++;
				}

				// if the product is greater than the current max, we have found a new max
				if (prod > maxProduct) {
					maxProduct = prod;
				}
			}
	
			return maxProduct;
		}

		private static int getNumFromString(int index) {
			return (int) (num.charAt(index) - '0');
		}

}
