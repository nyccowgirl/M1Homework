package com.company;

import java.text.NumberFormat;

public class Receipt {

    private Store store;
    private int numberOfItems;
    private double totalMoneySpent;
    private String receiptID;
    public static final int DEFAULT_QUANTITY = 1;

    public Receipt(Store store, int numberOfItems, double totalMoneySpent, String receiptID) {
        this.store = store;
        this.numberOfItems = numberOfItems;
        this.totalMoneySpent = totalMoneySpent;
        this.receiptID = receiptID;
    }

    public Receipt(Store store, double totalMoneySpent, String receiptID) {
        this(store, DEFAULT_QUANTITY, totalMoneySpent, receiptID);
    }

    public Store getStore() {
        return store;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public double getTotal() {
        return totalMoneySpent;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setNumberOfItems(int numberOfItems) {
        if(numberOfItems < 0) {
            System.out.println("Error - number of items cannot be negative.");
        }

        this.numberOfItems = numberOfItems;
    }

    public void setTotalMoneySpent(double totalMoneySpent) {
        this.totalMoneySpent = totalMoneySpent;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public String toString() {
        String moneyString = NumberFormat.getCurrencyInstance().format(totalMoneySpent);
        String item = numberOfItems > 1 ? " items" : " item\t";

        return "Receipt " + receiptID + "\t\tStore: " + store + "\t\t" + numberOfItems + item + "\t\tTotal: " + moneyString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Receipt)) return false;
        Receipt receipt = (Receipt) o;
        return getNumberOfItems() == receipt.getNumberOfItems() &&
                Double.compare(receipt.getTotal(), getTotal()) == 0 &&
                getStore().equals(receipt.getStore()) &&
                getReceiptID().equalsIgnoreCase(receipt.getReceiptID());
    }

    public boolean meetsReceiptCriteria(char firstCharacter, char secondCharacter, int numberTimesSecondAppearsAfterFirst) {
        int count = 0;
        int index = receiptID.indexOf(firstCharacter);

        if (index == -1) {
            return false;
        } else {
            do {
                index++;
                index = receiptID.indexOf(secondCharacter, index);

                if (index != -1) {
                    count++;
                }

            } while (index != -1);

            return count == numberTimesSecondAppearsAfterFirst;
        }
    }

}
