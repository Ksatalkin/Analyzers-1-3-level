public class Analyzer {

    public static String Analyzer(String s){

        int sign = 0;
        String result = "";
        String res = "";
        int res1 = 0;
        String num1 = "";
        String num2 = "";
        int i = 0;

        while (1 > 0) {
            i = 0;
            num1 = "";
            num2 = "";
            if (s.charAt(0) == '-') {
                i = 1;
                while (s.charAt(i) != '+' && s.charAt(i) != '-' && i <= s.length() - 1) {
                    num1 += String.valueOf(s.charAt(i++));
                    if (i == s.length()) break;
                }
                if (i == s.length()) break;
                sign = i++;

                while (s.charAt(i) != '+' && s.charAt(i) != '-' && i <= s.length() - 1) {
                    num2 += String.valueOf(s.charAt(i++));
                    if (i == s.length()) break;
                }
                if (s.charAt(sign) == '+') res1 = 0 - Integer.parseInt(num1) + Integer.parseInt(num2);
                else if (s.charAt(sign) == '-') res1 = 0 - Integer.parseInt(num1) - Integer.parseInt(num2);
                result = String.valueOf(res1) + s.substring(i);
                s = result;
            }

            if (s.charAt(0) != '-') {
                i = 0;
                num1 = "";
                        num2 = "";
                while (s.charAt(i) != '+' && s.charAt(i) != '-' && i <= s.length() - 1) {
                    num1 += String.valueOf(s.charAt(i++));
                    if (i == s.length()) break;
                }
                if (i == s.length()) break;

                sign = i++;
                if (s.charAt(sign) != '+' && s.charAt(sign) != '-' || sign > s.length()) break;

                while (s.charAt(i) != '+' && s.charAt(i) != '-' && i <= s.length() - 1) {
                    num2 += String.valueOf(s.charAt(i++));
                    if (i == s.length()) break;
                }

                if (s.charAt(sign) == '+') {
                    res1 = Integer.parseInt(num1) + Integer.parseInt(num2);
                } else if (s.charAt(sign) == '-') {
                    res1 = Integer.parseInt(num1) - Integer.parseInt(num2);
                }

                result = String.valueOf(res1) + s.substring(i);
                s = result;
            }
        }
        return result;

    }
}
