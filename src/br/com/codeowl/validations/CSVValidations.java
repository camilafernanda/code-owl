package br.com.codeowl.validations;

import br.com.codeowl.models.Subcategory;

import java.util.Scanner;

public class CSVValidations {
    public static String validateStringNullField(String field) {
        if (field == null || field.isBlank() || field.isEmpty()) {
            return "";
        }
        return field;
    }

    public static int validateIntField(String field) {
            try {
                return Integer.parseInt(field);
            } catch (NumberFormatException e) {
                return 0;
            }
    }
}
