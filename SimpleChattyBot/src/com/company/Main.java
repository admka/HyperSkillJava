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
        int countValue_;

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
            System.out.printf("Your age is %d; that's a good time to start programming\n", age_);
        }

        public void count(Scanner myScanner)
        {
            System.out.println("Now I will prove to you that I can count to any number you want.");
            //System.out.print("> ");
            countValue_ = myScanner.nextInt();
            for (int i = 0; i<=countValue_;i++)
            {
                System.out.printf("%d!\n",i);
            }

            //System.out.println("Completed, have a nice day!");
        }
        public void test(Scanner myScanner)
        {
            System.out.println("Let's test your programming knowledge.");
            System.out.println("Why do we use methods?\n" +
                    "1. To repeat a statement multiple times.\n" +
                    "2. To decompose a program into several small subroutines.\n" +
                    "3. To determine the execution time of a program.\n" +
                    "4. To interrupt the execution of a program.");
            System.out.print("> ");
            int temp = 0;
            do {
                //System.out.print("> ");
                temp = myScanner.nextInt();
                if (temp != 2)
                    System.out.println("Please, try again.");

            }while (!(temp == 2));

        }

        public void end()
        {
            System.out.println("Congratulations, have a nice day!");
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
        myChattyBot.count(scanner);
        myChattyBot.test(scanner);
        myChattyBot.end();

    }
}
