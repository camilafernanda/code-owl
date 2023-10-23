package br.com.codeowl.models;

import br.com.codeowl.validations.CommonValidations;

public class Alternative {
    private String text;
    private int sequence;
    private boolean correct;
    private String justification;
    private Question question;

    public Alternative(String text, boolean correct, Question question) {
        CommonValidations.validateText(text);
        if (question==null) {
            throw new IllegalArgumentException("A questão a qual a alternativa pertence é obrigatória.");
        }
        this.text = text;
        this.correct = correct;
        this.question = question;
    }

    public Alternative(String text, int sequence, boolean correct, String justification, Question question) {
        CommonValidations.validateText(text);
        if (question==null) {
            throw new IllegalArgumentException("A questão a qual a alternativa pertence é obrigatória.");
        }
        this.text = text;
        this.sequence = sequence;
        this.correct = correct;
        this.justification = justification;
        this.question = question;
    }

    @Override
    public String toString() {
        return "*** Alternativa " + sequence + " ***" + "\n" +
                "Texto: " + text + "\n" +
                "Correta? " + correct +
                ". Justificativa: " + justification + "\n";
    }
}
