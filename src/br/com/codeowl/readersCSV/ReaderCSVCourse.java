package br.com.codeowl.readersCSV;

import br.com.codeowl.models.Category;
import br.com.codeowl.models.Course;
import br.com.codeowl.models.Subcategory;
import br.com.codeowl.validations.CSVValidations;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReaderCSVCourse {
    String line = "";
    String splitBy = ",";
    String pathName;

    Map<String, Course> courses = new HashMap<>();

    public void readCourseFile(String pathName, Map<String, Subcategory> subcategories) {
        try {

            String modifiedFileName = "arquivo_modificado.csv";
            addCommaToEnd(pathName, modifiedFileName);

            File file = new File(modifiedFileName);
            BufferedReader fileCSVCourse = new BufferedReader( new FileReader(file.getAbsolutePath()));
            fileCSVCourse.readLine();
            while ((line = fileCSVCourse.readLine()) != null) {
                String[] value = line.split(splitBy);

                String name = CSVValidations.validateStringNullField(value[0], "nome");
                String code = CSVValidations.validateStringNullField(value[1], "código");
                int estimatedTime = CSVValidations.validateIntField(value[2], "duração");
                boolean availability = value[3].equals("PÚBLICA");
                String targetPublic = CSVValidations.validateStringNullField(value[4], "público alvo");
                String instructorName = CSVValidations.validateStringNullField(value[5], "instrutor(a)");
                String courseOutline = CSVValidations.validateStringNullField(value[6], "ementa");
                String skills = CSVValidations.validateStringNullField(value[7], "habilidades");
                String subcategoryCode = CSVValidations.validateStringNullField(value[8], "subcategoria");

                Subcategory subcategory = subcategories.get(subcategoryCode);

                if (subcategory == null) {
                    System.out.println("Subcategoria não existe.");

                    // Solucao 1: Escolher uma subcategoria existente via terminal

//                    System.out.println("Subcategoria não existe. Segue as subcategorias criadas: ");
//                    for (Subcategory availableSubcategories : subcategories.values()) {
//                        System.out.println(availableSubcategories);
//                    }
//                    Scanner scanner = new Scanner(System.in);
//                    System.out.println("Escolha uma subcategoria pelo código: ");
//                    String subcategoryChoice = scanner.nextLine();
//
//                    Subcategory subcategoryChosen = subcategories.get(subcategoryChoice);
//                    if (subcategoryChosen == null) {
//                        throw new IllegalArgumentException("Escolha uma subcategoria válida ou crie uma");
//                    }
//
//                    subcategory = subcategoryChosen;


                    // Solucao 2: Criar uma subcategoria via terminal

                    ReaderCSVCategory readerCSVCategory = new ReaderCSVCategory();
                    readerCSVCategory.readCategoryFile("files/planilha-dados-escola-Categoria.csv");
                    Map<String, Category> categories = readerCSVCategory.getCategories();

                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Digite o nome da nova subcategoria: ");
                    String newName = scanner.nextLine();

                    System.out.println("Digite o código da nova subcategoria: ");
                    String newCode = scanner.nextLine().trim();
                    System.out.println("Código da nova subcategoria após o trim: [" + newCode + "]");

                    System.out.println("Digite a categoria da nova subcategoria: ");
                    String newCategoryCode = scanner.nextLine().trim();
                    System.out.println("Código da nova categoria após o trim: [" + newCategoryCode + "]");

                    Category category = categories.get(newCategoryCode);
                    System.out.println("Categoria encontrada: " + category);

                    Subcategory subcategoryChosen = new Subcategory(newName, newCode, category);
                    subcategories.put(newCode, subcategoryChosen);

                    subcategory = subcategoryChosen;

                    // Solucao 3: Criar um caso a parte de subcategoria desativada para receber esses cursos

//                    Category category = new Category("Desativada", "desativada", false);
//                    subcategory = new Subcategory("Desativada", "desativada", category);
                }

                Course course = new Course(name, code, estimatedTime, availability, targetPublic, instructorName, courseOutline, skills, subcategory);
                courses.put(code, course);

            }
        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }

    public Map<String, Course> getCourses() {
        return courses;
    }

    private static void addCommaToEnd(String inputFilePath, String outputFilePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                // Adiciona uma vírgula ao final de cada linha
                bw.write(line + ",");
                bw.newLine();
            }
        }
    }
}
