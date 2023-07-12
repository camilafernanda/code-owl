package br.com.codeowl.models;

public class Course {
    private String name;
    private String code;
    private int duration;
    private boolean availability = false;
    private String targetAudience;
    private String teacher;
    private String courseOutline;
    private String developedSkills;
    private Subcategory subcategory;

    public Course(String name, String code, int duration, String teacher, Subcategory subcategory) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException("O nome do curso é obrigatório.");
        }
        if (code==null || code.isEmpty() || !code.matches("^[a-z0-9-]+$")) {
            throw new IllegalArgumentException("O código do curso é obrigatório e deve ser composto apenas por letras minúsculas ou números, separados por hífen.");
        }
        if (duration<1 || duration>20) {
            throw new IllegalArgumentException("O tempo para finalização do curso (em horas) deve ser entre 1 e 20 horas.");
        }
        if (teacher==null || teacher.isEmpty()) {
            throw new IllegalArgumentException("O nome da pessoa instrutora é obrigatório.");
        }
        this.name = name;
        this.code = code;
        this.duration = duration;
        this.teacher = teacher;
        this.subcategory = subcategory;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public void setCourseOutline(String courseOutline) {
        this.courseOutline = courseOutline;
    }

    public void setDevelopedSkills(String developedSkills) {
        this.developedSkills = developedSkills;
    }

    @Override
    public String toString() {
        return "*** Curso ***" + "\n" +
                "Nome: " + name + "\n" +
                "Code: " + code + "\n" +
                "Duração: " + duration + " horas\n" +
                "Instrutor(a): " + teacher + "\n" +
                "Disponível: " + availability + "\n" +
                "Público Alvo: " + targetAudience + "\n" +
                "Ementa: " + courseOutline + "\n" +
                "Habilidades desenvolvidas: " + developedSkills + "\n" +
                "Subcategoria: " + "\n" + subcategory + "\n";
    }
}
