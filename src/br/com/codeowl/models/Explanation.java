package br.com.codeowl.models;

public class Explanation extends Activity {
    private String text;

    public Explanation(String title, String code, Section section, String text) {
        super(title, code, section);
        if (text==null || text.isEmpty()) {
            throw new IllegalArgumentException("O texto da explicação é obrigatório.");
        }
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "*** Atividade " + super.getSequence() + " ***" + "\n" +
                "Título: " + super.getTitle() + "\n" +
                "Código " + super.getCode() + "\n" +
                "** Tipo: explicação **" + "\n" +
                "Texto: " + text + "\n";
    }
}
