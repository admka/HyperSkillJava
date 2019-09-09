
/*
package com.company;

import java.util.Scanner;

public class Main {

    public static class ChattyBot {

        int birthYear_;
        String botName_;
        int age_;
        String name_;
        int remainder3_;
        int remainder5_;
        int remainder7_;

        public ChattyBot(){
            this.birthYear_ = 2019;
            this.botName_ = new String("Aid");
        }
        public ChattyBot(int birthYear, String botName){
            this.birthYear_ = 2019;
            this.botName_ = new String(botName);
        }

        public  void printSpec()
        {
            System.out.println("Hello! My name is " +
                    this.botName_ + ".");
            System.out.println("I was created in " +
                    this.birthYear_ + ".");
        }
        public void printName()
        {
            System.out.println("Please, remind me your name.");
            System.out.print('>');
        }
        public void readName(Scanner myScanner)
        {
            name_ = myScanner.nextLine();
            System.out.println("What a great name you have, "
                    + name_+ "!");
        }
        public void guessAge(Scanner myScanner)
        {
            System.out.print("Let me guess your age.\n" +
                    "Say me remainders of dividing your age by 3, 5 and 7." +
                    "\n> ");
            remainder3_ = myScanner.nextInt();
            remainder5_ = myScanner.nextInt();
            remainder7_ = myScanner.nextInt();
            age_ = ((remainder3_ % 3) * 70 + (remainder5_ % 5) * 21 + (remainder7_ % 7) * 15) % 105;
            System.out.printf("Your age is %d; that's a good time to start programming!", age_);
        }

    }


    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        ChattyBot myChattyBot = new ChattyBot();
        myChattyBot.printSpec();
        myChattyBot.printName();
        myChattyBot.readName(scanner);
        myChattyBot.guessAge(scanner);

    }
}

*/