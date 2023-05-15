package com.javaruch.cryptanalyzer.nesmelov;

public class CryptoAlphabet {
    private static final String lettersUpperCase = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String lettersLowerCase = "абвгджеёзийклмнопрстуфхцчшщъыьэюя";
    private static final String numbers = "0123456789";
    private static final String symbols = ".,\"\":-!? ";
    public static final String ALPHABET = lettersUpperCase + lettersLowerCase + numbers + symbols;

}
