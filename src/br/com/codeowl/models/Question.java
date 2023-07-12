package br.com.codeowl.models;

import java.util.LinkedList;
import java.util.List;

import static br.com.codeowl.models.QuestionType.SINGLE_CHOICE;

public class Question extends Activity {
    private String statement;
    private QuestionType questionType = SINGLE_CHOICE;
    private List<Alternative> alternatives;

    public Question(String title, String code, Section section, String statement, QuestionType questionType) {
        super(title, code, section);
        if (statement==null || statement.isEmpty()) {
            throw new IllegalArgumentException("O enunciado da questão é obrigatório.");
        }
        if (questionType==null) {
            throw new IllegalArgumentException("O tipo de questão é obrigatório.");
        }
        this.statement = statement;
        this.questionType = questionType;
        this.alternatives = new LinkedList<>();
    }

    public void addAlternative(Alternative alternative) {
        alternatives.add(alternative);
    }

    @Override
    public String toString() {
        String result = "";
        for (Alternative alternative : alternatives) {
            result += alternative.toString();
        }

        return "*** Atividade " + super.getSequence() + " ***" + "\n" +
                "Título: " + super.getTitle() + "\n" +
                "Código " + super.getCode() + "\n" +
                "** Tipo: Questão **" + "\n" +
                "Enunciado: " + statement + "\n" +
                "Tipo: " + questionType + "\n" +
                "Alternativas:\n" + result;
    }
}
