

/*

package com.company;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean checkWinsStateHorizontal(char[][] charArray, char ControlCharacter)
    {
        for (int i= 0; i<3; i++)
        {
            if((charArray[i][0]== ControlCharacter) &
                    (charArray[i][0]==charArray[i][1]) &
                    (charArray[i][1]==charArray[i][2]))
            { return true; }
        }
        return false;
    }

    public static boolean checkWinsStateVertical(char[][] charArray, char ControlCharacter)
    {
        for (int i= 0; i<3; i++)
        {
            if((charArray[0][i]== ControlCharacter) &
                    (charArray[0][i]==charArray[1][i]) &
                    (charArray[1][i]==charArray[2][i]))
            { return true; }
        }
        return false;
    }

    public static boolean checkWinsStateDiagonal(char[][] charArray, char ControlCharacter)
    {
        if((charArray[0][0] == ControlCharacter) &
                (charArray[0][0]==charArray[1][1]) &
                (charArray[1][1]==charArray[2][2]))
        { return true; }

        if((charArray[0][2] == ControlCharacter) &
                (charArray[0][2]==charArray[1][1]) &
                (charArray[1][1]==charArray[2][0]))
        { return true; }

        return false;
    }

    public static boolean checkEmptySpot(char[][] charArray)
    {
        for (int i= 0; i<3; i++)
        {
            for (int k= 0; k<3; k++)
            {
                if(charArray[i][k] == ' ')
                { return true; }
            }
        }
        return false;
    }
    public static int countOccurrence(char[][] charArray, char ControlCharacter)
    {
        int counter = 0;
        for (int i= 0; i<3; i++)
        {
            for (int k= 0; k<3; k++)
            {
                if(charArray[i][k] == ControlCharacter)
                { counter++; }
            }
        }
        return counter;
    }

    public static boolean checkWins(char[][] charArray, char ControlCharacter)
    {
        return checkWinsStateHorizontal(charArray,ControlCharacter) |
                checkWinsStateVertical(charArray,ControlCharacter) |
                checkWinsStateDiagonal(charArray,ControlCharacter);
    }
    public static boolean checkImposibleState(char[][] charArray)
    {
        int i = countOccurrence(charArray,'X') - countOccurrence(charArray,'O');
        if(Math.abs(i)>1)
        {return true;}

        if((checkWins(charArray,'X') == true) &
                (checkWins(charArray,'O') == true))
        { return true; }

        return false;
    }

    public static boolean checkGameNotFinishedState(char[][] charArray)
    {
        if((checkWins(charArray,'X') == false) &
                (checkWins(charArray,'O') == false) &
                (checkEmptySpot(charArray) == true)  )
        { return true; }

        return false;
    }

    public static boolean checkDrawState(char[][] charArray)
    {
        if((checkWins(charArray,'X') == false) &
                (checkWins(charArray,'O') == false))
        { return true; }

        if(checkEmptySpot(charArray))
        { return false;}

        return false;
    }

    //Enum is not implemented completely but might be beneficial for next steps
    public enum State
    {
        NOTFINISHED,
        DRAW,
        XWINS,
        OWINS,
        IMPOSSIBLE
    }

    public static void main(String[] args) {
        // write your code here
        State myState = State.NOTFINISHED;

        Scanner scanner = new Scanner(System.in);
        //char[] inputChar = new char[11];
        //Arrays.fill(inputChar, ' ');
        String inputString = scanner.nextLine();
        char[][] charArray = new char[3][3];
        charArray[0] = Arrays.copyOfRange(inputString.toCharArray(),1,4);
        charArray[1] = Arrays.copyOfRange(inputString.toCharArray(),4,7);
        charArray[2] = Arrays.copyOfRange(inputString.toCharArray(),7,10);

        System.out.println("---------");
        System.out.printf("| %c %c %c |\n",charArray[0][0],charArray[0][1],charArray[0][2]);
        System.out.printf("| %c %c %c |\n",charArray[1][0],charArray[1][1],charArray[1][2]);
        System.out.printf("| %c %c %c |\n",charArray[2][0],charArray[2][1],charArray[2][2]);
        System.out.println("---------");

        System.out.println("Enter the coordinates");
        int coordX = scanner.nextInt();
        int coordY = scanner.nextInt();
        if (coordX == 1 & coordY==1 )
            charArray[2][0] = 'X';
        else if (coordX == 2 & coordY==1 )
            charArray[2][1] = 'X';
        else if (coordX == 3 & coordY==1 )
            charArray[2][2] = 'X';
        else if (coordX == 1 & coordY==2 )
            charArray[1][0] = 'X';
        else if (coordX == 2 & coordY==2 )
            charArray[1][1] = 'X';
        else if (coordX == 3 & coordY==2 )
            charArray[1][2] = 'X';
        else if (coordX == 1 & coordY==3 )
            charArray[0][0] = 'X';
        else if (coordX == 2 & coordY==2 )
            charArray[0][1] = 'X';
        else if (coordX == 3 & coordY==3 )
            charArray[0][2] = 'X';

        System.out.println("---------");
        System.out.printf("| %c %c %c |\n",charArray[0][0],charArray[0][1],charArray[0][2]);
        System.out.printf("| %c %c %c |\n",charArray[1][0],charArray[1][1],charArray[1][2]);
        System.out.printf("| %c %c %c |\n",charArray[2][0],charArray[2][1],charArray[2][2]);
        System.out.println("---------");




    }
}

*/