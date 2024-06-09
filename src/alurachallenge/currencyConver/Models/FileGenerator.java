package alurachallenge.currencyConver.Models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileGenerator {
    public void saveJson(List history) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter writter = new FileWriter("C:\\Users\\Usuario\\Desktop\\JAVA-POO\\currencyConver\\src\\alurachallenge\\currencyConver\\files\\history.json");

        writter.write(gson.toJson(history));
        writter.close();

    }
}
