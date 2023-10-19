package br.com.codeowl.tests;

import br.com.codeowl.models.Category;
import br.com.codeowl.models.Course;
import br.com.codeowl.models.Subcategory;

import java.util.List;

public class MainTestsLists {
    public static void main(String[] args) {

        Category devOps = new Category("DevOps", "devops", "União de Dev com Ops",
                "1)Linux, 2)Redes, 3)Containers e Virtualização, 4)CI e CD, 5)Cloud, 6)Infra como código, 7)Segurança e 8)Não para de estudar nunca.",
                true, 1, "/tmp/uploads/imagem-engrenagem", "#ff5733");

        Subcategory seguranca = new Subcategory("Segurança", "seguranca-informacao", devOps, "Segurança da Informação",
                "1)Lógica de programação, 2)Linux, 3)Redes, 4)Blue Team, 5)Red Team, 6)AppSec e 7)Não para de estudar nunca.",
                true, 1);

        Category programacao = new Category("Programação", "programacao", "Aprenda linguagens para desenvolvimento web",
                "1)Lógica de programação, 2)Orientação a Objetos, 3)Frameworks, 4)Banco de dados, 5)Testes, 6)APIs, 7)CRUD e 8)Não para de estudar nunca.",
                true, 1, "/tmp/uploads/imagem-terminal", "#80ff33");

        Subcategory linguagemProgramacao = new Subcategory("Linguagens de Programação", "linguagem-programacao", programacao,
                "Back-end","1)Hello World, 2)Algoritmos, 3)Condicionais, 4)Loops, 5)Funções, 6)Vetores, 7)Matrizes e 8)Não para de estudar nunca.",
                true, 1);

        Course segurancaDeRedes = new Course("WAF, SIEM e firewall", "waf-siem-firewall", 20, "Mila", seguranca);
        Course javaOO = new Course("Java e Orientação a Objetos", "java-oo", 20, "Jacque", linguagemProgramacao);
        Course introducaoKotlin = new Course("Introdução ao Kotlin", "introducao-kotlin", 15, "Jeni", linguagemProgramacao);

        List<Course> listCourses = List.of(segurancaDeRedes, javaOO, introducaoKotlin);

        listCourses.forEach(System.out::println);
    }
}
