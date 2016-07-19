package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class MainCezar {
    static int key ;
    static String text;
    static Scanner sc = new Scanner(System.in);
    static Cezar cezar = new Cezar();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        while (true){
            manu();
        }

    }
    static void manu() throws IOException {
        System.out.println("Якшо бажаєте зашифрувати текст то ведіть 1 ");
        System.out.println("Якшо бажаєте розшифрувати текст то ведіть 2 ");
        System.out.println("Якшо бажаєте вийти 3 ");
        int i = Integer.parseInt(reader.readLine());
        if (i == 1){
            dialog1();
        }else if (i == 2){
            dialog2();
        }else if (i == 3){
            System.exit(0);
        }else {
            System.out.println("Неправильний ввод текста");
        }
    }

    static void dialog1() throws IOException {
        System.out.println("Укажіть текст для дешифрації ");
        text = reader.readLine();
        System.out.println("Укажіть здвиг текста");
        key = Integer.parseInt(reader.readLine());
        System.out.println(cezar.encrypt(text,key));

    } static void dialog2() throws IOException {
        System.out.println("Укажіть текст для шифраії ");
        text = reader.readLine();
        System.out.println("Укажіть здвиг текста");
        key = Integer.parseInt(reader.readLine());
        System.out.println(cezar.decrypt(text,key));

    }
}
