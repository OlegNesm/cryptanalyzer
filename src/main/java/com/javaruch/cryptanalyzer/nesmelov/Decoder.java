package com.javaruch.cryptanalyzer.nesmelov;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Decoder {
    public String str;
    public String strout;
    public  int offset;
    Decoder (String str, String strout, int offset) throws IOException {
        this.str = str;
        this.strout = strout;
        this.offset = offset;
        System.out.println();
        String result = "";
        int content;
        int indexPass;
        String model = CryptoAlphabet.ALPHABET;
        String mod = model + model;

        char ch;
        char chPass;
        FileReader reader = new FileReader(str);
        PrintWriter pw = new PrintWriter(strout);
        while ((content = reader.read()) != -1) {
            ch = (char) content;
            int index = mod.lastIndexOf(ch);
            if (index != -1) {
                indexPass = index - offset;
                chPass = mod.charAt(indexPass);
            } else {
                chPass = ch;
            }
            result = result.concat(String.valueOf(chPass));
        }
        System.out.print(result);
        System.out.println();
        System.out.println("Ключ шифра " + offset);
        pw.print(result);
        reader.close();
        pw.close();

    }
}
