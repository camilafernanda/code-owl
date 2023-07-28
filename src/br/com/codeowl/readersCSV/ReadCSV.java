package br.com.codeowl.readersCSV;

import br.com.codeowl.models.Category;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        String line = "";
        String splitBy = ",";

        try {
            File file = new File("files/planilha-dados-escola-Categoria.csv");
            BufferedReader fileCSV = new BufferedReader( new FileReader(file.getAbsolutePath()));
            fileCSV.readLine();
            while ((line = fileCSV.readLine()) != null) {
                String[] value = line.split(splitBy);
                System.out.println("Nome: " + value[0] + " Código: " + value[1] + " Ordem: " + value[2] + " Descrição: " + value[3] + " Status: " + value[4] + " Ícone: " + value[5] + " Cor: " + value[6]);

                String name = value[0];
                String code = value[1];
                int sequence = Integer.parseInt(value[2]);
                String description = value[3];
                boolean avaiable = value[4].equals("ATIVA");
                String iconImage = value[5];
                String codeColor = value[6];

                Category category = new Category(name, code);
                category.setSequence(sequence);
                category.setDescription(description);
                category.setAvailable(avaiable);
                category.setIconImage(iconImage);
                category.setColorCode(codeColor);

                System.out.println(category);
            }
        } catch(IOException exception) {
            exception.printStackTrace();
        }

        try {
            File file = new File("files/planilha-dados-escola-Subcategoria.csv");
            BufferedReader fileCSVSubcategory = new BufferedReader( new FileReader(file.getAbsolutePath()));
            fileCSVSubcategory.readLine();
            while ((line = fileCSVSubcategory.readLine()) != null) {
                String[] value = line.split(splitBy);
                System.out.println("Nome: " + value[0] + " Código: " + value[1] + " Ordem: " + value[2] + " Descrição: " + value[3] + " Status: " + value[4] + " Categoria: " + value[5]);

                String name = value[0];
                String code = value[1];
                int sequence = Integer.parseInt(value[2]);
                String description = value[3];
                boolean avaiable = value[4].equals("ATIVA");
                String category = value[5];

//                Subcategory subcategory = new Subcategory(name, code, category);
//                subcategory.setSequence(sequence);
//                subcategory.setDescription(description);
//                subcategory.setAvailable(avaiable);
//
//                System.out.println(subcategory);
            }
        } catch(IOException exception) {
            exception.printStackTrace();
        }

        try {
            File file = new File("files/planilha-dados-escola-Curso.csv");
            BufferedReader fileCSVCourse = new BufferedReader( new FileReader(file.getAbsolutePath()));
            fileCSVCourse.readLine();
            while ((line = fileCSVCourse.readLine()) != null) {
                String[] value = line.split(splitBy);
                System.out.println("Nome: " + value[0] + " Código: " + value[1] + " Tempo de finalização (h): " + value[2] + " Visibilidade: " + value[3] + " Público alvo: " + value[4] + " Instrutor(a): " + value[5] + " Ementa: " + value[6] + " Habilidades: " + value[7] + " Subcategoria: " + value[8]);

                String name = value[0];
                String code = value[1];
                int duration = Integer.parseInt(value[2]);
                boolean avaiable = value[3].equals("PÚBLICA");
                String targetPublic = value[4];
                String teacher = value[5];
                String courseOutline = value[6];
                String skills = value[7];
                String subcategoryCourse = value[8];

//                Course course = new Course(name, code, duration, teacher, subcategoryCourse);
//                course.setAvailability(avaiable);
//                course.setTargetAudience(targetPublic);
//                course.setCourseOutline(courseOutline);
//                course.setDevelopedSkills(skills);
//
//                System.out.println(course);
            }
        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }
}
