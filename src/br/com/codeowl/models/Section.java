package br.com.codeowl.models;

import br.com.codeowl.validations.CommonValidations;

public class Section {

    private String name;
    private String code;
    private int sequence;
    private boolean available;
    private boolean test;
    private Course course;

    public Section(String name, String code, Course course) {
        CommonValidations.validateName(name);
        CommonValidations.validateCode(code);
        this.name = name;
        this.code = code;
        this.course = course;
    }

    public Section(String name, String code, Course course, int sequence, boolean available, boolean test) {
        CommonValidations.validateName(name);
        CommonValidations.validateCode(code);
        this.name = name;
        this.code = code;
        this.course = course;
        this.sequence = sequence;
        this.available = available;
        this.test = test;
    }

    @Override
    public String toString() {
        return "*** Seção ***" + "\n" +
                "Nome: " + name + "\n" +
                "Code: " + code + "\n" +
                "Ordem: " + sequence + "º\n" +
                "Disponível: " + available + "\n";
    }
}
