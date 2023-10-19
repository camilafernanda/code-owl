package br.com.codeowl.models;

import br.com.codeowl.validations.CommonValidations;

import java.util.List;

public class Category {
    private String name;
    private String code;
    private String description;
    private String studyGuide;
    private boolean available;
    private int sequence;
    private String iconImage;
    private String colorCode;

    public Category(String name, String code) {
        CommonValidations.validateName(name);
        CommonValidations.validateCode(code);
        this.name = name;
        this.code = code;
    }

    public Category(String name, String code, boolean available) {
        CommonValidations.validateName(name);
        CommonValidations.validateCode(code);
        this.name = name;
        this.code = code;
        this.available = available;
    }

    public Category(String name, String code, String description, boolean available, int sequence, String iconImage, String colorCode) {
        CommonValidations.validateName(name);
        CommonValidations.validateCode(code);
        if (!colorCode.matches("^#[0-9A-Fa-f]{6}$")){
            throw new IllegalArgumentException("O código da cor deve ser um valor hexadecimal válido.");
        }
        this.name = name;
        this.code = code;
        this.description = description;
        this.available = available;
        this.sequence = sequence;
        this.iconImage = iconImage;
        this.colorCode = colorCode;
    }

    public Category(String name, String code, String description, String studyGuide, boolean available, int sequence, String iconImage, String colorCode) {
        CommonValidations.validateName(name);
        CommonValidations.validateCode(code);
        if (!colorCode.matches("^#[0-9A-Fa-f]{6}$")){
            throw new IllegalArgumentException("O código da cor deve ser um valor hexadecimal válido.");
        }
        this.name = name;
        this.code = code;
        this.description = description;
        this.studyGuide = studyGuide;
        this.available = available;
        this.sequence = sequence;
        this.iconImage = iconImage;
        this.colorCode = colorCode;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "*** Categoria ***" + "\n" +
                "Nome: " + name + "\n" +
                "Code: " + code + "\n" +
                "Descrição: " + description + "\n" +
                "Guia de estudo: " + studyGuide + "\n" +
                "Disponível: " + available + "\n" +
                "Ordem: " + sequence + "\n" +
                iconImage + "\n" +
                colorCode + "\n\n";
    }
}
