package br.com.codeowl.models;

public class Section {

    private String name;
    private String code;
    private int sequence;
    private boolean available = false;
    private boolean test = false;
    private Course course;

    public Section(String name, String code, Course course) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }
        if (code==null || code.isEmpty() || !code.matches("^[a-z0-9-]+$")) {
            throw new IllegalArgumentException("O código é obrigatório e deve ser composto apenas por letras minúsculas ou números, separados por hífen.");
        }
        this.name = name;
        this.code = code;
        this.course = course;
    }

    public boolean isTest() {
        return test;
    }

    public Course getCourse() {
        return course;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setTest(boolean test) {
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
