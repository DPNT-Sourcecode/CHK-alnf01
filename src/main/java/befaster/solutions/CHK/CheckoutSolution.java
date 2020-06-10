package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CheckoutSolution {
//    public static void main(String ...argv) {
//        System.out.println("CHK_START");
////        //System.out.println("(AAAAA AAA A)(380)[" + checkout("AAAAAAAAA") + "]\n\n");
////        System.out.println("(E)(40)[" + checkout("E") + "]\n\n");
////        System.out.println("(E B)(70)[" + checkout("EB") + "]\n\n");
////        System.out.println("(EE BB)(110)[" + checkout("EEBB") + "]\n\n");
////        System.out.println("(EE BBB)(125)[" + checkout("EEBBB") + "]\n\n");
////        System.out.println("(EEEE BB)(160)[" + checkout("EEEEBB") + "]\n\n");
////        System.out.println("(EEEE BBBB)(205)[" + checkout("EEEEBBBB") + "]\n\n");
//
////        System.out.println("(BABDDCAC)(230)[" + checkout("BABDDCAC") + "]");
////        System.out.println("(BBBB)(120)[" + checkout("BBBB") + "]");
////        System.out.println("(B)(30)[" + checkout("B") + "]");
////        System.out.println("(AAAA)(200)[" + checkout("AAAA") + "]");
////        System.out.println("(ABCD)(115)[" + checkout("AC3A2B0") + "]");
////        System.out.println("(F)(10)[" + checkout("F") + "]\n\n");
////        System.out.println("(FF)(20)[" + checkout("FF") + "]\n\n");
////        System.out.println("(FFF)(20)[" + checkout("FFF") + "]\n\n");
////        System.out.println("(FFFF)(30)[" + checkout("FFFF") + "]\n\n");
//
//        System.out.println("CHK_END");
//    }

    public  Integer checkout(String skus) {
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
        values.put("E", 40);
        values.put("F", 10);
        values.put("3A", 130);
        values.put("5A", 200);
        values.put("2B", 45);

        String remainingProducts = skus.trim().replace(" ","");

        int countProdA = countSpecialProducts(remainingProducts,"A");

        int countProdC = countSpecialProducts(remainingProducts,"C");
        int countProdD = countSpecialProducts(remainingProducts,"D");
        int countProdE = countSpecialProducts(remainingProducts,"E");
        int countProdF = countSpecialProducts(remainingProducts,"F");

        //Special offers remove stringssss for 2E remove on B
        System.out.println("==>remainingProducts ORIG[" + remainingProducts + "]");
        int countBFree = countProdE / 2;
        if(countBFree > 0) {
            for(int i=0; i< countBFree; i++) {
                remainingProducts = remainingProducts.replaceFirst("B","");
                System.out.println("==>remainingProducts AFTER E -- "+ i + " [" + remainingProducts + "]");
            }
        }
        int countProdB = countSpecialProducts(remainingProducts,"B");


        int sumA =0 ;
        if(countProdA > 0 ) {
            int countProd5A = countProdA / 5;
            if (countProd5A > 0) countProdA = countProdA - countProd5A*5;

            int countProd3A = countProdA / 3;
            int countRestA = countProdA % 3;
            sumA = countProd5A*values.get("5A") + countProd3A * values.get("3A") + countRestA * values.get("A");
            System.out.println("======>A " + countProd5A + "--" + countProdA + "--" + countProd3A + "--" + countRestA + "--------" + sumA);
            remainingProducts = remainingProducts.replace("A", "");
        }

        System.out.println("==>remainingProducts AFTER A[" + remainingProducts + "]");
        int sumB = 0;
        if(countProdB > 0) {
            int countProd2B = countProdB / 2;
            int countRestB = countProdB % 2;
            sumB = countProd2B * values.get("2B") + countRestB * values.get("B");
            System.out.println("======>B " + countProdB + "--" + countProd2B + "--" + countRestB + "--------" + sumB);
            remainingProducts = remainingProducts.replace("B", "");
        }

        System.out.println("==>remainingProducts AFTER B[" + remainingProducts + "]");

        int sumC = 0;
        if(countProdC > 0) {
            sumC = values.get("C") * countProdC;
            System.out.println("======>C " + sumC);
            remainingProducts = remainingProducts.replace("C", "");
        }


        System.out.println("==>remainingProducts AFTER C[" + remainingProducts + "]");
        int sumD = 0;
        if(countProdD > 0) {
            sumD = values.get("D") * countProdD;
            System.out.println("======>D " + sumD);
            remainingProducts = remainingProducts.replace("D", "");
        }

        System.out.println("==>remainingProducts AFTER D[" + remainingProducts + "]");
        int sumE = 0;
        if(countProdE > 0) {
            sumE = values.get("E") * countProdE;
            System.out.println("======>E " + sumE);
            remainingProducts = remainingProducts.replace("E", "");
        }

        System.out.println("==>remainingProducts AFTER E[" + remainingProducts + "]");
        int sumF = 0;
        if(countProdF > 0) {
            sumF = values.get("F") * countProdF;
            int countProdFFree = countProdF /3;
            for(int i=0;i<countProdFFree;i++) {
                sumF = sumF - values.get("F");
            }
            System.out.println("======>F " + sumF);
            remainingProducts = remainingProducts.replace("F", "");
        }

        int sum = sumA + sumB + sumC + sumD + sumE + sumF;


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
        allowedChars.add("E");
        allowedChars.add("F");

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




