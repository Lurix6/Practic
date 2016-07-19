package com.company;

/**
 * Created by Vasil on 07.07.2016.
 */
public class Cezar {



    final static char[] MAS = {'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я', ' '};
    final static char[] SUPER_CASE = {'А' ,'Б' ,'В' ,'Г' ,'Ґ' ,'Д' ,'Е' ,'Є' ,'Ж' ,'З' ,'И' ,'І' ,'Ї' ,'Й' ,'К' ,'Л' ,'М' ,'Н' ,'О' ,'П' ,'Р' ,'С' ,'Т' ,'У' ,'Ф' ,'Х' ,'Ц' ,'Ч' ,'Ш' ,'Щ' ,'Ь' ,'Ю' ,'Я'};

    public static String encrypt(String str, int zdv){
        String text  = "";
        int newStart = 0;
        char[] encryptArray = str.toCharArray();
        for (int i = 0; i < encryptArray.length; i++) {
            for (int j = 0; j < MAS.length; j++) {
                if(encryptArray[i] == MAS[j]){
                    if (j + zdv >= MAS.length ){
                        newStart =(( j + zdv) - MAS.length) ;
                        text += MAS[newStart];
                    }else {
                        text += MAS[j + zdv];
                    }
                    break;
                }else if (encryptArray[i] == SUPER_CASE[j]){
                    if(encryptArray[i] == SUPER_CASE[j]){
                        if (j + zdv >= SUPER_CASE.length ){
                            newStart =(( j + zdv) - SUPER_CASE.length) ;
                            text += SUPER_CASE[newStart];
                        }else {
                            text += SUPER_CASE[j + zdv];
                        }
                        break;
                    }

                }
            }
        }
        return text;
    }

    public static String decrypt(String str, int zdv){
        String text  = "";
        int newStart = 0;
        char[] encryptArray = str.toCharArray();
        for (int i = 0; i < encryptArray.length; i++) {
            for (int j = 0; j < MAS.length; j++) {
                if(encryptArray[i] == MAS[j]){
                    if (j < zdv){
                        newStart =(MAS.length - (zdv - j));
                        text += MAS[newStart];
                    }else {
                        text += MAS[j - zdv];
                    }
                    break;
                }else if(encryptArray[i] == SUPER_CASE[j]){
                    if (j < zdv){
                        newStart =(SUPER_CASE.length - (zdv - j));
                        text += SUPER_CASE[newStart];
                    }else {
                        text += SUPER_CASE[j - zdv];
                    }
                    break;
                }
            }
        }
        return text;
    }




}
