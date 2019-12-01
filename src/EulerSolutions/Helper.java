package EulerSolutions;

public class Helper
{
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

    public static boolean isPrimeNumber(long n)
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

    public static boolean isLeapYear(int year)
    {
        if (year % 100 == 0) // year is a century
        {
            if (year % 400 == 0) // is leap if divisible by 400
            {
                return true;
            }

            return false;
        }
        else if (year % 4 == 0)
        {
            return true;
        }

        return false;
    }
}
