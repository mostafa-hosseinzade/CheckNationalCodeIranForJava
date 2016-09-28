/*
 * Check national code iran
 * بررسی کد ملی با جاوا
 */
package checknationalcodeiranforjava;

import java.util.Scanner;

/**
 *
 * @author Mostafa Hosseinzade
 */
public class CheckNationalCodeIranForJava {
    
    public static void main(String[] args) {
        //For give number
        Scanner in = new Scanner(System.in);
        System.out.println("Enter National Code : => ");
        //Give number
        long num = in.nextLong();
        //Function Check National Code
        boolean out = checkNationalCode(num);
        if (out) {
            System.out.println("National Code is correct.");
        } else {
            System.out.println("National Code is wrong.");
        }
    }
    /**
     * Check national Code
     * @param long input
     * @return boolean
     */
    public static boolean checkNationalCode(long input) {
        int output = 0,
                OrginalLength = String.valueOf(input).length(),
                i = 0,
                helper = 0;
        //Check length
        if(OrginalLength > 11) {
            return false;
        }
        
        char[] each = String.valueOf(input).toCharArray();
        int len = OrginalLength;
        int c = len - 1;
        while (c > 0) {
            helper = len * Integer.valueOf(String.valueOf(each[i]));
            output = output + helper;
            c--;
            len--;
            i++;
        }
        int mod = output % 11;
        if (mod > 11) {
            return false;
        }
        if (11 - mod == Integer.valueOf(String.valueOf(each[OrginalLength - 1]))) {
            return true;
        }
        if (mod < 2 && mod == Integer.valueOf(String.valueOf(each[OrginalLength - 1]))) {
            return true;
        }
        return false;
    }

}
