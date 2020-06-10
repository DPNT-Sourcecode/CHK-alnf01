package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        //validate
        if(skus==null || skus.isEmpty()) return -1;
        if(!chekcValidSku(skus)) return -1;

        Map<String,Integer> values = new HashMap<>();
        values.put("A", 50);
        values.put("B", 30);
        values.put("C", 20);
        values.put("D", 15);
        values.put("3A", 130);
        values.put("2B", 45);

        System.out.println("==>SKUs [" + skus + "]");
        int countProd3A = countSpecialProducts(skus,"3A");
        int countProd2B = countSpecialProducts(skus,"2B");
        String remainingProducts = skus.replace("3A","").replace("2B","").trim().replace(" ","");

        System.out.println("==>remainingProducts [" + remainingProducts + "]");
        int countProdA = countSpecialProducts(remainingProducts,"A");
        remainingProducts = remainingProducts.replace("A","");

        System.out.println("==>remainingProducts [" + remainingProducts + "]");
        int countProdB = countSpecialProducts(remainingProducts,"B");
        remainingProducts = remainingProducts.replace("B","");

        System.out.println("==>remainingProducts [" + remainingProducts + "]");
        int countProdC = countSpecialProducts(remainingProducts,"C");
        remainingProducts = remainingProducts.replace("C","");

        System.out.println("==>remainingProducts [" + remainingProducts + "]");
        int countProdD = countSpecialProducts(remainingProducts,"D");
        remainingProducts = remainingProducts.replace("D","");

        int sum =0;
        sum = values.get("A") * countProdA;
        sum += values.get("B") * countProdB;
        sum += values.get("C") * countProdC;
        sum += values.get("D") * countProdD;
        sum += values.get("3A") * countProd3A;
        sum += values.get("2B") * countProd2B;

        return sum;
    }

    public static int countSpecialProducts(String skus, String product) {
        int lastIndex=0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = skus.indexOf(product,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += product.length();
            }
        }

        System.out.println("----------------------->Product [" + product + "] - " + count + " times.");
        return count;
    }

    public static boolean chekcValidSku(String skus) {
        List<String> allowedChars = new ArrayList<>();
        allowedChars.add("A");
        allowedChars.add("B");
        allowedChars.add("C");
        allowedChars.add("D");

        //System.out.println("-->" + skus);
        String skusReduced = skus.replace("3A","").replace("2B","").trim().replace(" ","");
        //System.out.println("-->" + skusReduced);
        for(int i=0; i< skusReduced.length(); i++) {

            char checkedString = skusReduced.charAt(i);
            //System.out.println("---->" + checkedString);
            boolean containsChar = false;
            for(String s : allowedChars) {
                //System.out.println("[" + s + "] vs [" + checkedString + "] [" + containsChar + "]");
                if(s.charAt(0) == checkedString) containsChar=true;
            }
            if(!containsChar) return false;
        }

        return true;
    }
}







