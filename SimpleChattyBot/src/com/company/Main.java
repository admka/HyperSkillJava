package com.company;


public class Main {

    public static class ChattyBot {

        int birthYear_;
        String botName_;

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

    }


    public static void main(String[] args) {
	// write your code here

        ChattyBot myChattyBot = new ChattyBot();
        myChattyBot.printSpec();

    }
}
