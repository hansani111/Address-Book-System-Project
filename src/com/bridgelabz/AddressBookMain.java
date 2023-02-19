package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    static Scanner sc = new Scanner(System.in);

    static HashMap<String, AddressBook> allAddressBookHashMap = new HashMap<>();

    private static Map<String, ArrayList<Contact>> cityMap = new HashMap<>();
    private static Map<String, ArrayList<Contact>> stateMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("-----Welcome to Address Book Project-----");

        boolean flag = true;
        while (flag) {
            System.out.println("\n" + "************* Main Menu *************");
            System.out.println("1.Add New AddressBook" + "     " + "2.Show AddressBook details");
            System.out.println("3.Delete Addressbook" + "     " + " 4.Edit Addressbook");
            System.out.println("9. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addAddressbook();
                    break;
                case 2:
                    printAddressbook();
                    break;
                case 3:
                    deleteAddressbook();
                    break;
                case 4:
                    editAddressbook();
                    break;
                case 5:
                    sortByCity();
                    break;
                case 6:
                    sortByState();
                    break;
                case 0:
                    flag = false;
                    System.out.println("Successfully exited");
                    break;

                default:
                    System.out.println("INVALID INPUT !!!!!");
                    break;
            }
        }
    }

    private static void sortByState() {
        allAddressBookHashMap.forEach((name, adBook) ->
                adBook.arrayList.stream().forEach(contact -> {
                    if (stateMap.containsKey(contact.getCity())) {
                        stateMap.get(contact.getCity()).add(contact);
                    } else {
                        ArrayList<Contact> state = new ArrayList<>();
                        state.add(contact);
                        stateMap.put(contact.getCity(), state);
                    }
                })
        );
        System.out.println(stateMap);
    }

    private static void sortByCity() {
        allAddressBookHashMap.forEach((name, adBook) ->
                adBook.arrayList.stream().forEach(contact -> {
                    if (cityMap.containsKey(contact.getCity())) {
                        cityMap.get(contact.getCity()).add(contact);
                    } else {
                        ArrayList<Contact> city = new ArrayList<>();
                        city.add(contact);
                        cityMap.put(contact.getCity(), city);
                    }
                })
        );
        System.out.println(cityMap);

    }

    private static void addAddressbook() {
        System.out.println("Enter the name of the AddressBook : ");
        String addressBookName = sc.next();
        allAddressBookHashMap.put(addressBookName, new AddressBook());
    }

    private static void printAddressbook() {
        System.out.println(allAddressBookHashMap);
    }

    private static void deleteAddressbook() {
        if (allAddressBookHashMap.size() == 0) {
            System.out.println("There is no AddressBook present till now. Please add an AddressBook first.");
            return;
        }
        System.out.println("Enter the name of the AddressBook you want to delete : ");
        String addressBookName = sc.next();

        if (allAddressBookHashMap.containsKey(addressBookName)) {
            allAddressBookHashMap.remove(addressBookName);
            System.out.println("AddressBook Deleted SuccessFully!!!!!!");
        } else {
            System.out.println("AddressBook NOT FOUND with the name : " + addressBookName);
            System.out.println("Currently present AddressBooks are : " + allAddressBookHashMap.keySet());
        }
    }

    private static void editAddressbook() {
        if (allAddressBookHashMap.size() == 0) {
            System.out.println("There is no AddressBook Present till now. Please add an AddressBook first.");
            return;
        }

        System.out.println("Enter the name of the AdressBook which you want to edit : ");
        String addressBookName = sc.next();
        if (allAddressBookHashMap.containsKey(addressBookName)) {
            boolean flag = true;
            while (flag) {

                System.out.println("\n" + "************* AddressBook Menu *************");
                System.out.println("1.Add contact" + "        " + "2.Edit Contact");
                System.out.println("3.Delete contact" + "     " + "4. Show details of a particular contact");
                System.out.println("5. Show all contacts of " + addressBookName);
                System.out.println("6. Exit");

                int choice = sc.nextInt();
                switch (choice) {

                    case 1:
                        System.out.println("How many Contacts do you want to add : ");
                        int numOfContacts = sc.nextInt();

                        if (numOfContacts <= 0) {
                            System.out.println("INVALID INPUT !!!");
                        } else {
                            for (int i = 0; i < numOfContacts; i++) {
                                allAddressBookHashMap.get(addressBookName).addContactDetails();
                            }
                        }
                        break;

                    case 2:
                        allAddressBookHashMap.get(addressBookName).editContactDetails();
                        break;
                    case 3:
                        allAddressBookHashMap.get(addressBookName).deleteContactDetails();
                        break;
                    case 4:
                        allAddressBookHashMap.get(addressBookName).showContactDetails();
                        break;
                    case 5:
                        System.out.println(allAddressBookHashMap.get(addressBookName));
                        break;
                    case 6:
                        flag = false;
                        System.out.println("Successfully existed from " + addressBookName);
                        break;
                    default:
                        System.out.println("INVALID INPUT !!!!");
                        break;

                }
            }
        } else {
            System.out.println("SORRY!!! Adressbook NOT FOUND with the name " + addressBookName);
            System.out.println("Currently present AdressBooks are :  " + allAddressBookHashMap.keySet());
        }
    }
}