package com.example.Stack;

// You are given two strings pattern and s. The first string pattern contains only the symbols 0 and 1,
// and the second string s contains only lowercase English letters.
//Let's say that pattern matches a substring s[l..r] of s if the following 3 conditions are met:
//
//they have equal length;
//for each 0 in pattern the corresponding letter in the substring is a vowel;
//for each 1 in pattern the corresponding letter is a consonant.
//Your task is to calculate the number of substrings of s that match pattern.
//
//Note: In this task we define the vowels as 'a', 'e', 'i', 'o', 'u', and 'y'. All other letters are consonants.

import java.util.ArrayList;
import java.util.List;

public class binaryPatternMatching {

    int binaryPatternMatching(String pattern, String s) {
        List<Character> binaryPattern = getPatternInBinary(s);
        int match = 0;
        int size = s.length()-pattern.length();
        for(int i=0; i<=size; i++) {
            boolean exists = true;

            for(int j=0; j<pattern.length(); j++) {
                char a = binaryPattern.get(i+j);
                char b = pattern.charAt(j);
                if(a != b) {
                    exists = false;
                }
            }
            if(exists) {
                match+=1;
            }
        }
        return match;
    }

    List<Character> getPatternInBinary(String s) {
        List<Character> binary = new ArrayList<>();
        int size = s.length();
        for(int i=0; i<size; i++) {
            char c = s.charAt(i);
            int idx = "yaeiou".indexOf(c);
            if(idx != -1) binary.add('0');
            else binary.add('1');
        }

        return binary;
    }
}
