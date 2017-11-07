import java.util.Objects;
import java.util.Stack;

public class Analyzer3 {

    public static String Analyzer3(String s){
        String s2 = s;
        String s3 = "";
        String s4 = "";
        String s5 = "";
        String s6 = "";
        String s7 = "";
        String s8 = "";
        String num1 = "";
        String num2 = "";
        int sign = 0;
        int res1 = 0;
        int i = 0;
        String result = "";
        int j = 0;
        int j4 = 0;
        int j5 = 0;
        int j6 = 0;
        int j7 = 0;
        int res2 = 0;
        int countBracketLeft = -1;
        int countBracketRight = -1;
        int j2 = 0;
        int count = 0;
        int test = 0;
        int test2 = 0;
        int k = 0;

        while (1 > 0) {
            for (test = 0; test < s.length(); test++) {
                if (s.charAt(test) == '(') test2++;
            }
            if (test2 == 0) break;
            test2 = 0;
            s2 = s;
            count = 0;
            j = 0;
            for (countBracketLeft = -1; j < s2.length(); j++) {
                if (Objects.equals(String.valueOf(s2.charAt(j)), "(")) {
                    countBracketLeft = j;
                    count++;
                }
            }
            if (countBracketLeft > -1) s3 = s.substring(0, countBracketLeft);
            if (countBracketLeft == -1) break;
            j2 = 0;
            while (count > 0) {
                if (Objects.equals(String.valueOf(s2.charAt(j2)), "(")) {
                    s6 = s2.substring(j2 + 1);
                    count--;
                    if (count == 0) break;
                }
                j2++;
            }
            j = 0;
            for (countBracketRight = -1; j < s6.length(); j++) {
                if (Objects.equals(String.valueOf(s6.charAt((j))), ")")) {
                    countBracketRight = j;
                    break;
                }
            }
            s4 = s6.substring(countBracketRight + 1, s6.length());
            s2 = s6.substring(0, countBracketRight);
            s2 = Analyzer2.Analyzer2(s2);
            s = s3 + s2 + s4;
            s = s.replace("+-", "-");
            s = s.replace("--", "+");


            for (int j3 = 0; j3 < s.length() - 2; j3++) {
                if (s.charAt(j3) == '*' && s.charAt(j3 + 1) == '(' && s.charAt(j3 + 2) == '-' ||
                        s.charAt(j3) == '/' && s.charAt(j3 + 1) == '(' && s.charAt(j3 + 2) == '-') {
                    for (j4 = j3; s.charAt(j4) != '+' || s.charAt(j4) != '-'; j4--) {
                    }
                    if (s.charAt(j4) == '+') s = s.replace(String.valueOf(s.charAt(j4)), "-");
                    if (s.charAt(j4) == '-') s = s.replace(String.valueOf(s.charAt(j4)), "+");
                    for (j5 = j3 + 2; s.charAt(j5) != ')'; j5++) {
                        if (s.charAt(j5) == '+') s = s.replace(String.valueOf(s.charAt(j5)), "-");
                        else if (s.charAt(j5) == '-') s = s.replace(String.valueOf(s.charAt(j5)), "+");
                    }
                }else
                if (s.charAt(j3) == '+' && s.charAt(j3) == '(' && s.charAt(j3) == '-') {
                    s = s.replace(String.valueOf(s.charAt(j3)), "-");
                    for (j5 = j3 + 2; s.charAt(j5) != ')'; j5++) {
                        if (s.charAt(j5) == '+') s = s.replace(String.valueOf(s.charAt(j5)), "-");
                        else if (s.charAt(j5) == '-') s = s.replace(String.valueOf(s.charAt(j5)), "+");
                    }
                    j3 = 0;
                }else
                if (s.charAt(j3) == '-' && s.charAt(j3 + 1) == '(' && s.charAt(j3 + 2) == '-') {
                    s = s.replace(String.valueOf(s.charAt(j3)), "+");
                    for (j5 = j3; s.charAt(j5) != ')'; j5++) {
                        if (s.charAt(j5) == '+') s = s.replace(String.valueOf(s.charAt(j5)), "-");
                        else if (s.charAt(j5) == '-') s = s.replace(String.valueOf(s.charAt(j5)), "+");
                    }
                    j3 = 0;
                }else
                if (s.charAt(j3) == '*' && s.charAt(j3 + 1) == '-') {
                    j6 = j3-1;
                    while (s.charAt(j6) != '+' && s.charAt(j6) != '-' &&
                            s.charAt(j6) != '*' && s.charAt(j6) != '/' && j6 >= 0) {
                        num1 = s.charAt(j6--) + num1;
                        if (j6 < 0) break;
                    }
                    if (j6 < 0) s7 = "";
                    else s7 = s.substring(0, j6);
                    j6 = j3+2;
                    while (s.charAt(j6) != '+' && s.charAt(j6) != '-' &&
                            s.charAt(j6) != '*' && s.charAt(j6) != '/' && j6 < s.length()) {
                        num2 += s.charAt(j6++);
                        if (j6 >= s.length()) break;
                    }
                    s8 = s.substring(j6);
                    res1 = Integer.parseInt(num1) * Integer.parseInt(num2) * -1;
                    s = s7 + String.valueOf(res1) + s8;
                    j3 = 0;
                }else
                if (s.charAt(j3) == '/' && s.charAt(j3 + 1) == '-') {
                    j6 = j3;
                    while (s.charAt(j6) != '+' && s.charAt(j6) != '-' &&
                            s.charAt(j6) != '*' && s.charAt(j6) != '/' && j6 < s.length()) {
                        num1 += s.charAt(j6++);
                        if (j6 >= s.length()) break;
                    }
                    j6 = j3;
                    while (s.charAt(j6) != '+' && s.charAt(j6) != '-' &&
                            s.charAt(j6) != '*' && s.charAt(j6) != '/' && j6 < s.length()) {
                        num2 += s.charAt(j6++);
                        if (j6 >= s.length()) break;
                    }
                    s7 = s.substring(0, j3);
                    s8 = s.substring(j3 + 2);
                    res1 = Integer.parseInt(num1) / Integer.parseInt(num2);
                    s = s7 + String.valueOf(res1) + s8;
                    j3 = 0;
                }
            }

        }

        int d = 0;
        for (int ii = 1; ii < s.length(); ii++){
            if (s.charAt(ii) == '+' || s.charAt(ii) == '-' || s.charAt(ii) == '*' || s.charAt(ii) == '/')
                d++;
        }
        if (d > 0) s = Analyzer2.Analyzer2(s);

                num1 = "";
                num2 = "";
                for (i = 0; i < s.length(); i++) {

                    if (s.charAt(i) == '+' && s.charAt(i + 1) == '-') {
                        s5 = s.substring(0, i);
                        s6 = s.substring(i + 2);
                        s = s5 + "-" + s6;
                    }

                    if (s.charAt(i) == '-' && s.charAt(i + 1) == '-') {
                        s5 = s.substring(0, i);
                        s6 = s.substring(i + 2);
                        s = s5 + "+" + s6;
                    }
                }
        return s;

    }
}
