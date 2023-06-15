package org.example.SmallestMultiple;

import java.util.HashMap;

public class SmallestMultiple {

    public static boolean isPrimeNumber(long number) {
        boolean isPrimeNumber = false;

        for (int counter = 2; counter < number && !isPrimeNumber; counter++) {
            // System.out.println(number % counter);
            isPrimeNumber = number % counter == 0;
        }

        return isPrimeNumber;
    }
    public static long theNearestPrimeNumber(long number) {
        long nearestPrimeNumber = number;
        for (int counter = 2; counter < number && (nearestPrimeNumber == number); counter++) {

            nearestPrimeNumber = isPrimeNumber(nearestPrimeNumber) && number % counter == 0  ? counter : number;
        }
        return nearestPrimeNumber;
    }
    public static int potence(int number, int exponent){
        int result = 1;

        for (int counter = 0; counter < exponent; counter++) {
            result *= number;
        }

        return result;
    }
    public static int resultHashMap(HashMap<Integer, Integer> map){
        int result = 1;

        for (Integer key:map.keySet()) {
            int value = map.get(key);
            result *= potence(key, value);
        }

        return result;
    }

    public static HashMap<Integer, Integer> mcm(int...  numbers ){
        HashMap<Integer, Integer> mcm = new HashMap<>();
        HashMap<Integer, Integer> numberMCM = new HashMap<>();

        for (int counter = 0; counter < numbers.length; counter++) {
            numberMCM = primeFactors(numbers[counter]);

            for (Integer key:numberMCM.keySet()) {
                int value = numberMCM.get(key);

                if (mcm.containsKey(key)){
                    if (mcm.get(key) < value){
                        mcm.put(key, numberMCM.get(key));
                    }
                }
                else {
                    mcm.put(key, 1);
                }

            }

        }

        return mcm;
    }

    public static HashMap<Integer, Integer> primeFactors(long number){
        HashMap<Integer, Integer> primeFactors = new HashMap<>();
        long largestPrimeNumber = number;
        // System.out.println(isPrimeNumber(largestPrimeNumber));

        int result = 0;

        while (largestPrimeNumber > 1){
            long divisor = theNearestPrimeNumber(largestPrimeNumber);
            //   System.out.println("divisor " + divisor);

            if (result < divisor){
                result = (int) divisor;
            }

            if (primeFactors.containsKey(result)){
                primeFactors.put(result, primeFactors.get(result) + 1);
            }
            else {
                primeFactors.put(result,1);
            }

            largestPrimeNumber /= divisor;
            // System.out.println("cociente " + cociente);
        }

        return primeFactors;
    }
}
