package ru.penkin.java.basic.homework20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CounterApp {   // vetka_1_dz20

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        System.out.print("Введите искомую последовательность символов: ");
        String targetSequence = scanner.nextLine();

        try {
            int count = countOccurrences(fileName, targetSequence);
            System.out.println("Количество вхождений: " + count);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private static int countOccurrences(String fileName, String targetSequence) throws IOException {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(targetSequence)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}