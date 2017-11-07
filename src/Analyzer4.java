import java.util.Objects;
import java.util.Stack;

public class Analyzer4 {

        public static void main(String[] args){

            String s ="10-15-5";
            String s2 = "10-5/5";
            String s3 = "100*(200/(10+40))+10";

            System.out.println(Analyzer.Analyzer(s));
            System.out.println(Analyzer2.Analyzer2(s2));
            System.out.println(Analyzer3.Analyzer3(s3));


        }
}


