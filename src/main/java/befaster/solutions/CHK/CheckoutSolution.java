package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CheckoutSolution {
    public static void main(String ...argv) {
        System.out.println("CHK_START");
        System.out.println("(AAABB)(210)[" + checkout("AAABB") + "]");
        System.out.println("(BABDDCAC)(230)[" + checkout("BABDDCAC") + "]");
        System.out.println("(BBBB)(120)[" + checkout("BBBB") + "]");
        System.out.println("(B)(30)[" + checkout("B") + "]");
        System.out.println("(AAAA)(200)[" + checkout("AAAA") + "]");
        System.out.println("(ABCD)(115)[" + checkout("AC3A2B0") + "]");

        System.out.println("CHK_END");
    }

    public static Integer checkout(String skus) {
        //validate
        System.out.println("{"+skus+"}");
        if(skus==null) return -1;
        if(!chekcValidSku(skus)) return -1;
        if(skus.isEmpty()) return 0;

        Map<String,Integer> values = new HashMap<>();
        values.put("A", 50);
        values.put("B", 30);
        values.put("C", 20);
        values.put("D", 15);
        values.put("3A", 130);
        values.put("2B", 45);

        String remainingProducts = skus.trim().replace(" ","");

        //System.out.println("==>remainingProducts [" + remainingProducts + "]");
        int countProdA = countSpecialProducts(remainingProducts,"A");
        int countProd3A = countProdA/3;
        int countRestA = countProdA%3;
        int sumA = countProd3A*values.get("3A") + countRestA*values.get("A");
        System.out.println("======>A " + countProdA + "--" + countProd3A + "--" + countRestA + "--------" + sumA);
        remainingProducts = remainingProducts.replace("A","");

        //System.out.println("==>remainingProducts [" + remainingProducts + "]");
        int countProdB = countSpecialProducts(remainingProducts,"B");
        int countProd2B = countProdB/2;
        int countRestB = countProdB%2;
        int sumB = countProd2B*values.get("2B") + countRestB*values.get("B");
        System.out.println("======>B " + countProdB + "--" + countProd2B + "--" + countRestB + "--------" + sumB);
        remainingProducts = remainingProducts.replace("B","");

        //System.out.println("==>remainingProducts [" + remainingProducts + "]");
        int countProdC = countSpecialProducts(remainingProducts,"C");
        int sumC = values.get("C") * countProdC;;
        System.out.println("======>C " +  sumC);
        remainingProducts = remainingProducts.replace("C","");

        //System.out.println("==>remainingProducts [" + remainingProducts + "]");
        int countProdD = countSpecialProducts(remainingProducts,"D");
        int sumD = values.get("D") * countProdD;;
        System.out.println("======>D " +  sumD);
        remainingProducts = remainingProducts.replace("D","");

        int sum = sumA + sumB + sumC + sumD;


        System.out.println("SUM ("+skus+") = [" + sum + "]");
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

        //System.out.println("----------------------->Product [" + product + "] - " + count + " times.");
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





