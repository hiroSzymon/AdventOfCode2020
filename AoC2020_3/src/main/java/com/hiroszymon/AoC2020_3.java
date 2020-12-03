package com.hiroszymon;

import com.hiroszymon.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class AoC2020_3 {
    public static void main(String[] args) throws IOException {
        List<String> fileContent = Utils.readInput();

        //Part 1
        int xPos = 0;
        int trees = 0;
        for (String s : fileContent) {
            if (s.charAt(xPos) == '#')
                trees++;
            xPos += 3;
            xPos %= s.length();
        }
        System.out.println(trees);

        //Part 2
        int[] xPoss = {1, 3, 5, 7, 1};
        int[] yPoss = {1, 1, 1, 1, 2};
        List<Integer> treesForPass = new ArrayList<>();

        for(int i=0; i<xPoss.length; i++){
            xPos=0;
            int treesForThisPass = 0;
            for (int j=0; j< fileContent.size(); j+=yPoss[i]) {
                if (fileContent.get(j).charAt(xPos) == '#')
                    treesForThisPass++;
                xPos += xPoss[i];
                xPos %= fileContent.get(j).length();
            }
            treesForPass.add(treesForThisPass);
        }

        System.out.println(treesForPass);
        System.out.println(treesForPass.stream().reduce((integer, integer2) -> integer * integer2));
    }
}
