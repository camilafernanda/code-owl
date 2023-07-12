package br.com.codeowl.models;

public class Subcategory {

    private String name;
    private String code;
    private String description;
    private String studyGuide;
    private boolean available = false;
    private int sequence;
    private Category category;

    public Subcategory(String name, String code, Category category) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }
        if (code==null || code.isEmpty() || !code.matches("^[a-z0-9-]+$")) {
            throw new IllegalArgumentException("O código é obrigatório e deve ser composto apenas por letras minúsculas ou números, separados por hífen.");
        }
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
