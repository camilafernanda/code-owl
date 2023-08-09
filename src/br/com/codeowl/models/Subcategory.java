package br.com.codeowl.models;

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

    public void setStudyGuide(String studyGuide) {
        this.studyGuide = studyGuide;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public void setDescription(String description) {
        this.description = description;
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
                "Categoria a qual faz parte: " + "\n" + category + "\n";
    }
}
