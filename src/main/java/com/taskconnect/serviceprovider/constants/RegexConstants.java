package com.taskconnect.serviceprovider.constants;

public interface RegexConstants {
    // The following REGEX is meant to match Brazilian phone numbers.
    /**
     * \d{n} matches the given n quantity of integers.
     */
    String PHONE_NUMBER = "^\\(?(\\d{2}\\)? ?)\\d{4,5}[ -]?\\d{4}$";
    String EMAIL = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*(\\+[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    /**
     * \p{L} matches any unicode letter character.
     * <p>
     * Although there are known cases, the following regex doesn't match too unusual names
     * such as those that include numbers or a single character.
     */
    String FULL_NAME = "^[\\p{L}'-] [\\p{L}'-]+$";
}
