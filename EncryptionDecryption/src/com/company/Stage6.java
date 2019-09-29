/*
package encryptdecrypt;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileWriter;
import java.util.ArrayList;

abstract class EncDec{
    public abstract char EncryptChar(char input, int key);

    public abstract char DencryptChar(char input, int key);

    public void EncryptCharArray(char[] input,
                                 char[] output,
                                 int key){
        for (int i = 0; i<input.length;i++){
            output[i] = EncryptChar(input[i],key);
        }
    }
    public void DencryptCharArray(char[] input,
                                  char[] output,
                                  int key){
        for (int i = 0; i<input.length;i++)        {
            output[i] = DencryptChar(input[i],key);
        }
    }
    public void operationEncOrDenc(String operation,
                                   char[] input,
                                   char[] output,
                                   int key) {
        if (operation.equals("enc"))
            EncryptCharArray(input, output, key);
        else if (operation.equals("dec"))
            DencryptCharArray(input, output, key);
    }


    public  String readFromFile(String fileLocation) throws IOException{
        File myFile = new File(fileLocation);

        StringBuilder mySb = new StringBuilder();
        Scanner myScanner = new Scanner(myFile);
        while (myScanner.hasNextLine()){
            mySb.append(myScanner.nextLine());
        }
        myScanner.close();
        return mySb.toString();
    };

    public void writeToFile(String fileLocationn, char[] data) throws IOException{
        FileWriter fw = new FileWriter(fileLocationn);
        fw.write(data);
        fw.close();
    };
}

class EncDecShift extends EncDec{
    public  char EncryptChar(char input, int key){
        int aux = input;
        if(input == ' '){
            return ' ';
        }else if(((aux >=(int) 'a') & (aux <=(int) 'z') )) {
            //aux = 'a' + ('z' - input);
            aux = 'a' + ((input - 'a') + key)%('z' - 'a' + 1);
            return (char)aux;
        }else if(((aux >=(int) 'A') & (aux <=(int) 'Z') )) {
            //aux = 'a' + ('z' - input);
            aux = 'A' + ((input - 'A') + key)%('Z' - 'A' + 1);
            return (char)aux;
        }else{
            return input;
        }
    };

    public char DencryptChar(char input, int key){
        int aux = input;
        if(input == ' '){
            return ' ';
        }else if(((aux >=(int) 'a') & (aux <=(int) 'z') )) {
            //aux = 'a' + ('z' - input);
            if((input - (int)'a') - key<0){
                aux = 'z' + 1 +(input - (int)'a') - key;
                return (char)aux;
            }
            aux = 'a' + ((input - 'a') - key)%('z' - 'a' + 1);
            return (char)aux;
        }else if(((aux >=(int) 'A') & (aux <=(int) 'Z') )) {
            //aux = 'a' + ('z' - input);
            if((input - (int)'A') - key<0){
                aux = 'Z' + 1 +(input - (int)'A') - key;
                return (char)aux;
            }

            aux = 'A' + (((input - (int)'A') - key)%((int)'Z' - (int)'A' + 1));
            return (char)aux;
        }else{
            return input;
        }
    };
};

class EncDecUniCode extends EncDec{
    public  char EncryptChar(char input, int key){
        int aux = input + key;
        return (char)aux ;
    };

    public char DencryptChar(char input, int key){
        int aux = input - key;
        return (char)aux ;
    };
};

abstract class EncDecFactory{
    abstract EncDec createEncDec(String type);

    EncDec getEncDec(String type){
        EncDec encDec = createEncDec(type);
        if(encDec == null){
            System.out.println("Sorry, we are not create specified type of enc or dec algorithm");
            return null;
        }
        //maybe iplement enc or dec operations here
        System.out.println("Enc or Dec ing");
        return encDec;
    }
}

class EncDecOperator extends EncDecFactory{
    @Override
    public EncDec createEncDec(String type){
        switch (type) {
            case "unicode":
                return new EncDecUniCode();
            case "shift":
                return new EncDecShift();
            default:
                return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String alg = "shift";
        int algIndex = -1;
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
            for (int i = 0; i < args.length; i++) {
                if (args[i].contentEquals("-mode")) {
                    mode = args[i + 1].toString();
                    modeIndex = i;
                    if (!mode.contentEquals("enc")
                            & !mode.contentEquals("dec")) {
                        throw new Exception("Error no enc or dec keyword");
                    }
                } else if (args[i].contentEquals("-key")) {
                    key = Integer.parseInt(args[i + 1]);
                    keyIndex = i;
                } else if (args[i].contentEquals("-data")) {
                    dataIndex = i;
                } else if (args[i].contentEquals("-in")) {
                    inputFileNameAndLocationIndex = i;
                    inputFileNameAndLocation = args[i + 1].toString();
                } else if (args[i].contentEquals("-out")) {
                    outputFileNameAndLocationIndex = i;
                    outputFileNameAndLocation = args[i + 1].toString();
                }else if (args[i].contentEquals("-alg")) {
                    algIndex = i;
                    alg = args[i + 1].toString();
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }

        EncDecOperator encDecOp = new EncDecOperator();
        EncDec encoderOrDecoder = encDecOp.getEncDec(alg);


        // if data is provided in input string get data
        try {
            if (dataIndex > -1) {
                for (int i = dataIndex + 1; (i < args.length)
                        && (i != modeIndex)
                        && (i != keyIndex)
                        && (i != inputFileNameAndLocationIndex)
                        && (i != outputFileNameAndLocationIndex)
                        && (i != algIndex); i++) {
                    data += args[i].toString();
                    data += " ";
                }
                data = data.trim();
                //if data provided from a file read file name and location
            } else if (inputFileNameAndLocationIndex != -1){
                data = encoderOrDecoder.readFromFile(inputFileNameAndLocation);
            }
        }catch (Exception e){
            System.out.println("Error data" + e.getMessage());
            return;
        }

        char[] outputArray = new char[data.length()];
        encoderOrDecoder.operationEncOrDenc(mode,data.toCharArray(),outputArray,key);
        try {
            if (outputFileNameAndLocationIndex == -1) {
                System.out.println(outputArray);
            } else {
                encoderOrDecoder.writeToFile(outputFileNameAndLocation, outputArray);
                System.out.println(outputArray);


            }
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }
}
*/