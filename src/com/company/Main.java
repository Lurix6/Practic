package com.company;
import java.util.ArrayList;


public class Main {
    static ArrayList<Character> ABC = new ArrayList<>();
    static ArrayList<Character> textToChar = new ArrayList<>();
    static ArrayList<Character> keyToChar = new ArrayList<>();
    static ArrayList<Character> encryptionsTextChar = new ArrayList<>();
    static ArrayList<Integer> textToInt = new ArrayList<>();
    static ArrayList<Integer> keyToInt = new ArrayList<>();
    static ArrayList<Integer> encryptionsTextInt = new ArrayList<>();
    static String text ;
    static String key ;
    static boolean version;
    public static void main(String[] args) {

        Vigener vig = new Vigener();

        while (true){
            version = vig.menu();
            if (version) {
                vig.fillArrayList(ABC);// заповнили ArrayList<Character> ABC Буквами
                vig.dialog();//ініціалізуємо text i key
                text = vig.getText();
                key = vig.getKey();
                vig.breakText(text, textToChar);//розбиваємо текст на ArrayList<Character>
                vig.breakText(key, keyToChar);
                vig.textToIntArray(textToInt, textToChar, ABC);
                vig.textToIntArray(keyToInt, keyToChar, ABC);
                System.out.println("/n"+"***********************************"+"/n");
                vig.cipher(keyToInt, textToInt, encryptionsTextInt);
                vig.intArrayToChar(encryptionsTextInt, encryptionsTextChar, ABC);
                vig.showArray(encryptionsTextChar);
                vig.clean(ABC, textToChar, keyToChar, encryptionsTextChar, textToInt, keyToInt , encryptionsTextInt);

            }else {
                vig.fillArrayList(ABC);
                vig.dialogForDecrypt();
                text = vig.getText();
                key = vig.getKey();
                vig.breakText(text, textToChar);
                vig.breakText(key, keyToChar);
                vig.textToIntArray(textToInt, textToChar,ABC);
                vig.textToIntArray(keyToInt, keyToChar,ABC);
                vig.decryptText(textToInt,keyToInt,encryptionsTextInt);
                vig.intArrayToChar(encryptionsTextInt,encryptionsTextChar,ABC);
                vig.showArray(encryptionsTextChar);
                vig.clean(ABC, textToChar, keyToChar, encryptionsTextChar, textToInt, keyToInt , encryptionsTextInt);
            }

        }


    }
}



