package com.vitja;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Viktor on 02.10.2016.
 */
public class CryptographyMethod {
    private static final List<CryptographyMethod> methodNames = Arrays.asList(
            new CryptographyMethod("/caesar", "Шифр Цезаря"),
            new CryptographyMethod("/trithemius", "Шифр Тритеміуса"),
            new CryptographyMethod("/vigenere", "Шифр Віженера"));

    public static BidiMap fillBidiMap(){
        BidiMap tempBidiMap = new DualHashBidiMap();
        for(int i = 65; i <= 90; i++){
            tempBidiMap.put(i - 65, (char) i);
        }
        for (int i = 97; i <= 122; i++){
            tempBidiMap.put(i - 71, (char) i);
        }
        tempBidiMap.put(52, (char) 32);
        return tempBidiMap;
    }

    public static boolean isLatin(Character letter){
        if( (letter.charValue() < 97 && letter.charValue() > 90) || letter.charValue() > 122 || (letter.charValue() < 65 && letter.charValue() != ' ')){
            return false;
        }
        return true;
    }

    private String methodURL;

    private String methodName;

    public CryptographyMethod(String methodURL, String methodName) {
        this.methodURL = methodURL;
        this.methodName = methodName;
    }

    public CryptographyMethod() {
    }

    public String getMethodURL() {
        return methodURL;
    }

    public void setMethodURL(String methodURL) {
        this.methodURL = methodURL;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<CryptographyMethod> getMethodNames(){
        return methodNames;
    }
}
