package com.cuongnt.utils;

import java.util.regex.Pattern;

public class Utils {

    private static Pattern phoneNumberPattern;

    public static boolean validatePhoneNumber(String phoneNumber) {
        phoneNumberPattern = Pattern.compile("\\d{10,15}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");
        return phoneNumberPattern.matcher(phoneNumber).matches();
    }
}
