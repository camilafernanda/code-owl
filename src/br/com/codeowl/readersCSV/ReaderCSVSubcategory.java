package br.com.codeowl.readersCSV;

import br.com.codeowl.models.Category;
import br.com.codeowl.models.Subcategory;
import br.com.codeowl.validations.CSVValidations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReaderCSVSubcategory {

    String line = "";
    String splitBy = ",";
    String pathName;

    Map<String, Subcategory> subcategories = new HashMap<>();

    public void readSubcategoryFile(String pathName, Map<String, Category> categories) {
        try {
            File file = new File(pathName);
            BufferedReader fileCSVSubcategory = new BufferedReader( new FileReader(file.getAbsolutePath()));
            fileCSVSubcategory.readLine();
            while ((line = fileCSVSubcategory.readLine()) != null) {
                String[] value = line.split(splitBy);

                String name = CSVValidations.validateStringNullField(value[0], "nome");
                String code = CSVValidations.validateStringNullField(value[1], "código");
                int sequence = CSVValidations.validateIntField(value[2], "ordem");
                String description = CSVValidations.validateStringNullField(value[3], "descrição");
                boolean avaiable = value[4].equals("ATIVA");
                String categoryCode = CSVValidations.validateStringNullField(value[5], "categoria");

                Category category = categories.get(categoryCode);

                if (category == null) {
                    category = new Category(categoryCode, categoryCode);
                    categories.put(categoryCode, category);
                }

                Subcategory subcategory = new Subcategory(name, code, category, description, avaiable, sequence);
                subcategories.put(code, subcategory);

            }
        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }

    public Map<String, Subcategory> getSubcategories() {
        return subcategories;
    }
}
