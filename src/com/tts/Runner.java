package com.tts;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        AddressBook book = new AddressBook();

        System.out.println("=========== Welcome to Address Book ==========");
        boolean quit = false;
        int choice = 0;

        do {
            ProgramMethods.printInstructions();
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
            }
            scanner.nextLine();
            if (choice <=0 || choice > 7){
                System.out.println("Invalid option, please try again.");
            }



            switch(choice) {
                case 1 -> ProgramMethods.addEntry(scanner, book);
                case 2 -> ProgramMethods.removeEntry(scanner, book);
                case 3 -> book.restore();
                case 4 -> ProgramMethods.searchOptions(scanner, book);
                case 5 -> book.printAddressBook();
                case 6 -> ProgramMethods.clearBook(book);
                case 7 -> quit = true;

            }
        } while(!quit);
    }
}

