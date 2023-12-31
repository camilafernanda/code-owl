package br.com.codeowl.models;

public class CommonValidations {

    public static void validateName(String name) {
        if (name==null || name.isBlank()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }
    }

    public static void validateCode(String code) {
        if (code==null || code.isBlank() || !code.matches("^[a-z0-9-]+$")) {
            throw new IllegalArgumentException("O código é obrigatório e deve ser composto apenas por letras minúsculas ou números, separados por hífen.");
        }
    }

    public static void validateTitle(String title) {
        if (title==null || title.isBlank()) {
            throw new IllegalArgumentException("O título é obrigatório.");
        }
    }

    public static void validateText(String text) {
        if (text==null || text.isBlank()) {
            throw new IllegalArgumentException("O texto é obrigatório.");
        }
    }
}
