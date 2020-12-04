package com.hiroszymon;

import com.hiroszymon.com.hiroszymon.Passport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AoC2020_4 {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        List<Passport> passports =  new ArrayList<>();
        List<String> values = Utils.readInputEmptyLineSeparator();
        for(String s : values){
            passports.add(Passport.fromString(s));
        }
        //Part 1
        System.out.println(passports.stream().filter(Passport::isFilled).count());

        //Part 2
        System.out.println(passports.stream().filter(Passport::isFilled).filter(Passport::isValid).count());

    }
}
