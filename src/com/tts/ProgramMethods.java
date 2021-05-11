package com.tts;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgramMethods {


    public static void printInstructions() {
        //create an exception for when someone types a letter instead of a number.
        System.out.println("\n Press To:");
        System.out.println("\t 1 - Add an Entry");
        System.out.println("\t 2 - Remove an Entry");
        System.out.println("\t 3 - Restore last removed entry");
        System.out.println("\t 4 - Search for a specific Entry");
        System.out.println("\t 5 - Print Address Book");
        System.out.println("\t 6 - Delete entire Address Book");
        System.out.println("\t 7 - Quit");
        System.out.println("Choose an option: ");
    }

// ============================ EDITING METHODS ===============================
    public static void addEntry(Scanner scanner, AddressBook book) {
//create a check to make sure these are in the correct format
        System.out.println("First Name: ");
        String first = scanner.next();
        System.out.println("Last Name: ");
        String last = scanner.next();
        System.out.println("Phone Number (###-###-#### / ###.###.####)");
        String phone = scanner.next();


        Pattern pattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");
        Matcher matcher = pattern.matcher(phone);

        while(matcher.matches() != true) {
            System.out.println("Wrong format, please try again.");
            phone = scanner.next();
            matcher = pattern.matcher(phone);
        }


        System.out.println("Email Address: ");
        String email = scanner.next();

//checks to make sure the email doesn't already exist by comparing the return of .addAddressBook()

        while (book.addAddressBook(first, last, phone, email) == false) {
            System.out.println("Email already exists within Address Book. Please try again.");
            System.out.println("First Name: ");
            first = scanner.next();
            System.out.println("Last Name: ");
            last = scanner.next();
            System.out.println("Phone Number (###-###-#### / ###.###.####)");
            phone = scanner.next();


           pattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");
           matcher = pattern.matcher(phone);

            while(matcher.matches() != true) {
                System.out.println("Wrong format, please try again.");
                phone = scanner.next();
                matcher = pattern.matcher(phone);
            }
            System.out.println("Email Address: ");
            email = scanner.next();
        }

        System.out.println("Entry added!! :)");


//        if (book.addAddressBook(first, last, phone, email) == true) {
//            System.out.println("Entry added!!   :)");
//        } else{
//            System.out.println("Email already exists within Address Book.");
//        }
    }


    //searches for email in book and removes that entry if entry exists.
    //it also will store that entry so that it can be restored.
    public static void removeEntry(Scanner scanner, AddressBook book) {

        System.out.println("Please enter email of entry you wish to delete");
        String email = scanner.nextLine();
        book.storeEntry(email);

        if (book.removeAddressBook(email) == true) {
            System.out.println("Entry has been removed from Address Book");
        } else {
            System.out.println(email + " does not exist within Address Book");
        }
    }


    //deletes the entire AddressBook.
    public static void clearBook(AddressBook book) {
        book.deleteAddressBook();
        System.out.println("All entries have been deleted.");
    }



    // ========================== SEARCH METHODS ============================
    public static void searchOptions(Scanner scanner, AddressBook book) {
        //create an exception for someone types a letter instead of number
        System.out.println("\t 1 - First Name");
        System.out.println("\t 2 - Last Name");
        System.out.println("\t 3 - Phone Number");
        System.out.println("\t 4 - Email Address");
        System.out.println("Choose a search option: ");
        int searchOption = 0;
        try {
            searchOption = scanner.nextInt();
        } catch (InputMismatchException e) {
        }
        scanner.nextLine();

        if(searchOption <= 0 || searchOption > 4) {
            System.out.println("Invalid option, please try again");
        }
        switch(searchOption) {
            case 1 -> searchFirstName(scanner, book);
            case 2 -> searchLastName(scanner, book);
            case 3 -> searchPhoneNumber(scanner, book);
            case 4 -> searchEmailAddy(scanner, book);
        }


    }

    public static void searchFirstName(Scanner scanner, AddressBook book) {
        System.out.println("Enter your search: ");
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

    public static void searchLastName(Scanner scanner, AddressBook book) {
        System.out.println("Enter your search: ");
        String search = scanner.nextLine();
        ArrayList results = book.searchLast(search);
        System.out.println("YOUR SEARCH RESULTS");
        //treats ArrayList elements as objects and prints each one out
        results.forEach(result -> System.out.println(result));
    }

    public static void searchPhoneNumber(Scanner scanner, AddressBook book) {
        System.out.println("Enter your search: ");
        String search = scanner.nextLine();
        ArrayList results = book.searchPhone(search);
        System.out.println("YOUR SEARCH RESULTS");
        //treats ArrayList elements as objects and prints each one out
        results.forEach(result -> System.out.println(result));
    }

    public static void searchEmailAddy(Scanner scanner, AddressBook book) {
        System.out.println("Enter your search: ");
        String search = scanner.nextLine();
        ArrayList results = book.searchEmail(search);
        System.out.println("YOUR SEARCH RESULTS");
        //treats ArrayList elements as objects and prints each one out
        results.forEach(result -> System.out.println(result));
    }
}
