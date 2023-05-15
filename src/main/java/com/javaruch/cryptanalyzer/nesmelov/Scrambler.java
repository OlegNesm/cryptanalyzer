package com.javaruch.cryptanalyzer.nesmelov;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Scrambler {
    public  String str;
    public String strout;
    public  int offset;
    Scrambler(String str, String stdout, int offset) throws IOException {
        this.str = str;
        this.strout = stdout;
        this.offset = offset;
        FileReader reader = new FileReader(str);
        PrintWriter pw = new PrintWriter(stdout);
        int content;
        int indexPass;
        char ch;
        char chPass;
        String result="";
        String model = CryptoAlphabet.ALPHABET;
        String mod = model + model;
        while ((content = reader.read()) != -1) {
            ch = (char) content;
            int index = mod.indexOf(ch);
            if (index != -1) {
                indexPass = index + offset;
                chPass = mod.charAt(indexPass);
            } else {
                chPass = ch;
            }
            result = result.concat(String.valueOf(chPass));
        }
        System.out.print(result);
        System.out.println();
        System.out.println("Ключ шифра "+offset);
        pw.print(result);
        reader.close();
        pw.close();


    }
}
