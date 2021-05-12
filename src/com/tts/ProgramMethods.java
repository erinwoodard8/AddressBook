package com.tts;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgramMethods {


    public static void printInstructions() {

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

    // ======================== ADD METHOD =========================
    public static void addEntry(Scanner scanner, AddressBook book) {

        System.out.println("First Name: ");
        String first = scanner.next();
        System.out.println("Last Name: ");
        String last = scanner.next();
        System.out.println("Phone Number (###-###-#### / ###.###.####)");
        String phone = scanner.next();

// matcher checks to make sure the pattern is correct for phone numbers using regex while the .matches is false.
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
// this looks like repeat code, but it needs to repeat above code if .addAddressBook returns false.
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

    }

    // =============== REMOVE METHOD ==============================

    //searches for email in book and removes that entry if entry exists.
    public static void removeEntry(Scanner scanner, AddressBook book) {

        System.out.println("Please enter email of entry you wish to delete");
        String email = scanner.next();
        book.storeEntry(email);

        if (book.removeAddressBook(email) == true) {
            System.out.println(email + " has been removed from Address Book");
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
        String searchOption = null;

        try {
            searchOption = scanner.next();
        } catch (InputMismatchException e) {
            System.out.println("Something went wrong.");
        }

        scanner.nextLine();

            switch(searchOption) {
                case "1" -> searchFirstName(scanner, book);
                case "2" -> searchLastName(scanner, book);
                case "3" -> searchPhoneNumber(scanner, book);
                case "4" -> searchEmailAddy(scanner, book);
                default -> printInstructions();
        }
    }
// using .searchFirst method and stores results in an ArrayList. Returns ArrayList.
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
    // using .searchLast method and stores results in an ArrayList. Returns ArrayList.
    public static void searchLastName(Scanner scanner, AddressBook book) {
        System.out.println("Enter your search: ");
        String search = scanner.nextLine();
        ArrayList results = book.searchLast(search);
        System.out.println("YOUR SEARCH RESULTS");
        //treats ArrayList elements as objects and prints each one out
        results.forEach(result -> System.out.println(result));
    }
    // using .searchPhone method and stores results in an ArrayList. Returns ArrayList.
    public static void searchPhoneNumber(Scanner scanner, AddressBook book) {
        System.out.println("Enter your search: ");
        String search = scanner.nextLine();
        ArrayList results = book.searchPhone(search);
        System.out.println("YOUR SEARCH RESULTS");
        //treats ArrayList elements as objects and prints each one out
        results.forEach(result -> System.out.println(result));
    }
    // using .searchEmail method and stores results in an ArrayList. Returns ArrayList.
    public static void searchEmailAddy(Scanner scanner, AddressBook book) {
        System.out.println("Enter your search: ");
        String search = scanner.nextLine();
        ArrayList results = book.searchEmail(search);
        System.out.println("YOUR SEARCH RESULTS");
        //treats ArrayList elements as objects and prints each one out
        results.forEach(result -> System.out.println(result));
    }
}
