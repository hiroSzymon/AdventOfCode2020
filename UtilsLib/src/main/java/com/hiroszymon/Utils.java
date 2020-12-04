package com.hiroszymon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;

public class Utils {
    public static List<String> readInput() throws IOException {
        return Files.readAllLines(Path.of("input.txt"));
    }

    public static List<String> readInputEmptyLineSeparator() throws IOException {
        Scanner scanner = new Scanner(Path.of("input.txt").toFile());
        scanner.useDelimiter("\n\n");
        List<String> values = new ArrayList<>();
        while(scanner.hasNext()){
           values.add(scanner.next().replace("\n", " "));
        }
        return values;
    }
}
