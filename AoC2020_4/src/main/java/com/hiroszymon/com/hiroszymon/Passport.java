package com.hiroszymon.com.hiroszymon;

import java.lang.reflect.Field;
import java.util.HashMap;

public class Passport {
    Integer byr = null;
    Integer iyr = null;
    Integer eyr = null;
    Integer hgt = null;
    String hcl = null;
    String ecl = null;
    String pid = null;
    String cid = null;

    public static Passport fromString(String input) throws NoSuchFieldException, IllegalAccessException {
        String[] values = input.split(" ");
        HashMap<String, String> nameToValue = new HashMap<>();
        for (String s : values) {
            String[] mapEntry = s.split(":");
            double mul=2.54;
            if(mapEntry[0].equals("hgt")){
                if(!(mapEntry[1].contains("cm") || mapEntry[1].contains("in"))){
                    mul=254000;
                    mapEntry[1] = String.valueOf(Math.round(Integer.parseInt(mapEntry[1].replace("in", "")) * mul));
                }
                if (mapEntry[1].contains("in")) {
                    mapEntry[1] = String.valueOf(Math.round(Integer.parseInt(mapEntry[1].replace("in", "")) * mul));
                }
            }


            nameToValue.put(mapEntry[0], mapEntry[1].replace("cm", ""));
        }
        Passport p = new Passport();
        for (Field f : p.getClass().getDeclaredFields()) {
            if (nameToValue.containsKey(f.getName())) {
                Class<?> fieldClass = p.getClass().getDeclaredField(f.getName()).getType();
                switch (fieldClass.getSimpleName()) {
                    case "Integer" -> p.getClass().getDeclaredField(f.getName()).set(p, Integer.parseInt(nameToValue.get(f.getName())));
                    case "Long" -> p.getClass().getDeclaredField(f.getName()).set(p, Long.parseLong(nameToValue.get(f.getName())));
                    default -> p.getClass().getDeclaredField(f.getName()).set(p, nameToValue.get(f.getName()));
                }

            }
        }
        return p;
    }

    public boolean isFilled() {
        boolean isValid = true;
        try {
            for (Field f : this.getClass().getDeclaredFields()) {
                if (f.get(this) == null && !f.getName().equals("cid")) {
                    isValid = false;
                    break;
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
        return isValid;
    }

    public boolean isValid() {
        if (byr < 1920 || byr > 2002)
            return false;
        if(iyr < 2010 || iyr > 2020)
            return false;
        if(eyr < 2020 || eyr > 2030)
            return false;
        if(hgt<150 || hgt>193)
            return false;
        if(!hcl.matches("#[0-9a-f]{6}"))
            return false;
        if(!ecl.matches("(amb)|(blu)|(brn)|(gry)|(grn)|(hzl)|(oth)"))
            return false;
        if(!pid.matches("\\d{9}"))
            return false;

        return true;
    }

    private Passport() {
    }

}
