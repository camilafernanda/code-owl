package br.com.codeowl.models;

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

    public void setDescription(String description) {
        this.description = description;
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

    public void setIconImage(String iconImage) {
        this.iconImage = iconImage;
    }

    public void setColorCode(String colorCode) {
        if (!colorCode.matches("^#[0-9A-Fa-f]{6}$")){
            throw new IllegalArgumentException("O código da cor deve ser um valor hexadecimal válido.");
        }
        this.colorCode = colorCode;
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
                "Imagem de ícone: " + iconImage + "\n" +
                "Cor em HTML: " + colorCode + "\n";
    }
}
