package com.company;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        //char[] inputChar = new char[11];
        //Arrays.fill(inputChar, ' ');
        String inputString = scanner.nextLine();
        char inputChar[] = inputString.toCharArray();



        System.out.println(new String(inputChar));
        System.out.println("---------");
        System.out.printf("| %c %c %c |\n",inputChar[1],inputChar[2],inputChar[3]);
        System.out.printf("| %c %c %c |\n",inputChar[4],inputChar[5],inputChar[6]);
        System.out.printf("| %c %c %c |\n",inputChar[7],inputChar[8],inputChar[9]);
        System.out.println("---------");


    }
}
