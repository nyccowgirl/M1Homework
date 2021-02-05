package com.company;

import java.util.*;

public class HomeworkM1Driver {

    public static void main(String[] args) {

        // Store objects to use in testing
        Store groceryStore1 = new Store("Foods R Us", "Smallerville");
        Store groceryStore2 = new Store("Foods R Us", "Unioner City");
        Store electronicStore = new Store("ElectroFun", "Unioner City");
        Store bookStore = new Store("The Bookworm", "Eastchester");

        // receipt objects to use in testing
        Receipt receipt1 = new Receipt(groceryStore1, 10, 99.47, "a1x1m1m1");
        Receipt receipt2 = new Receipt(groceryStore1, .99, "vbevb0vv");
        Receipt receipt3 = new Receipt(groceryStore2, 21, 219.42, "h2g2b2gb");
        Receipt receipt4 = new Receipt(electronicStore, 599.99, "avvz0avv");
        DigitalReceipt digitalReceipt1 = new DigitalReceipt(bookStore, 50, 525.25, "bxxbxx3x", "sir.reads.a.lot@books.com");
        DigitalReceipt digitalReceipt2 = new DigitalReceipt(bookStore, 1, 4.87, "uuu3fqqq", "mark.darcy@gmail.abc");
        DigitalReceipt digitalReceipt3 = new DigitalReceipt(electronicStore, 2, 139.21, "xxx2m2xx", "dr.frankenstein@monster.com");
        DigitalReceipt digitalReceipt4 = new DigitalReceipt(groceryStore1, 18, 78.41, "ybbby99y", "t@iced.com");
        Receipt[] receipts = {receipt1, receipt2, receipt3, receipt4, digitalReceipt1, digitalReceipt2, digitalReceipt3, digitalReceipt4};

        System.out.println("******************************Testing toString");
        // digital receipts should show the email
        for(Receipt receipt : receipts) {
            System.out.println(receipt);
        }

        System.out.println("\n\n******************************Testing use of Store object");
        // print out three receipts whose Store is located in "Unioner City"
        System.out.println("Should show \"Unioner City\" in the output:");
        System.out.println("\t"+receipt3);
        System.out.println("\t"+receipt4);
        System.out.println("\t"+digitalReceipt3);

        // now update the location of the Store object
        // the update should be seen in the receipt object
        groceryStore2.setCity("Union City");
        electronicStore.setCity("Union City");
        System.out.println("Now should show \"Union City\" in the output:");
        System.out.println("\t"+receipt3);
        System.out.println("\t"+receipt4);
        System.out.println("\t"+digitalReceipt3);

        System.out.println("\n\n******************************Testing equals method");
        // this method creates a copy of each receipt and puts the copy in the list
        // the method then calls contains to test if the receipt is equal to one on the list
        // if equals works correctly, the call to contains will return true
        testEqualsMethod(receipts);

        System.out.println("\n\n******************************Testing Receipt Criteria");
        // parameters 1-3: the ones passed into the meetsCriteria method
        // parameter4: the receipt whose id is tested
        // parameter 5: is the expected result (true if the receipt meets the criteria, false otherwise)
        // parameter 6: a description of the test
        testReceiptCriteria('x', 'm', 2, receipt1, true, "exactly 2 m's (secondChar) after x (firstChar)");
        testReceiptCriteria('e', 'v', 3, receipt2, true, "exactly 3 v's (secondChar) after e (firstChar); also 1 extra v before e- that doesn't affect the criteria");
        testReceiptCriteria('g', 'b', 2, receipt3, true, "exactly 2 b's (secondChar) after the first g (firstChar); also a second g- that doesn't affect the criteria");
        testReceiptCriteria('g', 'h', 0, receipt3, true, "exactly 0 h's (secondChar) after the first g (firstChar); also an h before the g- that doesn't affect the criteria");
        testReceiptCriteria('b', 'z', 0, digitalReceipt1, true, "exactly 0 z's (secondChar) after the first b (firstChar)");

        testReceiptCriteria('z', 'a', 2, receipt4, false, "only 1 a (secondChar) after the z (firstChar)- the other a comes before the z");
        testReceiptCriteria('f', 'q', 2, digitalReceipt2, false, "3 q's (secondChar) after the f (firstChar) instead of 2");
        testReceiptCriteria('k', 'm', 1, digitalReceipt3, false, "no k (firstChar)");
        testReceiptCriteria('b', 'b', 3, digitalReceipt4, false, "the first b is the firstChar; there are then only 2 *other b's* (that are the second char) after that instead of 3");

        System.out.println("\n\n******************************Testing e-Mail Validator (Extra Credit)");
        // parameter 1: the email to test
        // parameter 2: the expected result (true if the email is valid, false otherwise)
        // parameter 3: a description of the test
        String validEmailDescription = "at least one letter somewhere before the @ and exactly three characters after the last period";
        testEmailValidator("sir.reads.a.lot@books.com", true, validEmailDescription);
        testEmailValidator("mark.darcy@gmail.abc", true, validEmailDescription);
        testEmailValidator("dr.frankenstein@monster.com", true, validEmailDescription);
        testEmailValidator("t@iced.com", true, validEmailDescription);
        testEmailValidator("ina@hurry.edu", true, validEmailDescription);
        testEmailValidator("morris?@better.gov", true, validEmailDescription);

        testEmailValidator("@abc.xyz", false, "no characters before @");
        testEmailValidator("abc.com", false, "no @");
        testEmailValidator("j@com", false, "no period");
        testEmailValidator("jessica@com", false, "no period");
        testEmailValidator("j.m@gmail.comm", false, "4 chars after the last period");
        testEmailValidator("j.m@gmail.hi", false, "2 chars after the last period");
        testEmailValidator("j.m@gmail.z", false, "1 char after period");
        testEmailValidator("abcdef", false, "no @ or period");
        testEmailValidator("!@abc.def", false, "there are no letters before the @");
    }

