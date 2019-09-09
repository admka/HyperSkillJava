/*
package com.company;

import java.util.Scanner;

public class Main {
    public static class EncryptionDecryption{
        public static char EncryptChar(char input, int key){

            //maybe tyr catch for overflow
            //int aux = input;
            //aux = 'a' + ('z' - input);  26
               //aux = 'a' + (aux - 97 + key)%26;
            int aux = input + key;
            return (char)aux ;

        }

        public static char DencryptChar(char input, int key){

            //int aux = input;
            //aux = 'a' + ('z' - input);  26
            //aux = 'a' + (aux - 97 + key)%26;
            int aux = input - key;
            return (char)aux ;

        }

        public static void EncryptCharArray(char[] input,
                                            char[] output,
                                            int key){

            for (int i = 0; i<input.length;i++)
            {
                    output[i] = EncryptChar(input[i],key);

            }

        }
        public static void DencryptCharArray(char[] input,
                                            char[] output,
                                             int key){
            for (int i = 0; i<input.length;i++)
            {
                output[i] = DencryptChar(input[i],key);

            }

        }
        public static void operationEncOrDenc(String operation,
                                              char[] input,
                                              char[] output,
                                              int key)
        {
            if(operation.equals("enc"))
                EncryptCharArray(input, output, key);
            else if(operation.equals("dec"))
                DencryptCharArray(input, output, key);

        }
    }

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        //EncryptionDecryption myEncDec = new EncryptionDecryption();
        //char [] charArray = "welcome to hyperskill".toCharArray();
        //char[] outputArray = new char[charArray.length];
        String operation = scanner.nextLine();
        String input = scanner.nextLine();
        char[] charArray = input.toCharArray();
        char[] outputArray = new char[charArray.length];
        int key = scanner.nextInt();
        //System.out.println(myEncDec.EncryptChar('a'));
        //System.out.println(myEncDec.EncryptChar('z'));
        EncryptionDecryption.operationEncOrDenc(operation,charArray,outputArray,key);
        //System.out.println(charArray);
        System.out.println(outputArray);


    }
}



 */