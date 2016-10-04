package com.vitja.method;

import com.vitja.CryptographyMethod;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by Viktor on 03.10.2016.
 */
@Component
public class CaesarMethod {
    private final Logger logger = Logger.getLogger(CaesarMethod.class);

    private String encodeMessage;

    private String decodeMessage;

    private Integer encodeKey;

    private Integer decodeKey;

    /*public static void main(String[] args) {
        CaesarMethod caesarMethod = new CaesarMethod();
        *//*for (int i = 0; i < encodedLetters.size(); i++){
            System.out.println(i + "   " + encodedLetters.get(i));
        }*//*
        System.out.println(caesarMethod.isLatin(' '));

    }*/



    public String getDecodeMessage() {
        if(decodeMessage != null && encodeMessage == null || encodeKey == null){
            return decodeMessage;
        }
        if(encodeMessage == null || encodeKey == null){
            return "Введіть початкові дані!";
        }

        return encode(encodeMessage, encodeKey);
    }

    public void setDecodeMessage(String decodeMessage) {
        this.decodeMessage = decodeMessage;
    }

    private String encode(String string, Integer key){
        BidiMap encodedLetters = CryptographyMethod.fillBidiMap();
        StringBuilder stringBuilder = new StringBuilder();
        Integer alphabetSize = encodedLetters.size();

        for (Character letter: string.toCharArray()){
            if(!CryptographyMethod.isLatin(letter)){
                return "Введені дані повинні бути написані латиницею!";
            }
            Integer tempValue = ( (Integer) encodedLetters.getKey(letter) + key + alphabetSize) % alphabetSize;

            stringBuilder.append(encodedLetters.get(tempValue));
        }

        return stringBuilder.toString();
    }

    public String getEncodeMessage() {
        if(encodeMessage != null && decodeMessage == null || decodeKey == null){
            return encodeMessage;
        }
        if(decodeMessage == null || decodeKey == null){
            return "Введіть початкові дані!";
        }

        return encode(decodeMessage, -decodeKey);
    }

    public void setEncodeMessage(String encodeMessage) {
        this.encodeMessage = encodeMessage;
    }

    public Integer getEncodeKey() {
        return encodeKey;
    }

    public void setEncodeKey(Integer encodeKey) {
        this.encodeKey = encodeKey;
    }

    public Integer getDecodeKey() {
        return decodeKey;
    }

    public void setDecodeKey(Integer decodeKey) {
        this.decodeKey = decodeKey;
    }
}
