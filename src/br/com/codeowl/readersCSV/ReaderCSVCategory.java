package br.com.codeowl.readersCSV;

import br.com.codeowl.models.Category;
import br.com.codeowl.validations.CSVValidations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReaderCSVCategory {

    String line = "";
    String splitBy = ",";
    String pathName;

    Map<String, Category> categories = new HashMap<>();

    public void readCategoryFile(String pathName) {
        try {
            File file = new File(pathName);
            BufferedReader fileCSV = new BufferedReader( new FileReader(file.getAbsolutePath()));
            fileCSV.readLine();
            while ((line = fileCSV.readLine()) != null) {
                String[] value = line.split(splitBy);

                String name = CSVValidations.validateStringNullField(value[0]);
                String code = CSVValidations.validateStringNullField(value[1]);
                int sequence = CSVValidations.validateIntField(value[2]);
                String description = CSVValidations.validateStringNullField(value[3]);
                boolean avaiable = value[4].equals("ATIVA");
                String iconImage = CSVValidations.validateStringNullField(value[5]);
                String codeColor = CSVValidations.validateStringNullField(value[6]);

                Category category = new Category(name, code, description, avaiable, sequence, iconImage, codeColor);
                categories.put(code, category);
            }
        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }

    public Map<String, Category> getCategories() {
        return categories;
    }
}
