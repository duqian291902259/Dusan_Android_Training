package com.nonolive.login;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Description:Base64编解码
 *
 * @author 杜乾-duqian,Created on 2017/8/15 - 17:31.
 *         E-mail:duqian2010@gmail.com
 */
public class Base64Utils {

    public static String decode(String encodedString){
        byte[] asBytes = Base64.decode(encodedString,Base64.DEFAULT);
        String result = "";
        try {
            result = new String(asBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String encode(String str){
        byte[] asBytes = Base64.encode(str.getBytes(),Base64.DEFAULT);
        String result = "";
        try {
            result = new String(asBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
