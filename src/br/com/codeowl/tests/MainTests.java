package br.com.codeowl.tests;

import br.com.codeowl.models.*;

public class MainTests {
    public static void main(String[] args) {

        Category devOps = new Category("DevOps", "devops", "União de Dev com Ops",
                "1)Linux, 2)Redes, 3)Containers e Virtualização, 4)CI e CD, 5)Cloud, 6)Infra como código, 7)Segurança e 8)Não para de estudar nunca.",
                true, 1, "/tmp/uploads/imagem-engrenagem", "#ff5733");

        Subcategory seguranca = new Subcategory("Segurança", "seguranca-informacao", devOps, "Segurança da Informação",
                "1)Lógica de programação, 2)Linux, 3)Redes, 4)Blue Team, 5)Red Team, 6)AppSec e 7)Não para de estudar nunca.",
                true, 1);

        Course segurancaDeRedes = new Course("WAF, SIEM e firewall", "waf-siem-firewall",
                20, true, "Pessoas interessadas a desenvolver habilidade de segurança defensiva ou blue team",
                "Mila",
                """
                1) O que é Blue Team;
                2) Aplicação do pfSense;
                3) Criação de regras no firewall;
                4) Funcionalidade do WAF;
                5) Proxy reverso para proteger a aplicação;""",
                "Habilidades técnicas de Blue Team", seguranca );


        Section introducaoBlueTeam = new Section("O que é Blue Team", "o-que-e-blue-team",
                segurancaDeRedes, 1, true, false);

        Question exercicioConceitoBlueTeam = new Question("Conceito do Blue Team", "conceito-blue-team", introducaoBlueTeam, "Qual o conceito de Blue Team?", QuestionType.SINGLE_CHOICE);

        Alternative letraA = new Alternative("Blue Team é o time de segurança ofensiva", 1, false, "Errada, porque o time é focado em proteger as aplicações", exercicioConceitoBlueTeam);
        Alternative letraB = new Alternative("Blue Team é o time de segurança defensiva", 2, true, "Correta, porque o time é focado em proteger as aplicações", exercicioConceitoBlueTeam);
        Alternative letraC = new Alternative("Blue Team é o time que realiza testes de qualidade de software", 3, false, "Errada, porque o time é focado em segurança de aplicações", exercicioConceitoBlueTeam);

        exercicioConceitoBlueTeam.addAlternative(letraA);
        exercicioConceitoBlueTeam.addAlternative(letraB);
        exercicioConceitoBlueTeam.addAlternative(letraC);

        System.out.println(segurancaDeRedes);
        System.out.println(introducaoBlueTeam);
        System.out.println(exercicioConceitoBlueTeam);

    }
}
