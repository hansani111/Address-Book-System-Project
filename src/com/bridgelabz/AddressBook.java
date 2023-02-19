package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    /* Taking Array list to save the contacts */
    List<Contact> arrayList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    /* Creating contact with this method */
    void addContactDetails() {
        String firstName = null;
        String lastName = null;

        boolean flag = true;
        while (flag) {
            System.out.println("Enter FirstName");
            firstName = sc.next();

            System.out.println("Enter LastName");
            lastName = sc.next();

            flag = checkContactExist(firstName, lastName);
        }

        System.out.println("Enter the Address :");
        String address = sc.next();
        System.out.println("Enter the City :");
        String city = sc.next();
        System.out.println("Enter the State :");
        String state = sc.next();
        System.out.println("Enter the Zip :");
        String zip = sc.next();
        System.out.println("Enter the Phone Number :");
        String phoneNumber = sc.next();
        System.out.println("Enter the Email :");
        String email = sc.next();

        Contact contact = new Contact();

        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setAddress(address);
        contact.setCity(city);
        contact.setState(state);
        contact.setZip(zip);
        contact.setPhoneNumber(phoneNumber);
        contact.setEmail(email);
        System.out.println(contact);

        arrayList.add(new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));

        System.out.println("Contact added successfully.Total contact present in the current adressbook =  " +
                arrayList.size());
    }

    /* Checking if given First name & Last name is already present in the arraylist or not */
    private boolean checkContactExist(String firstName, String lastName) {
        for (Contact contact : arrayList) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                System.out.println(
                        "Another contact is already present with the same Name. So please try with different name.");
                return true;
            }
        }
        return false;
    }

    /* edit the contact */
    void editContactDetails() {
        if (arrayList.size() == 0) {
            System.out.println("There is no contact present in addressbook. Please add at least one contact first to edit.");
            addContactDetails();
            return;
        }
        System.out.println("Enter the Firstname of the contact which you want to edit :  ");
        String name = sc.next();
        boolean flag1 = false;

        for (int person = 0; person < arrayList.size(); person++) {  //for all the contacts in the arraylist
            if (arrayList.get(person).getFirstName().equals(name)) {
                flag1 = true;
                System.out.println("Please select any one option(1-8) to change the contact details" + "\n" + "PRESS 1 to edit FirstName" + "\n"
                        + "PRESS 2 to edit Lastname" + "\n" + "PRESS 3 to edit Address" + "\n" + "PRESS 4 to edit City" + "\n"
                        + "PRESS 5 to edit State" + "\n" + "PRESS 6 to edit zip" + "\n" + "PRESS 7 to edit PhoneNumber" + "\n"
                        + "PRESS 8 to edit Email");

                int choiceEdit = sc.nextInt();
                switch (choiceEdit) {
                    case 1:
                        System.out.println("Enter new FirstName : ");
                        arrayList.get(person).setFirstName(sc.next());
                        break;

                    case 2:
                        System.out.println("Enter new Lastname : ");
                        arrayList.get(person).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter new Address : ");
                        arrayList.get(person).setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Enter new City : ");
                        arrayList.get(person).setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter new State :  ");
                        arrayList.get(person).setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter new ZIP : ");
                        arrayList.get(person).setZip(sc.next());
                        break;
                    case 7:
                        System.out.println("Enter new PhoneNumber : ");
                        arrayList.get(person).setPhoneNumber(sc.next());
                        break;
                    case 8:
                        System.out.println("Enter new Email : ");
                        arrayList.get(person).setEmail(sc.next());
                        break;
                    default:
                        System.out.println("Wrong choice!!!! Please try again later. ");
                        return;
                }
                System.out.println("Details of the contact after edited: ");
                System.out.println(arrayList.get(person));
                return;
            }
        }
        if (flag1 == false)
            System.out.println("Sorry!!! There is no such contact present. Please check the firstname and try again.");
    }

    /* Delete a contact */
    void deleteContactDetails() {
        if (arrayList.size() == 0) {
            System.out.println("There is no contact present in adressbook. Please add atleast one contact first to delete.");
            addContactDetails();
            return;
        }
        System.out.println("Enter the FirstName of the contact which you want to delete :  ");
        String name = sc.next();
        boolean flag1 = false;
        for (int person = 0; person < arrayList.size(); person++) {
            if (arrayList.get(person).getFirstName().equals(name)) {
                flag1 = true;
                arrayList.remove(person);
                System.out.println("Contact Deleted!!!!!!!!");
                return;
            }
        }
        if (flag1 == false)
            System.out.println("Sorry!!! There is no such contact present. Please check the firstname and try again.");
    }

    /* Add Multiple contacts */
    void addMultipleContacts() {
        System.out.println("How many contacts do you want to add now : ");
        int number = sc.nextInt();
        if (number <= 0) {
            System.out.println("Invalid Input !!!!!!!");
        } else {
            for (int i = 0; i <= number; i++) {
                addContactDetails();
                System.out.println("(" + i + "Contact Added...)");
            }
        }
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "arrayList=" + arrayList +
                '}';
    }

    public void showContactDetails() {
        System.out.println("Enter the firstname of the contact to see the details : ");
        String name = sc.next();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getFirstName().equals(name)) {
                System.out.println(arrayList.get(i));
                return;
            }
        }
        System.out.println("Contact NOT FOUND!!! Check the First name and try again.");
    }
}