package pl.hiroszymon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class AoC2020_1 {
    public static void main(String[] args) throws IOException {
        List<Integer> asInts = Files.readAllLines(Path.of("input.txt")).stream().map(Integer::parseInt).collect(Collectors.toList());
        for(Integer i : asInts){
            for(Integer j : asInts){
                for(Integer k : asInts){
                    if(i+j+k!=2020)
                        continue;
                    System.out.println(i*j*k);
                }

            }
        }
    }

}
