package br.com.codeowl.tests;

import br.com.codeowl.models.*;

public class MainTests {
    public static void main(String[] args) {

        Category devOps = new Category("DevOps", "devops");
        devOps.setDescription("União de Dev com Ops");
        devOps.setStudyGuide("1)Linux, 2)Redes, 3)Containers e Virtualização, 4)CI e CD, 5)Cloud, 6)Infra como código, 7)Segurança e 8)Não para de estudar nunca.");
        devOps.setAvailable(true);
        devOps.setSequence(1);
        devOps.setIconImage("/tmp/uploads/imagem-engrenagem");
        devOps.setColorCode("#ff5733");

        Subcategory seguranca = new Subcategory("Segurança", "seguranca-informacao", devOps);
        seguranca.setStudyGuide("1)Lógica de programação, 2)Linux, 3)Redes, 4)Blue Team, 5)Red Team, 6)AppSec e 7)Não para de estudar nunca.");
        seguranca.setAvailable(true);
        seguranca.setSequence(1);

        Course segurancaDeRedes = new Course("WAF, SIEM e firewall", "waf-siem-firewall", 20, "Mila", seguranca);
        segurancaDeRedes.setAvailability(true);
        segurancaDeRedes.setTargetAudience("Pessoas interessadas a desenvolver habilidade de segurança defensiva ou blue team");
        segurancaDeRedes.setCourseOutline("""
                1) O que é Blue Team;
                2) Aplicação do pfSense;
                3) Criação de regras no firewall;
                4) Funcionalidade do WAF;
                5) Proxy reverso para proteger a aplicação;""");
        segurancaDeRedes.setDevelopedSkills("Habilidades técnicas de Blue Team");

        Section introducaoBlueTeam = new Section("O que é Blue Team", "o-que-e-blue-team", segurancaDeRedes);
        introducaoBlueTeam.setSequence(1);
        introducaoBlueTeam.setAvailable(true);
        introducaoBlueTeam.setTest(false);

        Question exercicioConceitoBlueTeam = new Question("Conceito do Blue Team", "conceito-blue-team", introducaoBlueTeam, "Qual o conceito de Blue Team?", QuestionType.SINGLE_CHOICE);
        exercicioConceitoBlueTeam.setSequence(1);

        Alternative letraA = new Alternative("Blue Team é o time de segurança ofensiva", false, exercicioConceitoBlueTeam);
        letraA.setSequence(1);
        letraA.setJustification("Errada, porque o time é focado em proteger as aplicações");
        Alternative letraB = new Alternative("Blue Team é o time de segurança defensiva", true, exercicioConceitoBlueTeam);
        letraB.setSequence(2);
        letraB.setJustification("Correta, porque o time é focado em proteger as aplicações");
        Alternative letraC = new Alternative("Blue Team é o time que realiza testes de qualidade de software", false, exercicioConceitoBlueTeam);
        letraC.setSequence(3);
        letraC.setJustification("Errada, porque o time é focado em segurança de aplicações");

        exercicioConceitoBlueTeam.addAlternative(letraA);
        exercicioConceitoBlueTeam.addAlternative(letraB);
        exercicioConceitoBlueTeam.addAlternative(letraC);

        System.out.println(segurancaDeRedes);
        System.out.println(introducaoBlueTeam);
        System.out.println(exercicioConceitoBlueTeam);

    }
}
