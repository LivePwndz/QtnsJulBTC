package org.example;

import java.util.Arrays;

public class JulianQtns {


    public static void main(String[] args){
        System.out.println(Arrays.toString(answerOne(new int[]{5, 7, 8, 10, 12, 4, 1})));

        System.out.println(answerTwo(new int[]{1,2,4,6,7,11}));
        System.out.println(answerTwo(new int[]{1,2,4,6,7,8}));
        System.out.println(answerTwo(new int[]{2,2,4,6,7,8}));
        System.out.println(answerTwo(new int[]{2,3,4,6,7,8}));
    }


    /*
            Question 1. Write a function answerOne(int[] a) that will return an integer array b of equal length
            such that the values in an odd index position in array b is the same as the value in corresponding
            index position in array a and a value in even index position of b is the cumulative sum of values all
            even index positions before that. See the example.
            Let a = {5, 7, 8, 10, 12, 4, 1}. Then b[0] = 5, b[1] = 7, b[2] = 5 + 8 = 13, b[3] = 10, b[4] = 5 + 8 + 12 =
            25, b[5] = 4 and b[6] = 5 + 8 + 12 + 1 = 26.


            Input: arr of ints.
            Output: arr of ints

            Constraints
            b[i] == a[i] if i%2 == 1
            OR
            b[i] == sum of every i from i = 0 to i - 1 where  i%2 == 0
            i.e.
            {5, 7, 8, 10, 12, 4, 1}
             0  1  2   3   4  5  6
            {5, 7, 8, 10, 12, 4, 1}
                *
            i = 0
            sum = 5

            i = 2
            sum = 5+8

            i = 4
            sum = 5+8+12

            i = 6
            sum = 5+8+12+1
 */
    static int[] answerOne(int[] a){
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            if( i%2 == 0){
                sum = sum + a[i];
                a[i] = sum;
            }
        }
        return a;
    }





    /*
        Qtn 2
        Write a function answerTwo(int [ ] a) that will return 1 if an integer array satisfies the
        following conditions and returns 0 otherwise.
        (1) If the first item is odd then the last item is odd and if the first item is even then the last item is
        even.
        (2) Every odd number other than the last item is followed by at least one even number.
        (3) Every odd number other than the first item is preceded by at least one even number.

        Input: arr of ints
        Output: int

        Condition 1: If 1st item is odd and last item is odd. Or If 1st item is even and last item is even.
        Condition 2: for all items for i = 0 to n - 1 - 1
                     if a[i]%2 == 1, then a[n]%2 == 0 at least for a one value of n for n >= i+1
        Condition 3: for all items for i = n-1 to 1, then
                     if a[i]%2 == 1, then a[n]%2 == 0 at least once for n <= i-1


       Rule 1:
       a[0]%2 != a[n-1]%2

       Rule 2:
       Assumption: Definition of followed is, if a[i] is odd, at least i+1 should be even.

       Rule 3:
       Assumption: Definition of preceded is, if a[i] is odd, at least i-1 should be even.

       Examples:
       input: [1,2,4,6,7,11], output: 0
       input: [1,2,4,6,7,8], output: 0
       input: [2,2,4,6,7,8], output: 1
       input: [2,3,4,6,7,8], output: 1
    */

    public static int answerTwo(int[] a){
        if(a[0]%2 != a[a.length - 1]%2) return 0;

        for(int i = 1; i < a.length - 1; i++){
            if(a[i]%2 == 1){
                if(a[i-1]%2 != 0) return 0;
                if(a[i+1]%2 != 0) return 0;
            }
        }

        return 1;
    }


}
