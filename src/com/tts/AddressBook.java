package com.tts;

import java.util.ArrayList;

public class AddressBook {


    // creating a private instance of ArrayList using Entry as it's elements.
    private ArrayList<Entry> addressBook = new ArrayList<>();

// ======================== ADD METHOD =========================
    //adds entry if the email does not already exist
    public boolean addAddressBook(String first, String last, String phone, String email) {

        boolean wasAdded;
        //loops through all emails within AddressBook
        findEmail(email);
        //if email already exists, it will return false.
        if (findEmail(email) >= 0) {
            wasAdded = false;

        } else {
            //if email does not already exist, it will return true.
            wasAdded = true;
            //passes in the String parameters and creates a new Entry object passing
            //in the parameters into the Entry constructor.
            //don't need setters using this method.
            addressBook.add(new Entry(first, last, phone, email));

        }
        return wasAdded;
    }
// =============== REMOVE METHOD ==============================
    //the method removing the object from ArrayList.
    private void removeAddressBook(int position) {
        addressBook.remove(position);
    }

    //uses findEmail method and passes the user's entry as the parameter.
    //if findEmail returns something greater than -1, meaning the email exists,
    //that entry will be removed.
    public boolean removeAddressBook(String email) {
        int position = findEmail(email);
        boolean doesExist;

        if (position == -1) {
            doesExist = false;

        } else {
            doesExist = true;
            removeAddressBook(position);
        }
        return doesExist;
    }

    // ========================== STORE/RESTORE METHOD =======================
    //create an object that will store the entry if it exists
    private Entry storedEntry = null;
    public void storeEntry (String email) {
        Entry savedEntry = null;
        int position = findEmail(email);
        if(position >= 0){
            savedEntry = addressBook.get(position);
        }
       storedEntry = savedEntry;
    }
    //adds that storedEntry back into the ArrayList/AddressBook
    public void restore() {
        if(storedEntry != null) {
            addressBook.add(storedEntry);
            System.out.println(storedEntry.getEmail() + " has been restored");
        } else {
            System.out.println("Error: No email has been deleted");
        }
    }

// ======================== FIND EMAIL METHOD ===============================
    //loops through entries and finds the email that matches the user's input.
    //if the email is found, it will return the indexed position of that entry.
    // if the email is not found it will return -1.
    private int findEmail(String searchEmail) {
        int result = -1;

        for (int i = 0; i < addressBook.size(); i++) {
            Entry myEntry = addressBook.get(i);
            String emails = myEntry.getEmail();
            if (searchEmail.equals(emails)) {
                result = i;
                break;
            }
        }
        return result;
    }


//    ======================= PRINT ADDRESS BOOK METHOD ========================
    //loops through the ArrayList and prints out the information in the required format
    public void printAddressBook() {
        System.out.println("******** ADDRESS BOOK *********");
        if (addressBook.isEmpty()) {
            System.out.println("There are no entries within your Address Book");
        } else {
            for (int i = 0; i < addressBook.size(); i++) {
                Entry myEntry = addressBook.get(i);

                System.out.println("************");
                System.out.println("First Name: " + myEntry.getFirstName());
                System.out.println("Last Name: " + myEntry.getLastName());
                System.out.println("Phone Number: " + myEntry.getPhone());
                System.out.println("Email: " + myEntry.getEmail());
            }
        }

    }
// ================================== SEARCH METHODS ====================================

//loops through the ArrayList and finds all FirstNames that contain the characters to user requests (String firstName)
//if any are found, they are added to a separate ArrayList called searches and then searches is returned.
    public ArrayList<Entry> searchFirst(String firstName) {
        ArrayList<Entry> searches = new ArrayList<>();

        for (int i = 0; i < addressBook.size(); i++) {
            Entry myEntry = addressBook.get(i);

            if (myEntry.getFirstName().contains(firstName)) {
                searches.add(myEntry);
            }
        }
        return searches;
    }
//works the same way as the above code.
    public ArrayList<Entry> searchLast(String lastName){
        ArrayList<Entry> searches = new ArrayList<>();

        for (int i = 0; i < addressBook.size(); i++) {
            Entry myEntry = addressBook.get(i);

            if (myEntry.getLastName().contains(lastName)) {
                searches.add(myEntry);
            }
        }
        return searches;
    }
    //works the same way as the above code.
    public ArrayList<Entry> searchPhone(String phone){
        ArrayList<Entry> searches = new ArrayList<>();

        for (int i = 0; i < addressBook.size(); i++) {
            Entry myEntry = addressBook.get(i);

            if (myEntry.getPhone().contains(phone)) {
                searches.add(myEntry);
            }
        }
        return searches;
    }
    //works the same way as the above code.
    public ArrayList<Entry> searchEmail(String email){
        ArrayList<Entry> searches = new ArrayList<>();

        for (int i = 0; i < addressBook.size(); i++) {
            Entry myEntry = addressBook.get(i);

            if (myEntry.getEmail().contains(email)) {
                searches.add(myEntry);
            }
        }
        return searches;
    }
    //    ======================= DELETE ADDRESS BOOK METHOD ========================

    // Uses ArrayList class method .clear() to clear the entire ArrayList addressBook
    public void deleteAddressBook() {
        addressBook.clear();
    }
}