package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        int[] myArray = new int[9];
        int[] weights = new int[]{2,1,2,4,-4,4,2,-1,2};
        int bias =-5;
        int w10 =0;
        String myInput = new String();
        myInput = scanner.nextLine();
        myInput = myInput + scanner.nextLine();
        myInput = myInput + scanner.nextLine();

        for (int i=0;i<9;i++){
            if (myInput.charAt(i)=='X'){
                myArray[i]=1;
            }else {
                myArray[i] =0;
            }
            w10 = w10+weights[i]*myArray[i];
        }
        w10 = w10 + bias;
        int result;
        result  = (w10<0) ? 1 : 0;
        System.out.println("This number is " + result);


    }
}
