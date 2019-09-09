package com.company;

public class Main {
    public static class EncryptionDecryption{
        public static char EncryptChar(char input){

            int aux = input;

            if((input!= ' ') & ((aux >=(int) 'a') & (aux <=(int) 'z') )) {
               aux = 'a' + ('z' - input);
            }

            return (char)aux ;

        }

        public static char DencryptChar(char input){

            return 'a';
        }

        public static void EncryptCharArray(char[] input,
                                            char[] output){

            for (int i = 0; i<input.length;i++)
            {
                    output[i] = EncryptChar(input[i]);

            }

        }
        public static void DencryptCharArray(char[] input,
                                            char[] output){


        }
    }

    public static void main(String[] args) {
	// write your code here
        EncryptionDecryption myEncDec = new EncryptionDecryption();
        char [] charArray = "we found a treasure!".toCharArray();
        char[] outputArray = new char[charArray.length];
        //System.out.println(myEncDec.EncryptChar('a'));
        //System.out.println(myEncDec.EncryptChar('z'));
        myEncDec.EncryptCharArray(charArray,outputArray);
        //System.out.println(charArray);
        System.out.println(outputArray);


    }
}
