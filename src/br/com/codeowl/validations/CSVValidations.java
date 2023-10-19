package br.com.codeowl.validations;

import br.com.codeowl.models.Subcategory;

import java.util.Scanner;

public class CSVValidations {
    public static String validateStringNullField(String field, String fieldName) {
        if (field == null || field.isBlank() || field.isEmpty()) {
//            System.out.println("O campo " + fieldName + " é inválido. Preencha manualmente: ");
//            Scanner scanner = new Scanner(System.in);
//            return scanner.nextLine();
            return "";
        }
        return field;
    }

    public static int validateIntField(String field, String fieldName) {
//        if (field == null || field.isBlank()) {
//            return 0;
//        }
//        while (true) {
            try {
                return Integer.parseInt(field);
            } catch (NumberFormatException e) {
//                System.out.println("O campo " + fieldName + " é inválido. Insira um valor numérico válido: ");
//                Scanner scanner = new Scanner(System.in);
//                field = scanner.nextLine();
                return 0;
            }
    }
}
