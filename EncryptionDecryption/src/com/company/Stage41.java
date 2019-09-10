/*

package com.company;

import java.util.Scanner;
import java.util.Arrays;
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

        Scanner scanner = new Scanner(System.in);

        String mode = "enc";
        int modeIndex = -1;
        int key = 0;
        int keyIndex = -1;
        String data = "";
        int dataIndex = -1;


        for (int i=0; i<args.length;i++){
            if(args[i].contentEquals("-mode")) {
                mode = args[i + 1].toString();
                modeIndex = i;
            }else if(args[i].contentEquals("-key")) {
                key = Integer.parseInt(args[i + 1]);
                keyIndex = i;
            }else if(args[i].contentEquals("-data")) {
                dataIndex = i;
            }
        }
        if(dataIndex > -1){
            for (int i = dataIndex+1; (i<args.length)
                    &&(i!=modeIndex)
                    &&(i!=keyIndex);i++){
                data += args[i].toString();
                data += " ";
            }
        }

        if (data.isEmpty()) {
            args = scanner.nextLine().split(" ");
            for (int i=0; i<args.length;i++){
                if(args[i].contentEquals("-mode")) {
                    mode = args[i + 1].toString();
                    modeIndex = i;
                }else if(args[i].contentEquals("-key")) {
                    key = Integer.parseInt(args[i + 1]);
                    keyIndex = i;
                }else if(args[i].contentEquals("-data")) {
                    dataIndex = i;
                }
            }
            if(dataIndex > -1){
                for (int i = dataIndex+1; (i<args.length)
                        &&(i!=modeIndex)
                        &&(i!=keyIndex);i++){
                    data += args[i].toString();
                    data += " ";
                }
            }
        }

        System.out.println(data);
        System.out.println(data.length());
        data = data.substring(0,data.length()-1);
        System.out.println(data);
        System.out.println(data.length());


        System.out.println(mode);
        System.out.println(key);
        System.out.println(data);
        char[] outputArray = new char[data.length()];
        EncryptionDecryption.operationEncOrDenc(mode,data.toCharArray(),outputArray,key);
        System.out.println(outputArray);

    }
}


 */