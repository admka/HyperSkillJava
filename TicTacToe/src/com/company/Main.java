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

    public static void printGame(char[][] charArray)
    {
        System.out.println("---------");
        System.out.printf("| %c %c %c |\n",charArray[0][0],charArray[0][1],charArray[0][2]);
        System.out.printf("| %c %c %c |\n",charArray[1][0],charArray[1][1],charArray[1][2]);
        System.out.printf("| %c %c %c |\n",charArray[2][0],charArray[2][1],charArray[2][2]);
        System.out.println("---------");
    }

    public static boolean tryFill(char charArray[][],int coordX, int coordY) {

        boolean temp = true;
        if (coordX == 1 & coordY == 1) {
            if (charArray[2][0] != ' ')
                temp = false;
            else
                charArray[2][0] = 'X';
        } else if (coordX == 2 & coordY == 1){
            if (charArray[2][1] != ' ')
                temp = false;
            else
                charArray[2][1] = 'X';
        }else if (coordX == 3 & coordY==1 ) {
            if (charArray[2][2] != ' ')
                temp = false;
            else
                charArray[2][2] = 'X';
        }else if (coordX == 1 & coordY==2 ) {
            if (charArray[1][0] != ' ')
                temp =  false;
            else
                charArray[1][0] = 'X';
        }else if (coordX == 2 & coordY==2 ) {
            if (charArray[1][1] != ' ')
                temp =  false;
            else
                charArray[1][1] = 'X';
        }else if (coordX == 3 & coordY==2 ){
            if (charArray[1][2] != ' ')
                temp = false;
            else
                charArray[1][2] = 'X';
        }else if (coordX == 1 & coordY==3 ) {
            if (charArray[0][0] != ' ')
                temp = false;
            else
                charArray[0][0] = 'X';
        }else if (coordX == 2 & coordY==2 ) {
            if (charArray[0][1] != ' ')
                temp = false;
            else
                charArray[0][1] = 'X';
        }else if (coordX == 3 & coordY==3 ){
            if (charArray[0][2] != ' ')
                temp = false;
            else
                charArray[0][2] = 'X';
        }
        if(!temp)
            System.out.println("This cell is occupied! Choose another one!");
        return temp;

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

        printGame(charArray);


        System.out.print("Enter the coordinates: ");
        int coordX = 0;
        int coordY = 0;
        boolean valueInLimits = true;
        boolean validNumers = true;

        do {
            do {
                valueInLimits = true;
                validNumers = false;
                int temp = 0;
                System.out.println("step 0");

                 while (!scanner.hasNextInt())
                 {
                     System.out.println("You should enter numbers!");
                     System.out.print("Enter the coordinates: ");
                     System.out.println("step 1");
                     scanner.nextLine();
                     System.out.println("step 2");
                 }
                 System.out.println("step 3");
                 coordX = scanner.nextInt();
                 System.out.println("step 4");
                 System.out.println("step 7");
                 System.out.println("step 8");

                if(scanner.hasNextInt())
                {
                    coordY = scanner.nextInt();
                    validNumers = true;
                }else{
                    scanner.nextLine();
                    System.out.println("You should enter numbers!");
                    System.out.print("Enter the coordinates: ");
                }

            }while (!validNumers);

            if((coordY<1 | coordY > 3) | (coordX < 1 | coordX > 3) )
                valueInLimits = false;

            if (!valueInLimits) {
                System.out.println("Coordinates should be from 1 to 3!");
                System.out.print("Enter the coordinates: ");
            }
        }while((!valueInLimits) | (!tryFill(charArray,coordX,coordY)));

        printGame(charArray);



        if(checkImposibleState(charArray))
        {
            System.out.println("Impossible");
            myState = State.IMPOSSIBLE;
            return;
        }else if(checkWins(charArray,'X'))
        {
            System.out.println("X wins");
            myState = State.XWINS;
            return;
        }else if(checkWins(charArray,'O'))
        {
            System.out.println("O wins");
            myState = State.OWINS;
            return;
        }else if(checkGameNotFinishedState(charArray)) {
            System.out.println("Game not finished");
            myState = State.NOTFINISHED;
            return;
        }else if(checkDrawState(charArray))
        {
            System.out.println("Draw");
            myState = State.DRAW;
            return;
        }



    }
}
