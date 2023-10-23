package br.com.codeowl.readersCSV;

import br.com.codeowl.models.Category;
import br.com.codeowl.models.Course;
import br.com.codeowl.models.Subcategory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class HTMLGenerator {
    public static void generateHTML(Map<String, Category> categories, Map<String, Subcategory> subcategories, Map<String, Course> courses) {
        try (PrintWriter write = new PrintWriter(new FileWriter("index.html"))) {
            int totalCourses = 0;
            int totalEstimatedTime = 0;

            write.println("<!DOCTYPE html>");
            write.println("<html lang=\"pt-br\">");
            write.println("<head>");
            write.println("<meta charset=\"UTF-8\">");
            write.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            write.println("<title>CodeOwl</title>");
            write.println("</head>");
            write.println("<body>");
            write.println("<h1> CodeOwl </h1>");
            write.println("<h2> Categorias </h2>");

            for (Category category : categories.values()) {
                String categoryValues = category.toString();
                String[] line = categoryValues.split("\n");

                write.println("<h3 style=\"background-color: " + line[8] + "; color: white;\">" + line[1] + "</h3>");
                write.println("<p>" + line[3] + "</p>");
                write.println("<img src=\"" + line[7] + "\" width=\"100\" height=\"100\">");

                write.println("<h3> Subcategorias </h3>");

                for (Subcategory subcategory : subcategories.values()) {
                    if (subcategory.getCategory().getCode().equals(category.getCode())) {
                        String subcategoryValues = subcategory.toString();
                        String[] lineSubcategory = subcategoryValues.split("\n");

                        write.println("<p style=\"font-weight: bold;\">" + lineSubcategory[1] + "</p>");
                        write.println("<p>" + lineSubcategory[3] + "</p>");
                    }
                }

                int categoryCourses = 0;
                int categoryEstimatedTime = 0;

                for (Course course : courses.values()) {
                    if (course.getSubcategory().getCategory().getCode().equals(category.getCode())) {
                        categoryCourses++;
                        categoryEstimatedTime += course.getEstimatedTime();
                    }
                }

                write.println("<p style=\"font-weight: bold;\">Número total de cursos nesta categoria: " + categoryCourses + "</p>");
                write.println("<p style=\"font-weight: bold;\">Soma do tempo estimado nesta categoria: " + categoryEstimatedTime + " horas</p>");

                totalCourses += categoryCourses;
                totalEstimatedTime += categoryEstimatedTime;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
