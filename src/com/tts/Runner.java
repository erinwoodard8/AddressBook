package com.tts;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    public static void start() {

    //Creates the instances for the Scanner and AddressBook for the program.
        Scanner scanner = new Scanner(System.in);
        AddressBook book = new AddressBook();

        System.out.println("=========== Welcome to Address Book ==========");
        boolean quit = false;
        String choice = null;
//While loop that keeps running as long as quit == false.
        while(!quit) {
            ProgramMethods.printInstructions();

            try {
                choice = scanner.next();
            } catch (InputMismatchException a) {
                System.out.println("Something went wrong.");
            }

//Switch that takes in user input and invokes the corresponding ProgramMethod.
            switch (choice) {
                case "1" -> ProgramMethods.addEntry(scanner, book);
                case "2" -> ProgramMethods.removeEntry(scanner, book);
                case "3" -> book.restore();
                case "4" -> ProgramMethods.searchOptions(scanner, book);
                case "5" -> book.printAddressBook();
                case "6" -> ProgramMethods.clearBook(book);
                case "7" -> quit = true;
                default -> System.out.println("Please try again.");

            }
        }
    }
}

