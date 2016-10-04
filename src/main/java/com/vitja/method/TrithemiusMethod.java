package com.vitja.method;

import com.vitja.CryptographyMethod;
import org.apache.commons.collections.BidiMap;

/**
 * Created by Viktor on 04.10.2016.
 */
public class TrithemiusMethod implements Method {
    private String messageToEncode;

    private String messageToDecode;

    private Integer coefficientA = 3;

    private Integer coefficientB = 2;

    /*public static void main(String[] args) {
        TrithemiusMethod trithemiusMethod = new TrithemiusMethod();
        trithemiusMethod.setMessageToEncode("ABCD");
        trithemiusMethod.setMessageToDecode(trithemiusMethod.getEncodedMessage());
        System.out.println(trithemiusMethod.getEncodedMessage());
        System.out.println(trithemiusMethod.getDecodedMessage());

    }*/

    public String getEncodedMessage(){
        if(messageToEncode == null){
            return "Введіть початкові дані!";
        }

        return encode(messageToEncode, Boolean.TRUE);
    }

    public String getDecodedMessage(){
        if(messageToDecode == null){
            return "Введіть початкові дані!";
        }

        return encode(messageToDecode, Boolean.FALSE);
    }

    private String encode(String message, Boolean encode){
        BidiMap encodedLetters = CryptographyMethod.fillBidiMap();
        char lettersArray[] = message.toCharArray();
        StringBuilder stringBuilder = new StringBuilder(lettersArray.length);
        Integer alphabetSize = encodedLetters.size();

        for(int i = 0; i < lettersArray.length; i++){
            if(!CryptographyMethod.isLatin(lettersArray[i])){
                return "Введені дані повинні бути написані латиницею!";
            }
            Integer key = encode ? (coefficientA * i + coefficientB) : - coefficientA * i - coefficientB;
            Integer tempValue = ( (Integer) encodedLetters.getKey(lettersArray[i]) + key + alphabetSize) % alphabetSize;

            stringBuilder.append(encodedLetters.get(tempValue));
        }
        return stringBuilder.toString();
    }

    public String getMessageToEncode() {
        return messageToEncode;
    }

    public void setMessageToEncode(String messageToEncode) {
        this.messageToEncode = messageToEncode;
    }

    public String getMessageToDecode() {
        return messageToDecode;
    }

    public void setMessageToDecode(String messageToDecode) {
        this.messageToDecode = messageToDecode;
    }

    public Integer getCoefficientA() {
        return coefficientA;
    }

    public void setCoefficientA(Integer coefficientA) {
        this.coefficientA = coefficientA;
    }

    public Integer getCoefficientB() {
        return coefficientB;
    }

    public void setCoefficientB(Integer coefficientB) {
        this.coefficientB = coefficientB;
    }
}
