package br.com.codeowl.models;

import br.com.codeowl.validations.CommonValidations;

public class Explanation extends Activity {
    private String text;

    public Explanation(String title, String code, Section section, String text) {
        super(title, code, section);
        CommonValidations.validateText(text);
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
