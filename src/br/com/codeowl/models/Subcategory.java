package br.com.codeowl.models;

import br.com.codeowl.validations.CommonValidations;

public class Subcategory {

    private String name;
    private String code;
    private String description;
    private String studyGuide;
    private boolean available;
    private int sequence;
    private Category category;

    public Subcategory(String name, String code, Category category) {
        CommonValidations.validateName(name);
        CommonValidations.validateCode(code);
        this.name = name;
        this.code = code;
        this.category = category;
    }

    public Subcategory(String name, String code, Category category, String description, boolean available, int sequence) {
        CommonValidations.validateName(name);
        CommonValidations.validateCode(code);
        this.name = name;
        this.code = code;
        this.category = category;
        this.description = description;
        this.available = available;
        this.sequence = sequence;
    }

    public Subcategory(String name, String code, Category category, String description, String studyGuide, boolean available, int sequence) {
        CommonValidations.validateName(name);
        CommonValidations.validateCode(code);
        this.name = name;
        this.code = code;
        this.category = category;
        this.description = description;
        this.studyGuide = studyGuide;
        this.available = available;
        this.sequence = sequence;
    }

    public String getCode() {
        return code;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "*** Subcategoria ***" + "\n" +
                "Nome: " + name + "\n" +
                "Code: " + code + "\n" +
                "Descrição: " + description + "\n" +
                "Gui de estudo: " + studyGuide + "\n" +
                "Disponível: " + available + "\n" +
                "Ordem: " + sequence + "\n" +
                "Categoria a qual faz parte: " + "\n" + category.getCode() + "\n\n";
    }
}
