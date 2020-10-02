package com.example.Stack;


//   Given a positive integer number n, your task is to calculate the difference between the product of its digits and
//   the sum of its digits.
//    Note: The order matters; the answer should be of the form product - sum (and not sum - product).
public class DigitManuplation {

    public static void main(String[] args) {
        System.out.println(digitsManipulations(5046));
    }

    static int digitsManipulations(int n) {
        int digits1 = 0;
        int digits2 = 1;
        for(; n>0; n=n/10) {
            int digit = n%10;
            digits1 += digit;
            digits2 *= digit;
        }
        return digits2 - digits1;
    }


}
