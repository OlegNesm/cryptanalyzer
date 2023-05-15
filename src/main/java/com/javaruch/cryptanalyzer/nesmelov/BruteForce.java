package com.javaruch.cryptanalyzer.nesmelov;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce {
    public String str;
    public String strOut;

  BruteForce(String str, String strOut) throws IOException {
        this.str = str;
        this.strOut = strOut;

        int content;
        int indexPass;
        char ch;
        char chPass;

        String model = CryptoAlphabet.ALPHABET;
        String mod = model + model;


        int temp = 0;
        int key = 0;
        for (int offset = 0; offset < 86; offset++) {
            String result = "";
            FileReader reader = new FileReader(str);
//            Writer writer = new FileWriter(strOut, true);
            int count = 0;
            while ((content = reader.read()) != -1) {
                ch = (char) content;
                int index = mod.lastIndexOf(ch);
                if (index != -1) {
                    indexPass = index - offset;
                    chPass = mod.charAt(indexPass);
                } else {
                    chPass = ch;
                }
                result = result.concat(String.valueOf(chPass));}
                Pattern pattern = Pattern.compile(", |\\. | ");
                Matcher matcher = pattern.matcher(result);
                count = 0;
                while (matcher.find())
                    count++;


            if (temp < count) {
                temp = count;
                key = offset;
            }
//            writer.write("\n" + "Ключ :" + offset + "  совпадений :" + count + "\n" + result + "\n");
            reader.close();
//            writer.close();
        }
        System.out.println("Ключ расшифровки :" + key);
        String result = "";
        FileReader reader = new FileReader(str);
        Writer writer = new FileWriter(strOut);
        while ((content = reader.read()) != -1) {
            ch = (char) content;
            int index = mod.lastIndexOf(ch);
            if (index != -1) {
                indexPass = index - key;
                chPass = mod.charAt(indexPass);
            } else {
                chPass = ch;
            }
            result = result.concat(String.valueOf(chPass));

        }
        System.out.println(result);
        writer.write("\n" + "Ключ :" + key +  "\n" + result + "\n");
        reader.close();
        writer.close();

    }
}