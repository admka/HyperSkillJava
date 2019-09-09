/*
package com.company;

import java.util.Scanner;

public class Main {
    public static class EncryptionDecryption{
        public static char EncryptChar(char input, int key){

            int aux = input;

            if((input!= ' ') & ((aux >=(int) 'a') & (aux <=(int) 'z') )) {
                //aux = 'a' + ('z' - input);  26
                aux = 'a' + (aux - 97 + key)%26;
            }

            return (char)aux ;

        }

        public static char DencryptChar(char input){

            return 'a';
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
                                             char[] output){


        }
    }

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        EncryptionDecryption myEncDec = new EncryptionDecryption();
        //char [] charArray = "welcome to hyperskill".toCharArray();
        //char[] outputArray = new char[charArray.length];
        String input = scanner.nextLine();
        char[] charArray = input.toCharArray();
        char[] outputArray = new char[charArray.length];
        int key = scanner.nextInt();
        //System.out.println(myEncDec.EncryptChar('a'));
        //System.out.println(myEncDec.EncryptChar('z'));
        myEncDec.EncryptCharArray(charArray,outputArray,key);
        //System.out.println(charArray);
        System.out.println(outputArray);


    }
}
*/