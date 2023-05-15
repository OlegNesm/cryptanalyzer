package com.javaruch.cryptanalyzer.nesmelov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GuiStart {
    public static void main(String[] args) {
//        создаем простенькое окошко выбора действия программы
        JFrame frame = new JFrame("Программа шифровки  расшифровка текста");
        frame.setBounds(250, 150, 600, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        JLabel labelTitle = new JLabel(" Выберите вариант выполнения действия программой");
        labelTitle.setFont(new Font("Arial", Font.ITALIC, 20));
        panel.add(labelTitle);
        JButton button1 = new JButton("Шифрование");
        button1.setFont(new Font("Arial", Font.ITALIC, 18));
        panel.add(button1);
        button1.addActionListener(new CodeActionListener());

        JButton button2 = new JButton("Расшифровка");
        button2.setFont(new Font("Arial", Font.ITALIC, 18));
        panel.add(button2);
        button2.addActionListener(new DecodeActionListener());

        JButton button3 = new JButton("Brute Force");
        button3.setFont(new Font("Arial", Font.ITALIC, 18));
        panel.add(button3);
        button3.addActionListener(new BFActionListener());

        frame.add(panel);
        panel.revalidate();

        frame.setVisible(true);

    }
//    создадим свой класс обработки нажатия кнопки, а заодно и новое окошко сбора данных
    public static class CodeActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           JFrame frame1  = new JFrame("Шифруем");
            frame1.setBounds(200, 100, 600, 300);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel();
//            panel.setLayout();

            JLabel laval1 = new JLabel("1. Введите путь к файлу который нужно зашифровать");
            laval1.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval1);
            JLabel laval2 = new JLabel("либо оставте файл по умочанию");
            laval2.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval2);

            JTextField tf1 = new JTextField( "input.txt",15);
            panel.add(tf1);

            JLabel laval3 = new JLabel("2. Введите ключ  от 1 до 85 или оставьте число       ");
            laval3.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval3);
            JLabel laval4 = new JLabel(" сгенерированное случайное");
            laval4.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval4);

            int key = (int) (Math.random()*85);
            String keyy= ""+key;
            JTextField tf2 = new JTextField( keyy,10);
            panel.add(tf2);

            JLabel laval5 = new JLabel("3 Введите путь к файлу, куда запишется резкльтат   ");
            laval5.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval5);
            JLabel laval6 = new JLabel("выполнения программы, либо оставте путь по умолчанию");
            laval6.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval6);

            JTextField tf3 = new JTextField( "output.txt",20);
            panel.add(tf3);
            JButton button =new JButton("Enter");
            panel.add(button);
// ещё кнопка, ещё раз обработка, но уже с подключением к классу расшифровки
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String st1 = tf1.getText();
        String keyout = tf2.getText();
        int keyout1 =Integer.parseInt(keyout);
        String st3 = tf3.getText();

        try {
            Scrambler scrambler= new Scrambler(st1, st3, keyout1);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
});

            frame1.add(panel);
            frame1.setResizable(false);
            frame1.setVisible(true);
        }
    }
    public static class DecodeActionListener implements ActionListener {
//обработка кнопки расшифровать с созданием ещё одного диалогового окна ввода информации
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame1  = new JFrame("Расшифровываем");
            frame1.setBounds(200, 100, 600, 300);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel();

            JLabel laval1 = new JLabel("1. Введите путь к файлу который нужно расшифровать");
            laval1.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval1);
            JLabel laval2 = new JLabel("либо оставте файл по умочанию");
            laval2.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval2);
            JTextField tf1 = new JTextField( "output.txt",15);
            panel.add(tf1);

            JLabel laval3 = new JLabel("2. Введите ключ (это число) от 1 до 85  которое  ");
            laval3.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval3);
            JLabel laval4 = new JLabel(" Вы должны были бы знать");
            laval4.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval4);
            JTextField tf2 = new JTextField(10);
            panel.add(tf2);

            JLabel laval5 = new JLabel("3 Введите путь к файлу, куда запишется резкльтат   ");
            laval5.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval5);
            JLabel laval6 = new JLabel("выполнения программы, либо оставте путь по умолчанию");
            laval6.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval6);

            JTextField tf3 = new JTextField( "outrez.txt",20);
            panel.add(tf3);
            JButton button =new JButton("Enter");
            panel.add(button);
// и очередная обработка кнопки в созданном окне с подключением конструктора дешифровки
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String st1 = tf1.getText();
                    String keyout = tf2.getText();
                    int keyout1 =Integer.parseInt(keyout);
                    String st3 = tf3.getText();
                    try {
                        Decoder decoder = new Decoder(st1,st3,keyout1);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            });

            frame1.add(panel);
            panel.revalidate();
            frame1.setResizable(false);
            frame1.setVisible(true);

        }
    }
// И создание последнего диалогового окна для кнопки БрюФорс со сбором путей туда и оттуда
    public static class BFActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame1  = new JFrame("Расшифровываем");
            frame1.setBounds(200, 100, 600, 300);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel();

            JLabel laval1 = new JLabel("1. Введите путь к файлу который нужно расшифровать");
            laval1.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval1);
            JLabel laval2 = new JLabel("либо оставте файл по умочанию");
            laval2.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval2);
            JTextField tf1 = new JTextField( "output.txt",15);
            panel.add(tf1);
            JLabel laval5 = new JLabel("2 Введите путь к файлу, куда запишется резкльтат   ");
            laval5.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval5);
            JLabel laval6 = new JLabel("выполнения программы, либо оставте путь по умолчанию");
            laval6.setFont(new Font("Arial", Font.ITALIC, 20));
            panel.add(laval6);

            JTextField tf3 = new JTextField( "outputBF.txt",20);
            panel.add(tf3);
            JButton button =new JButton("Enter");
            panel.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   String str = tf1.getText();
                   String strout = tf3.getText();

                    try {
                        BruteForce bruteForce = new BruteForce(str, strout);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            frame1.add(panel);
            panel.revalidate();
            frame1.setResizable(false);
            frame1.setVisible(true);
// Александр, честно, я сам не доволен таким громоздким кодом... но не смог по другому...
        }
    }
}
