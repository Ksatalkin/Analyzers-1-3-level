import java.util.Objects;
import java.util.Stack;

public class Analyzer2 {

    public static String Analyzer2(String s) {
        String res = "";
        int res1 = 0;
        int res2 = 0;
        Stack stackNumeral = new Stack();
        Stack stackSign = new Stack();
        int i = 0;
        String num1 = "";
        String num2 = "";
        int sign = 0;
        int res3 = 0;
        String res4 = "";
        int res5 = 0;
        String res6 = "";
        int test = 0;
        int test2 = 0;

        while (1 > 0) {


            i = 0;
            num1 = "";
            num2 = "";
            while (1 > 0) {
                num1 = "";
                num2 = "";
                if (s.charAt(0) == '-') {
                    i = 1;
                    while (s.charAt(i) != '+' && s.charAt(i) != '-' &&
                            s.charAt(i) != '*' && s.charAt(i) != '/' && i < s.length()) {
                        num1 += String.valueOf(s.charAt(i++));
                    }
                    sign = i++;
                    res2 = Integer.parseInt(num1) * -1;
                    if (i >= s.length()) break;
                    if (s.charAt(sign) == '-' || s.charAt(sign) == '+'){
                        stackNumeral.push(res2);
                        stackSign.push(s.charAt(sign));
                        s = s.substring(i);
                    } else if (s.charAt(sign) == '*') {
                        while (s.charAt(i) != '+' && s.charAt(i) != '-' &&
                                s.charAt(i) != '*' && s.charAt(i) != '/' && i < s.length()) {
                            num2 += String.valueOf(s.charAt(i++));
                        }
                        res1 = res2 * Integer.parseInt(num2);
                    } else if (s.charAt(sign) == '/') {
                        while (s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '*' && s.charAt(i) != '/' && i < s.length()) {
                            num2 += String.valueOf(s.charAt(i++));
                            if (i >= s.length()) break;
                        }
                        res1 = res2 / Integer.parseInt(num2);
                    }
                    if (s.charAt(sign) == '*' || s.charAt(sign) == '/' && i < s.length()) s = res1 + s.substring(i);
                    else if (i >= s.length()) s = String.valueOf(res1);
                }else break;
            }
            i = 0;
            num1 = "";
            num2 = "";
            while (s.charAt(i) != '+' && s.charAt(i) != '-' &&
                    s.charAt(i) != '*' && s.charAt(i) != '/' && i < s.length()) {
                num1 += String.valueOf(s.charAt(i++));
                if (i >= s.length()) break;
            }
            sign = i++;
            stackNumeral.push(num1);
            if (i >= s.length()) break;
            if (s.charAt(sign) == '+' || s.charAt(sign) == '-') stackSign.push(String.valueOf(s.charAt(sign)));

            else if (s.charAt(sign) == '*') {
                while (s.charAt(i) != '+' && s.charAt(i) != '-' && i <= s.length() &&
                        s.charAt(i) != '*' && s.charAt(sign) != '/') {
                    num2 += String.valueOf(s.charAt(i++));
                    if (i >= s.length()) break;
                }
                res1 = Integer.parseInt(String.valueOf(stackNumeral.pop())) * Integer.parseInt(num2);
                s = res1 + s.substring(i);continue;
            } else if (s.charAt(sign) == '/') {
                while (s.charAt(i) != '+' && s.charAt(i) != '-' && i <= s.length() &&
                        s.charAt(i) != '*' && s.charAt(i) != '/') {
                    num2 += String.valueOf(s.charAt(i++));
                    if (i >= s.length()) break;
                }
                res1 = Integer.parseInt(String.valueOf(stackNumeral.pop())) / Integer.parseInt(num2);
                s = res1 + s.substring(i); continue;
            }
        if (i >= s.length()) break;
        s = s.substring(i);
    }


    while (!stackSign.empty()) {
        res3 = Integer.parseInt(String.valueOf(stackNumeral.pop()));
        res4 = String.valueOf(stackSign.pop());
        if (Objects.equals(res4, "+")) {
            res5 += res3;
        }
        if (Objects.equals(res4, "-")) {
            res5 -= res3;
        }
    }
    if (!stackNumeral.empty())
        res5 += Integer.parseInt(String.valueOf(stackNumeral.pop()));
        res6 = String.valueOf(res5);
        return res6;
    }
}
