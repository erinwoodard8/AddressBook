package com.tts;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    private static Scanner scanner = new Scanner(System.in);

    private static AddressBook book = new AddressBook();

    public static void printInstructions() {
        System.out.println("\n Press To:");
        System.out.println("\t 1 - Add an Entry");
        System.out.println("\t 2 - Remove an Entry");
        System.out.println("\t 3 - Search for a specific Entry");
        System.out.println("\t 4 - Print Address Book");
        System.out.println("\t 5 - Delete entire Address Book");
        System.out.println("\t 6 - Quit");
        System.out.println("Choose an option: ");
    }
    public static void addEntry() {

        System.out.println("First Name: ");
        String first = scanner.next();
        System.out.println("Last Name: ");
        String last = scanner.next();
        System.out.println("Phone Number: ");
        String phone = scanner.next();
        System.out.println("Email Address: ");
        String email = scanner.next();

//checks to make sure the email doesn't already exist by comparing the return of .addAddressBook()
        if (book.addAddressBook(first, last, phone, email) == true) {
            System.out.println("Entry added!!   :)");
        } else{
            System.out.println("Email already exists within Address Book.");
        }

    }

    //searches for email in book and removes that entry if entry exists
    public static void removeEntry() {
        System.out.println("Please enter email of entry you wish to delete");
        String email = scanner.nextLine();

        if(book.removeAddressBook(email) == true) {
            book.removeAddressBook(email);
            System.out.println("Entry has been removed from Address Book");
        } else {
            System.out.println(email + " does not exist within Address Book");
        }
    }

    //deletes the entire AddressBook.
    public static void clearBook() {
        book.deleteAddressBook();
        System.out.println("All entries have been deleted.");
    }

    public static void searchOptions() {
            System.out.println("\t 1 - First Name");
            System.out.println("\t 2 - Last Name");
            System.out.println("\t 3 - Phone Number");
            System.out.println("\t 4 - Email Address");
            System.out.println("Choose a search option: ");
            int searchOption = scanner.nextInt();
            scanner.nextLine();

            switch(searchOption) {
                case 1 -> searchFirstName();
                case 2 -> searchLastName();
                case 3 -> searchPhoneNumber();
                case 4 -> searchEmailAddy();
            }
    }

    public static void searchFirstName() {
        System.out.println("Enter your search: ");
        scanner.nextLine();
        String search = scanner.nextLine();
        ArrayList results = book.searchFirst(search);
        System.out.println("YOUR SEARCH RESULTS");

        if(results.isEmpty()) {
            System.out.println("Search results not found!");
        } else {
            //treats ArrayList elements as objects and prints each one out
            results.forEach(result -> System.out.println(result));
        }
    }

    public static void searchLastName() {
        System.out.println("Enter your search: ");
        String search = scanner.nextLine();
        ArrayList results = book.searchLast(search);
        System.out.println("YOUR SEARCH RESULTS");
        //treats ArrayList elements as objects and prints each one out
        results.forEach(result -> System.out.println(result));
    }

    public static void searchPhoneNumber() {
        System.out.println("Enter your search: ");
        String search = scanner.nextLine();
        ArrayList results = book.searchPhone(search);
        System.out.println("YOUR SEARCH RESULTS");
        //treats ArrayList elements as objects and prints each one out
        results.forEach(result -> System.out.println(result));
    }

    public static void searchEmailAddy() {
        System.out.println("Enter your search: ");
        String search = scanner.nextLine();
        ArrayList results = book.searchEmail(search);
        System.out.println("YOUR SEARCH RESULTS");
        //treats ArrayList elements as objects and prints each one out
        results.forEach(result -> System.out.println(result));
    }


    public static void main(String[] args) {
        System.out.println("=========== Welcome to Address Book ==========");
        boolean quit = false;
        int choice = 0;

        do {
            printInstructions();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1 -> addEntry();
                case 2 -> removeEntry();
                case 3 -> searchOptions();
                case 4 -> book.printAddressBook();
                case 5 -> clearBook();
                case 6 -> quit = true;

            }
        } while(!quit);

    }
}
