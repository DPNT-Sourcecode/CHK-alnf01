package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.ArrayList;
import java.util.List;


public class CheckoutSolution {
    public static void main(String ...argv) {
        System.out.println("CHK_START");
        System.out.println("(null)[" + checkout(null) + "]");
        System.out.println("(null)[" + checkout("Z") + "]");

        System.out.println("CHK_END");
    }

    public static Integer checkout(String skus) {
        if(skus==null || skus.isEmpty()) return -1;


        return 0;
    }

    public static boolean chekcValidSku(String skus) {
        List<String> allowedChars = new ArrayList<>();
        allowedChars.add("A");
        allowedChars.add("B");
        allowedChars.add("C");
        allowedChars.add("D");
        allowedChars.add("3A");
        allowedChars.add("2B");

        
    }
}



