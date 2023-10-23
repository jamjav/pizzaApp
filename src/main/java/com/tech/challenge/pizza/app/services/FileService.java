package com.tech.challenge.pizza.app.services;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Component
@AllArgsConstructor
public class FileService {

    public String readFile() {

        try {
            File myObj = new File("src/main/resources/stock.json");
            Scanner myReader = new Scanner(myObj);
            String data = "";
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean writeFile (String file) {
        boolean success = false;
        try {
            FileOutputStream fos = new FileOutputStream("src/main/resources/stock.json");
            fos.write(file.getBytes());
            fos.close();
            success = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return success;

    }
}
