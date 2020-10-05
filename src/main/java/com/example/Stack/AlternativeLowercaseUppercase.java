package com.example.Stack;

public class AlternativeLowercaseUppercase {

    public static void main(String[] args) {

        String input = "java program";
        int kl = input.length();

        for (int i = 0; i < kl; i++) {
            char ch = input.charAt(i);
            if (i % 2 == 0) {
                System.out.print(Character.toLowerCase(ch));
            } else {
                System.out.print(Character.toUpperCase(ch));
            }
        }
    }
}

