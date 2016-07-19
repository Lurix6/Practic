package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Vigener {
    String key;
    final static int ABCSIZE = 79;
    public String getText() {
        return text;
    }

    public String getKey() {
        return key;
    }

    String text;

    Scanner sc =new Scanner(System.in);

    public boolean menu(){
        boolean a ;
        while (true) {
            System.out.println("Бажаєте зашифрувати текст натисніть 1");
            System.out.println("Бажаєте розшифрувати текст натисніть 2");
            System.out.println("Бажаєту вийти натисніть 3");
            byte i = 9;
            try{
                i = Byte.parseByte(sc.nextLine());
            }catch (Exception e){
            }
            if (i == 1) {
                a = true;
                break;
            }if (i == 2) {
                a = false;
                break;
            }if (i == 3)
                System.exit(0);
            if (i > 3 || i < 1)
                System.out.println("Такого варіанта немає");
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        }
        return a;

    }

    public void dialog(){
        System.out.println("Напишіть ключ для шифрування ");
        key = sc.nextLine();
        System.out.println("Вкажіть текст для шифрування ");
        text = sc.nextLine();
    }

    public void fillArrayList(ArrayList<Character> ABC) {
        char[] mas = {'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я','А' ,'Б' ,'В' ,'Г' ,'Ґ' ,'Д' ,'Е' ,'Є' ,'Ж' ,'З' ,'И' ,'І' ,'Ї' ,'Й' ,'К' ,'Л' ,'М' ,'Н' ,'О' ,'П' ,'Р' ,'С' ,'Т' ,'У' ,'Ф' ,'Х' ,'Ц' ,'Ч' ,'Ш' ,'Щ' ,'Ь' ,'Ю' ,'Я' ,' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ',', '.'};
        for (int i = 0; i < mas.length; i++) {
            ABC.add(mas[i]);
        }
    }


    public void breakText(String text, ArrayList<Character> words) {
        /**
         * String text це текст який ви розіб*єте в масив ArrayList<Character>
         * ArrayList<Character> list це масив в який буде складено text у вигляді char
         */
        char[] mas = text.toCharArray();
        for (char a : mas) {
            words.add(a);
        }

    }
    public void textToIntArray(ArrayList<Integer> enСryptInt , ArrayList<Character> letter, ArrayList<Character> ABC) {
        /**
         *  ArrayList enСryptInt лист в який будуть записані порядкові цифри слова textToInt
         *  ArrayList textToChar лист в якому зберігаються літери слова
         *  ArrayList ABC лист в якому зберігаються всі літери алфавіту
         */
        for (int i = 0; i < letter.size(); i++) {
            if (ABC.contains(letter.get(i)));
            enСryptInt.add(ABC.indexOf(letter.get(i))+1);
        }

    }

    public void showArray(ArrayList<Character> list) {
        int index = 0;
        for (char a1 : list) {
            if(index == 0 ) {
                System.out.print(a1);
                index++;
            } else {
                System.out.print(a1);
            }
        }
        System.out.println();
        index = 0;
    }
    public void showArrayInt(ArrayList<Integer> list) {
        int index = 0;
        for (Integer a1 : list) {
            if(index == 0 ) {
                System.out.print(a1);
                index++;
            }else {
                System.out.print(a1);
            }
        }
        index = 0;
    }

    public void cipher(ArrayList<Integer> keyInt, ArrayList<Integer> textInt, ArrayList<Integer> encryptionsTextInt){
        if(keyInt.size() < textInt.size()){
            int k = 0 ;
            for (int i = 0; i < textInt.size(); i++) {
                if (k >= keyInt.size()){
                    k = 0;
                    int j = keyInt.get(k)+ textInt.get(i);
                    if (j > ABCSIZE) {
                        encryptionsTextInt.add(j - ABCSIZE - 1);
                        k++;
                    }else {
                        encryptionsTextInt.add(j - 1);
                        k++;
                    }
                }else {
                    int j = keyInt.get(k)+ textInt.get(i);
                    if (j > ABCSIZE) {
                        encryptionsTextInt.add(j - ABCSIZE - 1);
                        k++;
                    }else {
                        encryptionsTextInt.add(j - 1);
                        k++;
                    }
                }
            }

        }else if (keyInt.size() == textInt.size()){

            for (int i = 0; i < keyInt.size(); i++) {
                int k = keyInt.get(i)+ textInt.get(i);
                if (k > ABCSIZE) {
                    encryptionsTextInt.add(k - ABCSIZE - 1);
                    k++;
                }else {
                    encryptionsTextInt.add(k - 1);
                    k++;
                }
            }

        }else {
            int j = textInt.size();
            for (int i = 0; i < j; i++) {
                int k = keyInt.get(i)+ textInt.get(i);
                if (k > ABCSIZE) {
                    encryptionsTextInt.add(k - ABCSIZE);
                }else {
                    encryptionsTextInt.add(k);
                }
            }
        }
    }
    public void intArrayToChar(ArrayList<Integer> intArray, ArrayList<Character> charArray, ArrayList<Character> ABC) {

        for (int a : intArray) {
            charArray.add(ABC.get(a-1));
        }
    }

    public void dialogForDecrypt(){
        System.out.println("Вкажіть текст який  ви бажаєте розшифрувати ");
        text = sc.nextLine();
        System.out.println("Вкажіть ключ для дешефрації");
        key = sc.nextLine();
    }
    public void decryptText(ArrayList<Integer> text, ArrayList<Integer> key, ArrayList<Integer> decryptData){
        if (text.size() == key.size()){
            for (int i = 0; i < text.size(); i++) {
                int dx = text.get(i) - key.get(i);
                if (dx < 1){
                    dx = Math.abs(dx);
                    decryptData.add(ABCSIZE - dx +1);
                }else {
                    decryptData.add(dx);
                }
            }
        }else if (text.size() > key.size()){
            int k = 0;
            for (int i = 0; i < text.size(); i++) {
                if (k >=key.size()){
                    k = 0;
                    int dx = text.get(i)-key.get(k) + 1;
                    if (dx < 1){
                        dx = Math.abs(dx);
                        decryptData.add(ABCSIZE - dx);
                        k++;
                    }else {
                        decryptData.add(dx);
                        k++;
                    }


                }else {
                    int dx = text.get(i)-key.get(k) + 1;
                    if (dx < 1){
                        dx = Math.abs(dx);
                        decryptData.add(ABCSIZE - dx);
                        k++;
                    }else {
                        decryptData.add(dx);
                        k++;
                    }
                }
            }
        }else {
            int j = text.size();
            for (int i = 0; i < j; i++) {
                int k =  text.get(i) - key.get(i) + 1;
                if (k < 1) {
                    k = Math.abs(k);
                    decryptData.add(ABCSIZE - k);
                }else {
                    decryptData.add(k);
                }
            }
        }
    }


    public void clean(ArrayList<Character> abc, ArrayList<Character> textToChar, ArrayList<Character> keyToChar, ArrayList<Character> encryptionsTextChar, ArrayList<Integer> textToInt, ArrayList<Integer> keyToInt, ArrayList<Integer> encryptionsTextInt) {
        abc.clear();
        textToChar.clear();
        keyToChar.clear();
        encryptionsTextChar.clear();
        textToInt.clear();
        keyToInt.clear();
        encryptionsTextInt.clear();
    }
}
