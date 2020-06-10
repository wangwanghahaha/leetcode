package com.company;

import java.util.Scanner;

public class Utils {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String s=leetcodeToJaveArrays(sc.next());
        System.out.println(s);
    }

    private static String leetcodeToJaveArrays(String s) {
        return s.replace("[","{").replace("]","}");

    }
}
