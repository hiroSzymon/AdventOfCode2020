package com.hiroszymon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AoC2020_5 {
    public static void main(String[] args) throws IOException {
        List<String> values = Utils.readInput();
        List<Integer> ids = new ArrayList<>();

        for (String v : values) {
            List<Integer> rows = new ArrayList<>();
            for (int i = 0; i < 128; i++) {
                rows.add(i);
            }

            List<Integer> cols = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                cols.add(i);
            }

            for (char c : v.toCharArray()) {
                switch (c) {
                    case 'F' -> rows = rows.subList(0, rows.size() / 2);
                    case 'B' -> rows = rows.subList(rows.size() / 2, rows.size());
                    case 'L' -> cols = cols.subList(0, cols.size() / 2);
                    case 'R' -> cols = cols.subList(cols.size() / 2, cols.size());
                }
            }
            ids.add(rows.get(0)*8+cols.get(0));
        }
        ids.sort(Comparator.comparingInt(e->e));
        //Part 1
        System.out.println(ids);

        //Part 2
        for(int i=ids.get(0); i<ids.get(ids.size()-1); i++){
            if(!ids.contains(i))
                System.out.println(i+" "+ids.contains(i-1)+" "+ids.contains(i+1));
        }
    }
}
