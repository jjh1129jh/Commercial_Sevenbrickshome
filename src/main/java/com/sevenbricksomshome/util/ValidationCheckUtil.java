package com.sevenbricksomshome.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

@Slf4j
public class ValidationCheckUtil {

    public static Boolean emptyCheck(String value){
        if(null==value||("").equals(value)||("null").equals(value)||("NULL").equals(value)||("undefined").equals(value)) {
            return false;
        }else{
            return true;
        }
    }

    public static Boolean lengthCheck(String value, int maxLength){
        int strLength = value.length();
        log.debug("strLength : "+strLength);

        if(strLength > maxLength) {
            return false;
        }else{
            return true;
        }
    }

    public static Boolean dateCheck(String value){

        try{
            int strLength = value.length();
            log.debug("strLength : "+strLength);

            if(strLength == 10){
                SimpleDateFormat dateFormatParser = new SimpleDateFormat("yyyy-MM-dd");
                dateFormatParser.setLenient(false);
                dateFormatParser.parse(value);

                return true;
            }else{
                return false;
            }

        }catch (Exception e){
            return false;
        }
    }

    public static Boolean dateTimeCheck(String value){

        try{
            int strLength = value.length();
            log.debug("strLength : "+strLength);

            if(strLength == 16){
                SimpleDateFormat dateFormatParser = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                dateFormatParser.setLenient(false);
                dateFormatParser.parse(value);

                return true;
            }else{
                return false;
            }

        }catch (Exception e){
            return false;
        }
    }

    public static boolean phoneCheck(String str) {
        return Pattern.matches("^\\d{2,3}\\d{3,4}\\d{4}$", str);
    }

    // 이메일 검사기
    public static boolean emailCheck(String str) {
        return Pattern.matches("^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$", str);
    }

    public static boolean passwordCheck(String str) {
        return Pattern.matches("^(?=.*[a-zA-Z])((?=.*\\d)(?=.*\\W)).{8,20}$", str);
    }
    public static void main(String[] args){

        try {
        	boolean emptyCheck = ValidationCheckUtil.emptyCheck("484651984561");
			boolean lengthCheck = ValidationCheckUtil.lengthCheck("길이체크", 255);
			boolean dateCheck = ValidationCheckUtil.dateCheck("2022-03-01");
			boolean dateTimeCheck = ValidationCheckUtil.dateTimeCheck("2022-03-01 12:11");

            log.debug("emptyCheck     : "+emptyCheck);
            log.debug("lengthCheck    : "+lengthCheck);
            log.debug("dateCheck      : "+dateCheck);
            log.debug("dateTimeCheck  : "+dateTimeCheck);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
