package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class FileUtils {

    private static final ObjectMapper mapper = new ObjectMapper()
        .enable(SerializationFeature.INDENT_OUTPUT);

    public static List<Student> readStudents(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) return List.of(); // empty list if file missing
        try (FileInputStream fis = new FileInputStream(file)) {
            return mapper.readValue(fis, new TypeReference<List<Student>>() {});
        }
    }

    public static void writeStudents(String path, List<Student> students) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            mapper.writeValue(fos, students);
        }
    }

    public static void logOperation(String message) {
        String logDir = "data/logs/";
        new File(logDir).mkdirs(); // ensure folder exists
        String logFile = logDir + "operations.log";
        try (BufferedWriter writer = Files.newBufferedWriter(
                Paths.get(logFile),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        )) {
            writer.write(java.time.LocalDateTime.now() + " - " + message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        }
    }
}
