package com.tech.challenge.pizza.app.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileServiceTest {

    @Test
    public void testReadFile() throws IOException {
        FileService fileService = new FileService();
        String expectedData = new String(Files.readAllBytes(Paths.get(new ClassPathResource("stock.json").getURI())));

        String actualData = fileService.readFile();

        Assertions.assertEquals(expectedData, actualData);
    }
}