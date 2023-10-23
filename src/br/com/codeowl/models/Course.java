package br.com.codeowl.models;

import br.com.codeowl.validations.CommonValidations;

public class Course {
    private String name;
    private String code;
    private int estimatedTime;
    private boolean availability;
    private String targetAudience;
    private String instructorName;
    private String courseOutline;
    private String developedSkills;
    private Subcategory subcategory;

    public Course(String name, String code, int estimatedTime, String instructorName, Subcategory subcategory) {
        CommonValidations.validateName(name);
        CommonValidations.validateCode(code);

        if (estimatedTime<1 || estimatedTime>20) {
            throw new IllegalArgumentException("O tempo para finalização do curso (em horas) deve ser entre 1 e 20 horas.");
        }
        if (instructorName ==null || instructorName.isBlank()) {
            throw new IllegalArgumentException("O nome da pessoa instrutora é obrigatório.");
        }

        this.name = name;
        this.code = code;
        this.estimatedTime = estimatedTime;
        this.instructorName = instructorName;
        this.subcategory = subcategory;
    }

    public Course(String name, String code, int estimatedTime, boolean availability, String targetAudience, String instructorName, String courseOutline, String developedSkills, Subcategory subcategory) {
        CommonValidations.validateName(name);
        CommonValidations.validateCode(code);

        if (estimatedTime<1 || estimatedTime>20) {
            throw new IllegalArgumentException("O tempo para finalização do curso (em horas) deve ser entre 1 e 20 horas.");
        }
        if (instructorName ==null || instructorName.isBlank()) {
            throw new IllegalArgumentException("O nome da pessoa instrutora é obrigatório.");
        }
        this.name = name;
        this.code = code;
        this.estimatedTime = estimatedTime;
        this.availability = availability;
        this.targetAudience = targetAudience;
        this.instructorName = instructorName;
        this.courseOutline = courseOutline;
        this.developedSkills = developedSkills;
        this.subcategory = subcategory;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    @Override
    public String toString() {
        return "*** Curso ***" + "\n" +
                "Nome: " + name + "\n" +
                "Code: " + code + "\n" +
                "Duração: " + estimatedTime + " horas\n" +
                "Instrutor(a): " + instructorName + "\n" +
                "Disponível: " + availability + "\n" +
                "Público Alvo: " + targetAudience + "\n" +
                "Ementa: " + courseOutline + "\n" +
                "Habilidades desenvolvidas: " + developedSkills + "\n" +
                "Subcategoria: " + "\n" + subcategory.getCode() + "\n\n";
    }
}
