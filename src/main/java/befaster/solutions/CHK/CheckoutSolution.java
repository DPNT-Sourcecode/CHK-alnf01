package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.ArrayList;
import java.util.List;


public class CheckoutSolution {
    public static void main(String ...argv) {
        System.out.println("CHK_START");
        System.out.println("(null)[" + checkout(null) + "]");
        System.out.println("(Z)[" + checkout("Z") + "]");
        System.out.println("(AZ)[" + checkout("AZ") + "]");
        System.out.println("(AB)[" + checkout("AB") + "]");
        System.out.println("(AC3A2B)[" + checkout("AC3A2B") + "]");
        System.out.println("(AC3A2B0)[" + checkout("AC3A2B0") + "]");

        System.out.println("CHK_END");
    }

    public static Integer checkout(String skus) {
        if(skus==null || skus.isEmpty()) return -1;
        if(!chekcValidSku(skus)) return -1;

        return 0;
    }

    public static boolean chekcValidSku(String skus) {
        List<String> allowedChars = new ArrayList<>();
        allowedChars.add("A");
        allowedChars.add("B");
        allowedChars.add("C");
        allowedChars.add("D");

        System.out.println("-->" + skus);
        String skusReduced = skus.replace("3A","").replace("2B","");
        System.out.println("-->" + skusReduced);
        for(int i=0; i< skusReduced.length(); i++) {

            String checkedString = skusReduced.substring(i);
            System.out.println("---->" + checkedString);
            boolean containsChar = false;
            for(String s : allowedChars) {
                if(s.equals(checkedString)) containsChar=true;
            }
            if(!containsChar) return false;
        }

        return true;
    }
}
