package com.vitja.method;

import com.vitja.CryptographyMethod;
import org.apache.commons.collections.BidiMap;

/**
 * Created by Viktor on 04.10.2016.
 */
public class VigenereMethod implements Method {
    private String messageToEncode;

    private String messageToDecode;

    private String keyString = "ExampleString";

    /*public static void main(String[] args) {
        VigenereMethod vigenereMethod = new VigenereMethod();
        vigenereMethod.setMessageToEncode("ABKDA");
        vigenereMethod.setKeyString("ABKDA");
        vigenereMethod.setMessageToDecode(vigenereMethod.getEncodedMessage());
        System.out.println(vigenereMethod.getEncodedMessage());
        System.out.println(vigenereMethod.getDecodedMessage());
    }*/

    public String getDecodedMessage() {
        if(messageToDecode == null){
            return "Введіть початкові дані!";
        }

        return encode(messageToDecode, Boolean.FALSE);
    }

    public String getEncodedMessage() {
        if(messageToEncode == null){
            return "Введіть початкові дані!";
        }

        return encode(messageToEncode, Boolean.TRUE);
    }

    private String encode(String message, Boolean encode){
        BidiMap encodedLetters = CryptographyMethod.fillBidiMap();
        char messageCharArray[] = message.toCharArray();
        char keyCharArray[] = keyString.toCharArray();
        StringBuilder stringBuilder = new StringBuilder(messageCharArray.length);
        Integer alphabetSize = encodedLetters.size();

        for(int i = 0; i < messageCharArray.length; i++){
            if(!CryptographyMethod.isLatin(messageCharArray[i])){
                return "Введені дані повинні бути написані латиницею!";
            }
            Integer keyIndex = i % keyCharArray.length;
            Integer key = encode ? (Integer) encodedLetters.getKey(keyCharArray[keyIndex]) : -(Integer) encodedLetters.getKey(keyCharArray[keyIndex]);
            Integer tempValue = ( (Integer) encodedLetters.getKey(messageCharArray[i]) + key + alphabetSize) % alphabetSize;

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

    public String getKeyString() {
        return keyString;
    }

    public void setKeyString(String keyString) {
        this.keyString = keyString;
    }
}
