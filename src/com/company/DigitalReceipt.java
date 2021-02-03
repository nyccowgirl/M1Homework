package com.company;

public class DigitalReceipt extends Receipt {

    private String email;

    public DigitalReceipt(Store store, int numberOfItems, double totalMoneySpent, String receiptID, String email) {
        super(store, numberOfItems, totalMoneySpent, receiptID);
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return super.toString() + "\t\tDigital copy sent to: " + email;
    }

    public static boolean validateEmail(String email) {
        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');
        boolean first = Character.isLetter(email.charAt(0));
        String afterDot = null;

        if (dotIndex != -1) {
            afterDot = email.substring(dotIndex + 1).trim();
        }

        return first && (atIndex > 0) && (dotIndex != -1) && (afterDot.length() == 3);
    }

}
