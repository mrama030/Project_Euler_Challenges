// Mohamed Ali Ramadan

// Description:
// My solutions to the Project Euler problems.

package EulerSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Solutions
{
    // If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
    // The sum of these multiples is 23.
    // Find the sum of all the multiples of 3 or 5 below 1000.
    public static int Problem_1() // CORRECT
    {
        int sum = 0;
        for (int i = 0; i < 1000; i++)
        {
            if (i % 3 == 0 || i % 5 == 0)
            {
                sum += i;
            }
        }
        return sum;
    }

    // Each new term in the Fibonacci sequence is generated by adding the previous two terms.
    // By starting with 1 and 2, the first 10 terms will be:
    // 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
    // By considering the terms in the Fibonacci sequence whose values do not exceed four million,
    // find the sum of the even-valued terms.
    public static int Problem_2() // CORRECT
    {
        int sum = 2; // Since first two fibonacci numbers, 1 and 2 are not verified. 2 is even, so must be included.
        final int FIB_LIMIT = 4 * (int)Math.pow(10, 6); // 4 million

        int first = 1;
        int second = 2;

        while (true)
        {
            int nextFibNum = first + second;

            if (nextFibNum > FIB_LIMIT)
            {
                break;
            }

            if (nextFibNum % 2 == 0) // If fibonacci number is even, add it to sum.
            {
                sum += nextFibNum;
            }

            first = second;
            second = nextFibNum;
        }

        return sum;
    }

    // The prime factors of 13195 are 5, 7, 13 and 29.
    // What is the largest prime factor of the number 600851475143 ?
    public static long Problem_3()
    {
        /*
        final long input = 600851475143L;

        long currentLargestPrimeFactor = 1;

        // Hypothesis: It is pointless to test a value that is over 50% of the input,
        long testUntilValue = (long)Math.ceil(input / 2);

        for(long i = 1; i < testUntilValue; i++)
        {
            if (input % i == 0)
            {

            }
        }


        */

        return -1;
    }

    // A palindromic number reads the same both ways. The largest palindrome made
    // from the product of two 2-digit numbers is 9009 = 91 × 99.
    // Find the largest palindrome made from the product of two 3-digit numbers.
    public static int Problem_4() // CORRECT
    {
        int currentMax = -1;

        for (int leftFactor = 999; leftFactor > 100; leftFactor--)
        {
            for (int rightFactor = leftFactor; rightFactor > 100; rightFactor--)
            {
                // Create array of characters.
                int product = leftFactor * rightFactor;
                String productAsString =  String.format("%d", product);
                char[] productAsCharacters = productAsString.toCharArray();

                // Counters and flags for verifying if the number is palindrome.
                int length = productAsCharacters.length;
                int leftIndex = 0;
                int rightIndex = length - 1;
                boolean isPalindrome = true;
                int numberOfChecks = length / 2;


                for (int i = 0; i < numberOfChecks; i++)
                {
                    if (productAsCharacters[leftIndex] != productAsCharacters[rightIndex])
                    {
                        // Not a palindrome number.
                        isPalindrome = false;
                        break;
                    }
                    else
                    {
                        leftIndex++;
                        rightIndex--;
                    }
                }

                if (isPalindrome && product > currentMax)
                {
                    currentMax = product;
                }
            }
        }

        return currentMax;
    }

    // 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
    // What is the smallest positive number that is evenly divisible (divisible with no remainder) by all of the numbers from 1 to 20?
    public static int Problem_5() // CORRECT
    {
        for (int i = 1; true; i++)
        {
            int numberOfEvenDividers = 0;
            for (int divider = 1; divider <= 20; divider++)
            {
                if (i % divider == 0)
                {
                    numberOfEvenDividers++;
                }
                else
                {
                    break;
                }
            }

            if (numberOfEvenDividers == 20)
            {
                return i;
            }
        }
    }

    // The sum of the squares of the first ten natural numbers is,
    // 1^2 + 2^2 + ... + 10^2 = 385
    // The square of the sum of the first ten natural numbers is,
    // (1 + 2 + ... + 10)^2 = 55^2 = 3025
    // Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
    // Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
    public static int Problem_6()
    {
        int sumOfSquares = 0;
        int sum = 0;

        for (int i = 1; i <= 100; i++)
        {
            sumOfSquares += (int) Math.pow(i, 2);
            sum += i;
        }

        return (int) Math.pow(sum, 2) - sumOfSquares;
    }

    // By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
    // What is the 10 001st prime number?
    public static int Problem_7() // CORRECT
    {
        int count = 0;

        for (int i = 1; true; i++)
        {
            if (isPrimeNumber(i))
            {
                count++;

                if (count == 10001)
                {
                    return i;
                }
            }
        }
    }

    // AKS algorithm implementation:
    // https://stackoverflow.com/questions/2385909/what-would-be-the-fastest-method-to-test-for-primality-in-java
    public static boolean isPrimeNumber(int n)
    {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }

    // The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
    // Find the thirteen adjacent digits in the 1000-digit number that have the greatest product.
    // What is the value of this product?
    public static long Problem_8() // CORRECT
    {
        final String thousandDigitNumber = "73167176531330624919225119674426574742355349194934" +
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

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i = 1; i < thousandDigitNumber.length(); i++)
        {
            int value = Character.getNumericValue(thousandDigitNumber.charAt(i));
            numbers.add(value);
        }

        int startIndex = 0;
        int endIndex = 12;

        // Calculate initial product of first 13 digits.
        long maxProduct = numbers.get(0);

        for (int i = 1; i <= endIndex; i++) // second to 13th digit
        {
            maxProduct *= numbers.get(i);
        }

        long currentProduct = maxProduct;

        int FINAL_LOOP_INDEX = thousandDigitNumber.length() - 2; // end one before last index

        while (endIndex < FINAL_LOOP_INDEX) // loop until endIndex hits 998 (second last digit) inclusive
        {
            startIndex++;
            endIndex++;

            int toRemove = numbers.get(startIndex - 1);
            int toAdd = numbers.get(endIndex);

            if (toAdd == 0)
            {
                currentProduct = 0;

            }
            else
            {
                if (toRemove == 0) // If there was a zero, the whole product of the new 13 digits must be recalculated.
                {
                    currentProduct = numbers.get(startIndex); // first digit

                    for (int i = startIndex + 1; i <= endIndex; i++) // next 12 digits
                    {
                        currentProduct *= numbers.get(i);
                    }
                }
                else
                {
                    // divide by the number to remove to remove its effect from the product, then multiply by the new number.
                    currentProduct = (currentProduct / toRemove) * toAdd;
                }

                if (currentProduct > maxProduct)
                {
                    maxProduct = currentProduct;
                }
            }
        }

        return maxProduct;
    }
}
