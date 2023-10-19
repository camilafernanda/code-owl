package br.com.codeowl.tests;

import br.com.codeowl.models.Category;
import br.com.codeowl.models.Course;
import br.com.codeowl.models.Subcategory;
import br.com.codeowl.readersCSV.HTMLGenerator;
import br.com.codeowl.readersCSV.ReaderCSVCategory;
import br.com.codeowl.readersCSV.ReaderCSVCourse;
import br.com.codeowl.readersCSV.ReaderCSVSubcategory;

import java.util.Map;

import static br.com.codeowl.readersCSV.HTMLGenerator.generateHTML;

public class TestsReadersCSV {
    public static void main(String[] args) {
        ReaderCSVCategory readerCSVCategory = new ReaderCSVCategory();
        readerCSVCategory.readCategoryFile("files/planilha-dados-escola-Categoria.csv");

        Map<String, Category> categories = readerCSVCategory.getCategories();
        System.out.println(categories);

        ReaderCSVSubcategory readerCSVSubcategory = new ReaderCSVSubcategory();
        readerCSVSubcategory.readSubcategoryFile("files/planilha-dados-escola-Subcategoria.csv", categories);

        Map<String, Subcategory> subcategories = readerCSVSubcategory.getSubcategories();
        System.out.println(subcategories);

        ReaderCSVCourse readerCSVCourse = new ReaderCSVCourse();
        readerCSVCourse.readCourseFile("files/planilha-dados-escola-Curso.csv", subcategories);

        Map<String, Course> courses = readerCSVCourse.getCourses();
        System.out.println(courses);

        HTMLGenerator.generateHTML(categories, subcategories);
    }
}
