package com.example.converterproject.NumberSystem;

import java.util.HashMap;
import java.util.Map;

public class BasicOperations {

    public Map<String, Integer> baseMap;
    public BasicOperations() {

        baseMap = new HashMap<>();
        baseMap.put("Binary", 2);
        baseMap.put("Octal", 8);
        baseMap.put("Decimal", 10);
        baseMap.put("Hexadecimal", 16);
    }

    private int getDigitValue(char digit) {
        if (digit >= 'A' && digit <= 'F') {
            return digit - 'A' + 10;
        } else {
            return digit - '0';
        }
    }

    public String Addition(String num1,String num2, int base) {

        String[] num1Parts = num1.split("\\.");
        String[] num2Parts = num2.split("\\.");

        String intPart1 = num1Parts[0];
        String fracPart1 = num1Parts.length > 1 ? num1Parts[1] : "";

        String intPart2 = num2Parts[0];
        String fracPart2 = num2Parts.length > 1 ? num2Parts[1] : "";

        while (intPart2.length() < intPart1.length()) {
            intPart2 = "0" + intPart2;
        }
        while (intPart1.length() < intPart2.length()) {
            intPart1 = "0" + intPart1;
        }
        while (fracPart2.length() < fracPart1.length()) {
            fracPart2 = fracPart2 + "0";
        }
        while (fracPart1.length() < fracPart2.length()) {
            fracPart1 = fracPart1 + "0";
        }

        StringBuilder fracResult = new StringBuilder();
        int carry = 0;
        if(fracPart1.length()>0 || fracPart2.length()>0)
        {
            for (int i = fracPart1.length() - 1; i >= 0; i--) {

                int digit1 = getDigitValue(fracPart1.charAt(i));
                int digit2 = getDigitValue(fracPart2.charAt(i));
                int sum = digit1 + digit2 + carry;
                carry = sum / base;
                int remainder = sum % base;

                char resultChar;
                if (remainder >= 10 && remainder <= 15) {
                    resultChar = (char) ('A' + (remainder - 10));
                } else {
                    resultChar = (char) ('0' + remainder);
                }

                fracResult.append(resultChar);
            }
            fracResult.reverse();
        }


        StringBuilder intResult = new StringBuilder();

        for (int i = intPart1.length() - 1; i >= 0; i--) {
            int digit1 = getDigitValue(intPart1.charAt(i));
            int digit2 = getDigitValue(intPart2.charAt(i));
            int sum = digit1 + digit2 + carry;
            carry = sum / base;
            int remainder = sum % base;

            char resultChar;
            if (remainder >= 10 && remainder <= 15) {
                resultChar = (char) ('A' + (remainder - 10));
            } else {
                resultChar = (char) ('0' + remainder);
            }

            intResult.append(resultChar);
        }

        if (carry > 0) {
            intResult.append(carry);
        }
        intResult.reverse();

        StringBuilder result = new StringBuilder();

        if(fracPart1.length()>0 || fracPart2.length()>0) {
            result.append(intResult).append(".").append(fracResult);
        }
        else
        {
            result.append(intResult);
        }

        return result.toString();
    }

    public String Subtraction(String num1, String num2, int base) {

        String[] num1Parts = num1.split("\\.");
        String[] num2Parts = num2.split("\\.");

        String intPart1 = num1Parts[0];
        String fracPart1 = num1Parts.length > 1 ? num1Parts[1] : "";

        String intPart2 = num2Parts[0];
        String fracPart2 = num2Parts.length > 1 ? num2Parts[1] : "";

        while (intPart2.length() < intPart1.length()) {
            intPart2 = "0" + intPart2;
        }
        while (intPart1.length() < intPart2.length()) {
            intPart1 = "0" + intPart1;
        }
        while (fracPart2.length() < fracPart1.length()) {
            fracPart2 = fracPart2 + "0";
        }
        while (fracPart1.length() < fracPart2.length()) {
            fracPart1 = fracPart1 + "0";
        }

        StringBuilder fracResult = new StringBuilder();
        int borrow = 0;
        if (fracPart1.length() > 0 || fracPart2.length() > 0) {
            for (int i = fracPart1.length() - 1; i >= 0; i--) {
                int digit1 = getDigitValue(fracPart1.charAt(i));
                int digit2 = getDigitValue(fracPart2.charAt(i));

                int temp = digit2 + borrow;

                int difference = digit1 - temp;
                if (difference < 0) {
                    difference += base;
                    borrow = 1;
                }

                char resultChar;
                if (difference >= 10 && difference <= 15) {
                    resultChar = (char) ('A' + (difference - 10));
                } else {
                    resultChar = (char) ('0' + difference);
                }

                fracResult.append(resultChar);
            }
            fracResult.reverse();
        }

        StringBuilder intResult = new StringBuilder();
        for (int i = intPart1.length() - 1; i >= 0; i--) {
            int digit1 = getDigitValue(intPart1.charAt(i));
            int digit2 = getDigitValue(intPart2.charAt(i));


            int temp = digit2 + borrow;

            int difference = digit1 - temp;
            if (difference < 0) {
                difference += base;
                borrow = 1;
            }

            char resultChar;
            if (difference >= 10 && difference <= 15) {
                resultChar = (char) ('A' + (difference - 10));
            } else {
                resultChar = (char) ('0' + difference);
            }

            intResult.append(resultChar);
        }

        if(borrow>0) {
            intResult.append(borrow);
        }

        intResult.reverse();

        StringBuilder result = new StringBuilder();
        if (fracPart1.length() > 0 || fracPart2.length() > 0) {
            result.append(intResult).append(".").append(fracResult);
        } else {
            result.append(intResult);
        }

        return result.toString();
    }

    public String Multiplication(String num1,String num2,int base) {
        NumberConvertion nc = new NumberConvertion();
        Double temp = Double.parseDouble(nc.AnyToDecimal(num1,base)) *
                Double.parseDouble(nc.AnyToDecimal(num2,base));

        String total = nc.DecimalToAny(Double.toString(temp),base);

        return total;
    }

    public String One_s_Complement(String num) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            if (digit == '0') {
                ans.append('1');
            } else if (digit == '1') {
                ans.append('0');
            }
        }
        return ans.toString();
    }

    public String Two_s_Complement(String num) {

        String num1 = One_s_Complement(num);
        String ans = Addition(num1,"1",2);

        return ans;

    }



}
