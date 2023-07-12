package br.com.codeowl.models;

public abstract class Activity {

    private String title;
    private String code;
    private int sequence;
    private boolean available = false;
    private Section section;

    public Activity(String title, String code, Section section) {
        if (title==null || title.isEmpty()) {
            throw new IllegalArgumentException("O título é obrigatório.");
        }
        if (code==null || code.isEmpty() || !code.matches("^[a-z0-9-]+$")) {
            throw new IllegalArgumentException("O código é obrigatório e deve ser composto apenas por letras minúsculas ou números, separados por hífen.");
        }
        this.title = title;
        this.code = code;
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public int getSequence() {
        return sequence;
    }

    public boolean isAvailable() {
        return available;
    }

    public Section getSection() {
        return section;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