    /*
     * The methods below are designed to help support the tests cases run from main. You don't
     * need to use, modify, or understand these methods. You can safely ignore them. :)
     */
    public static void testEqualsMethod(Receipt[] receipts) {
        List<Receipt> receiptList = new ArrayList<Receipt>();
        for(Receipt receipt : receipts) {
            Receipt copyReceipt;
            if(receipt instanceof DigitalReceipt) {
                copyReceipt = new DigitalReceipt(receipt.getStore(), receipt.getNumberOfItems(), receipt.getTotal(), new String(receipt.getReceiptID()), ( (DigitalReceipt) receipt).getEmail());
            } else {
                copyReceipt = new Receipt(receipt.getStore(), receipt.getNumberOfItems(), receipt.getTotal(), new String(receipt.getReceiptID()));
            }
            receiptList.add(copyReceipt);
        }
        boolean passContainsTests = true;
        for(Receipt receipt : receipts) {
            boolean contains = receiptList.contains(receipt);
            if(contains!=true) {
                System.out.println("***Test failed: equals method failed when testing equality of receipt: " + receipt);
                passContainsTests = false;
            }
        }
        if(passContainsTests) {
            System.out.println("All contains tests passed.");
        }
    }
    public static void testReceiptCriteria(char firstChar, char secondChar, int timesAfter, Receipt receipt, boolean expectedResult, String testDescription) {
        boolean actualResult = receipt.meetsReceiptCriteria(firstChar,  secondChar,  timesAfter);
        System.out.print("Expected=" + expectedResult + "\tActual=" + actualResult +
                "\tID=" + receipt.getReceiptID() + "  firstChar=" + firstChar + "  secondChar=" + secondChar +
                "  timesAfter=" + timesAfter);
        if(actualResult!=expectedResult) {
            System.out.print("\n\t\t***Test failed: " + testDescription + "\n");
        }
        System.out.println();
    }
    public static void testEmailValidator(String email, boolean expectedResult, String testDescription) {
        boolean actualResult = DigitalReceipt.validateEmail(email);
        System.out.print("Expected=" + expectedResult + "\tActual=" + actualResult +
                "\temail=" + email);
        if(actualResult!=expectedResult) {
            System.out.print("\t\t***Test failed: " + testDescription);
        }
        System.out.println();
    }
}

