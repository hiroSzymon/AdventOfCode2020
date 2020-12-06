package com.hiroszymon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AoC2020_6 {
    public static void main(String[] args) throws IOException {
        List<String> input = Utils.readInputEmptyLineSeparator();
        //Part 1
        input.stream().map(e -> e.replace("\s", "").chars().distinct().count()).reduce(Long::sum).ifPresent(System.out::println);

        //Part 2
        List<Long> yesInAllLines = new ArrayList<>();
        for(String s : input){
            String[] splat = s.split("\s");
            long howManyCommon = 0;
            for(Character c: splat[0].toCharArray()){
                boolean inAll=true;
                for(int i=1; i<splat.length; i++){
                    inAll&=splat[i].contains(c.toString());
                }
                if(inAll)
                    howManyCommon++;
            }
            yesInAllLines.add(howManyCommon);

        }
        System.out.println(yesInAllLines);
        yesInAllLines.stream().reduce(Long::sum).ifPresent(System.out::println);
    }
}
