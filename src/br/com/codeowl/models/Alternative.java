package br.com.codeowl.models;

public class Alternative {
    private String text;
    private int sequence;
    private boolean correct;
    private String justification;
    private Question question;

    public Alternative(String text, boolean correct, Question question) {
        if (text==null || text.isEmpty()) {
            throw new IllegalArgumentException("O texto da alternativa é obrigatório.");
        }
        if (question==null) {
            throw new IllegalArgumentException("A questão a qual a alternativa pertence é obrigatória.");
        }
        this.text = text;
        this.correct = correct;
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    @Override
    public String toString() {
        return "*** Alternativa " + sequence + " ***" + "\n" +
                "Texto: " + text + "\n" +
                "Correta? " + correct +
                ". Justificativa: " + justification + "\n";
    }
}
