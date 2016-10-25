// Assignment #: 9
//         Name: Bailey Bowman
//    StudentID: 1208740698
//      Lecture: 2:00 MWF
//  Description: TODO


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment9 {
    /*int min = 0;        //array will always have a zero in it
    int sumOdd = 0;
    int countNeg = 0;
    int sumLess = 0;
    */

    public static void main(String[] args) {
        int input = 0; //keeps track of the value to be entered into the array
        int lastNumber = 0; //keeps track of the last number before the end zero

        int[] numbers = new int[100];
        int numberCount = 0; //keeps track of how many values have been entered into the array

        String line;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(isr);

        do {
            try {
                lastNumber = input;                 //update lastNumber before we update input, so that last number is the one before ending zero
                line = stdin.readLine().trim();     //read a line
                input = Integer.parseInt(line);     //update input
                numbers[numberCount] = input;       //update array at numberCount
                numberCount++;

            } catch (IOException e) {
            }
        } while (input != 0);

        //if array successfully filled
        if (numberCount > 0) {

            int min = findMin(numbers, 0, numberCount);
            int sumOdd = computeSumOfOdd(numbers, 0, numberCount-1);
            int countNeg = countNegative(numbers, 0, numberCount-1);
            int sumLess = sumLessThanLast(numbers, 0, numberCount-1, lastNumber); // at this point, input will be the last number.

            System.out.print("The minimum number is " + min + "\n" +
                    "The sum of odd numbers is " + sumOdd + "\n" +
                    "The count of negative numbers is " + countNeg + "\n" +
                    "The sum of numbers that are less than the last is " + sumLess);
        } else {
            System.out.print("bad input");
        }
    }

    public static int findMin(int[] numbers, int startIndex, int endIndex) {
        int min;
        if (startIndex < endIndex) {
            min = numbers[startIndex];
            int newMin = findMin(numbers, startIndex + 1, endIndex);
            if (newMin < min) {
                min = newMin;
            }
        } else {
            min = numbers[endIndex];
        }

        return min;
    }

    public static int computeSumOfOdd(int[] numbers, int startIndex, int endIndex) {
        int sumOdd;

        if (startIndex < endIndex) {
            int current = numbers[startIndex];
            if (current % 2 != 0)
                sumOdd = current + computeSumOfOdd(numbers, startIndex + 1, endIndex);
            else
                sumOdd = computeSumOfOdd(numbers, startIndex + 1, endIndex);
        } else {
            sumOdd = numbers[endIndex];
        }

        return sumOdd;
    }

    public static int countNegative(int[] numbers, int startIndex, int endIndex) {
        int countNeg;

        if (startIndex < endIndex) {
            int current = numbers[startIndex];
            if (current < 0)
                countNeg = 1 + countNegative(numbers, startIndex + 1, endIndex);
            else
                countNeg = countNegative(numbers, startIndex + 1, endIndex);
        } else {
            int current = numbers[endIndex];
            if (current < 0)
                countNeg = 1;
            else
                countNeg = 0;
        }

        return countNeg;
    }

    public static int sumLessThanLast(int[] numbers, int startIndex, int endIndex, int lastNumber) {
        int sumLess;

        if (startIndex < endIndex) {
            int current = numbers[startIndex];
            if (current < lastNumber)
                sumLess = current + sumLessThanLast(numbers, startIndex + 1, endIndex, lastNumber);
            else
                sumLess = sumLessThanLast(numbers, startIndex + 1, endIndex, lastNumber);
        } else {
            int current = numbers[endIndex];
            if (current < lastNumber)
                sumLess = current;
            else
                sumLess = 0;
        }

        return sumLess;
    }
}
