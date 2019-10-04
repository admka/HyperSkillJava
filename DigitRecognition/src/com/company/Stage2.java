/*
package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] inputLayer = new int[15];
        int[][] weights = new int[][]{{-1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1},//1
                {+1, +1, +1, -1, -1, +1, +1, +1, +1, +1, -1, -1, +1, +1, +1},//2
                {+1, +1, +1, -1, -1, +1, +1, +1, +1, -1, -1, +1, +1, +1, +1},//3
                {+1, -1, +1, +1, -1, +1, +1, +1, +1, -1, -1, +1, -1, -1, +1},//4
                {+1, +1, +1, +1, -1, -1, +1, +1, +1, -1, -1, +1, +1, +1, +1},//5
                {+1, +1, +1, +1, -1, -1, +1, +1, +1, +1, -1, +1, +1, +1, +1},//6
                {+1, +1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1},//7
                {+1, +1, +1, +1, -1, +1, +1, +1, +1, +1, -1, +1, +1, +1, +1},//8
                {+1, +1, +1, +1, -1, +1, +1, +1, +1, -1, -1, +1, +1, +1, +1},//9
                {+1, +1, +1, +1, -1, +1, +1, -1, +1, +1, -1, +1, +1, +1, +1}//0
        };
        int[] bias = new int[]{ 6, 1, 0, 2, 0, -1, 3, -2, -1,-1};
        int[] outputLayer = new int[]{0,0,0,0,0,0,0,0,0,0};

        // Read 5*3 input neurons
        String myInput = new String();
        myInput = scanner.nextLine();
        myInput = myInput + scanner.nextLine();
        myInput = myInput + scanner.nextLine();
        myInput = myInput + scanner.nextLine();
        myInput = myInput + scanner.nextLine();

        //Set or reset inputNeuons as integer
        for (int i=0;i<inputLayer.length;i++){
            if (myInput.charAt(i)=='X'){
                inputLayer[i]=1;
            }else {
                inputLayer[i] =0;
            }
        }
        //calculate output neorons
        int max = 0;
        for (int i=0;i<outputLayer.length;i++){
            for (int k = 0; k < inputLayer.length; k++) {
                outputLayer[i] = outputLayer[i] + weights[i][k] * inputLayer[k];
            }
            outputLayer[i] = outputLayer[i] + bias[i];
            if(outputLayer[max] <= outputLayer[i]){
                max = i ;
            }
            System.out.println("output layer " + outputLayer[i]);
            System.out.println(max);
        }

        System.out.println("This number is " + (max+1)%10);
    }
}
*/