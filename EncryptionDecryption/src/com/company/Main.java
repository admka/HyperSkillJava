package com.company;
import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileWriter;
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


        public static String readFromFile(String fileLocation) throws IOException{
            File myFile = new File(fileLocation);

            StringBuilder mySb = new StringBuilder();
            Scanner myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()){
                mySb.append(myScanner.nextLine());
            }
            myScanner.close();
            return mySb.toString();

        }

        public  static void writeToFile(String fileLocationn, char[] data) throws IOException{
            FileWriter fw = new FileWriter(fileLocationn);
            fw.write(data);
            fw.close();
        }
    }



    public static void main(String[] args) {

        String fileLocation =
                "C:\\Users\\adem\\IdeaProjects\\EncryptionDecryption\\src\\com\\company\\test.txt";
        String fileLocation2 =
                "C:\\Users\\adem\\IdeaProjects\\EncryptionDecryption\\src\\com\\company\\test2.txt";

        Scanner scanner = new Scanner(System.in);
        //String[] argss = {"-mode", "enc", "-key", "5", "-data", "\"Welcome", "to", "hyperskill!\""};
        String[] argss = {"-mode", "enc", "-key", "5",
                "-in", fileLocation.toString(), "-out", fileLocation2.toString()};

        String mode = "enc";
        int modeIndex = -1;
        int key = 0;
        int keyIndex = -1;
        String data = "";
        int dataIndex = -1;
        String inputFileNameAndLocation = null;
        int inputFileNameAndLocationIndex = -1;
        String outputFileNameAndLocation = null;
        int outputFileNameAndLocationIndex = -1;

        //check error case for each key and value pairs
try {
    for (int i = 0; i < argss.length; i++) {
        if (argss[i].contentEquals("-mode")) {
            mode = argss[i + 1].toString();
            modeIndex = i;
            if (!mode.contentEquals("enc")
                    & !mode.contentEquals("dec")) {
                throw new Exception("Error no enc or dec keyword");
            }
        } else if (argss[i].contentEquals("-key")) {
            key = Integer.parseInt(argss[i + 1]);
            keyIndex = i;
        } else if (argss[i].contentEquals("-data")) {
            dataIndex = i;
        } else if (argss[i].contentEquals("-in")) {
            inputFileNameAndLocationIndex = i;
            inputFileNameAndLocation = argss[i + 1].toString();
        } else if (argss[i].contentEquals("-out")) {
            outputFileNameAndLocationIndex = i;
            outputFileNameAndLocation = argss[i + 1].toString();
        }
    }
}catch (Exception e){
    System.out.println(e.getMessage());
    return;
}

        // if data is provided in input string get data
        try {
            if (dataIndex > -1) {
                for (int i = dataIndex + 1; (i < argss.length)
                        && (i != modeIndex)
                        && (i != keyIndex)
                        && (i != inputFileNameAndLocationIndex)
                        && (i != outputFileNameAndLocationIndex); i++) {
                    data += argss[i].toString();
                    data += " ";
                }
                data = data.trim();
                //if data provided from a file read file name and location
            } else if (inputFileNameAndLocationIndex != -1){
                data = EncryptionDecryption.readFromFile(inputFileNameAndLocation);
            }
        }catch (Exception e){
            System.out.println("Error data" + e.getMessage());
            return;
        }


/*
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
*/


        System.out.println(data);
        System.out.println(data.length());
        String data1 = data.substring(0,data.length()-1);
        System.out.println(data1);
        System.out.println(data1.length());


        System.out.println(mode);
        System.out.println(key);
        System.out.println(data);
        char[] outputArray = new char[data.length()];
        EncryptionDecryption.operationEncOrDenc(mode,data.toCharArray(),outputArray,key);
        try {
            if (outputFileNameAndLocationIndex == -1) {
                System.out.println(outputArray);
            } else {
                EncryptionDecryption.writeToFile(outputFileNameAndLocation, outputArray);


            }
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }

    }
}
