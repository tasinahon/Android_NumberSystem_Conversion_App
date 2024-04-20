package com.example.converterproject.NumberSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberConvertion {
//    public static void main(String[] args) {
//        String userInput = "F.4"; // Input your decimal number here
//        int base = 16; // Input the desired base here
//        NumberConvertion ns = new NumberConvertion();
//        String total = ns.AnyToAny(userInput, base, 2);
//        System.out.println(total);
//    }
    public Map<String, Integer> baseMap;
    public NumberConvertion() {
        baseMap = new HashMap<>();
        baseMap.put("Binary", 2);
        baseMap.put("Octal", 8);
        baseMap.put("Decimal", 10);
        baseMap.put("Hexadecimal", 16);
    }

    public String DecimalToAny(String userInput, int base) {
        StringBuilder total = new StringBuilder();

        String integer;
        String fraction;
        if (userInput.contains(".")) {
            String[] parts = userInput.split("\\.");
            integer = parts[0];
            fraction = "0." + parts[1];
        } else {
            integer = userInput;
            fraction = "";
        }

        StringBuilder intPart = new StringBuilder();
        int numInteger = Integer.parseInt(integer);

        while (numInteger != 0) {
            int quotient = numInteger / base;
            int remainder = numInteger % base;

            char remainderChar;
            if (remainder >= 10 && remainder <= 15) {
                remainderChar = (char) ('A' + (remainder - 10));
            } else {
                remainderChar = (char) ('0' + remainder);
            }

            intPart.append(remainderChar);
            numInteger = quotient;
        }

        intPart.reverse();

        StringBuilder fracPart = new StringBuilder();
        int i = 0;
        List<Double> list = new ArrayList<>();
        if(!fraction.isEmpty())
        {
            Double numFraction = Double.parseDouble(fraction);
            while (true) {
                double result = numFraction * base;
                String strRes = Double.toString(result);
                String[] temp = strRes.split("\\.");
                int integerPart = Integer.parseInt(temp[0]);
                String tempStr = "0."+temp[1];
                double fractionalPart = Double.parseDouble(tempStr);

                char integerPartChar;
                if (integerPart >= 10 && integerPart <= 15) {
                    integerPartChar = (char) ('A' + (integerPart - 10));
                } else {
                    integerPartChar = (char) ('0' + integerPart);
                }

                fracPart.append(integerPartChar);
                i++;

                if (fractionalPart == 0.0) {
                    break;
                }

                if (list.contains(fractionalPart)) {
                    fracPart.append(".....");
                    break;
                } else {
                    list.add(fractionalPart);
                    if (i == 11) {
                        fracPart.append(".....");
                        break;
                    }


                }

                numFraction = fractionalPart;
            }
            if (intPart.length() == 0) {
                intPart.append('0');
            }

            total.append(intPart).append('.').append(fracPart);
        }
        else total.append(intPart);

        return total.toString();
    }

    public String AnyToDecimal(String userInput, int base) {
        String integer;
        String fraction;
        if (userInput.contains(".")) {
            String[] parts = userInput.split("\\.");
            integer = parts[0];
            fraction = parts[1];
        } else {
            integer = userInput;
            fraction = "";
        }

        StringBuilder total = new StringBuilder();

        double intTotal = 0.0;
        int intIdx = integer.length() - 1;
        for (char digit : integer.toCharArray()) {
            int digitValue;
            if (digit >= 'A' && digit <= 'F') {
                digitValue = digit - 'A' + 10;
            } else {
                digitValue = digit - '0';
            }
            intTotal += digitValue * Math.pow(base, intIdx);
            intIdx--;
        }

        double fracTotal = 0.0;
        int fracIdx = -1;
        if (!fraction.isEmpty()) {
            for (char digit : fraction.toCharArray()) {
                int digitValue;
                if (digit >= 'A' && digit <= 'F') {
                    digitValue = digit - 'A' + 10;
                } else {
                    digitValue = digit - '0';
                }
                fracTotal += digitValue * Math.pow(base, fracIdx);
                fracIdx--;
            }
            total.append(intTotal + fracTotal);

        } else {
            String temp = Double.toString(intTotal).split("\\.")[0];
            total.append(temp);
        }

        return total.toString();
    }

    public String AnyToAny(String userInput, int base1, int base2) {
        String temp = AnyToDecimal(userInput,base1);
        String total = DecimalToAny(temp,base2);

        if(total.length()==0) total = "0";
        return total;
    }
}
