package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CheckoutSolution {

    private static Map<String,Integer> values = new HashMap<>();
    private static Map<String,Integer> prices = new HashMap<>();
    private static Map<String,Integer> sum = new HashMap<>();

    public static void main(String ...argv) {
        System.out.println("CHK_START");
//        checkout("E");
//        //System.out.println("(AAAAA AAA A)(380)[" + checkout("AAAAAAAAA") + "]\n\n");
//          System.out.println("(E)(40)[" + checkout("E") + "]\n\n");
//        System.out.println("(E B)(70)[" + checkout("EB") + "]\n\n");
//        System.out.println("(EE BB)(110)[" + checkout("EEBB") + "]\n\n");
//        System.out.println("(EE BBB)(125)[" + checkout("EEBBB") + "]\n\n");
//        System.out.println("(EEEE BB)(160)[" + checkout("EEEEBB") + "]\n\n");
//        System.out.println("(EEEE BBBB)(205)[" + checkout("EEEEBBBB") + "]\n\n");

//       System.out.println("(BABDDCAC)(230)[" + checkout("BABDDCAC") + "]");
        System.out.println("(BBBB)(120)[" + checkout("BBBB") + "]");
//        System.out.println("(B)(30)[" + checkout("B") + "]");
//        System.out.println("(AAAA)(200)[" + checkout("AAAA") + "]");
//        System.out.println("(ABCD)(115)[" + checkout("AC3A2B0") + "]");
//        System.out.println("(F)(10)[" + checkout("F") + "]\n\n");
//        System.out.println("(FF)(20)[" + checkout("FF") + "]\n\n");
//        System.out.println("(FFF)(20)[" + checkout("FFF") + "]\n\n");
//        System.out.println("(FFFF)(30)[" + checkout("FFFF") + "]\n\n");

//        System.out.println("(CCDD)(35)[" + checkout("CCDD") +
        //System.out.println("(CDGIJ)(150)[" + checkout("CDGIJ") + "]");
        System.out.println("CHK_END");
    }

    public static Integer checkout(String skus) {
        //validate
        System.out.println("{"+skus+"}");
        if(skus==null) return -1;
        if(!chekcValidSku(skus)) return -1;
        if(skus.isEmpty()) return 0;


        values.put("A", 50);
        values.put("B", 30);
        values.put("C", 20);
        values.put("D", 15);
        values.put("E", 40);
        values.put("F", 10);
        values.put("G", 20);
        values.put("H", 10);
        values.put("I", 35);
        values.put("J", 60);
        values.put("K", 80);
        values.put("L", 90);
        values.put("M", 15);
        values.put("N", 40);
        values.put("O", 10);
        values.put("P", 50);
        values.put("Q", 30);
        values.put("R", 50);
        values.put("S", 30);
        values.put("T", 20);
        values.put("U", 40);
        values.put("V", 50);
        values.put("w", 20);
        values.put("X", 90);
        values.put("Y", 10);
        values.put("Z", 10);
        values.put("3A", 130);
        values.put("5A", 200);
        values.put("2B", 45);

        String remainingProducts = skus.trim().replace(" ","");

        System.out.println("==>remainingProducts ORIG[" + remainingProducts + "]");


        for(String s: values.keySet()) {
            int count = countSpecialProducts(remainingProducts, s);
            //System.out.println("-->counter for [" + s + "]=[" + count + "]");
            prices.put(s, count)  ;

            //System.out.println(prices.get(s));
        }


        for(String s: values.keySet()) {
            sum.put(s, 0)  ;
        }

//        System.out.println(values);
            System.out.println(prices);
//        System.out.println(sum);


        //Simple products
        remainingProducts = simpleProduct(remainingProducts,"C");
        remainingProducts = simpleProduct(remainingProducts,"D");
        remainingProducts = simpleProduct(remainingProducts,"E");
        remainingProducts = simpleProduct(remainingProducts,"G");
        remainingProducts = simpleProduct(remainingProducts,"I");
        remainingProducts = simpleProduct(remainingProducts,"J");
        remainingProducts = simpleProduct(remainingProducts,"L");
        remainingProducts = simpleProduct(remainingProducts,"N");
        remainingProducts = simpleProduct(remainingProducts,"O");
        remainingProducts = simpleProduct(remainingProducts,"R");
        remainingProducts = simpleProduct(remainingProducts,"S");
        remainingProducts = simpleProduct(remainingProducts,"T");
//        remainingProducts = simpleProduct(remainingProducts,"W");
//        remainingProducts = simpleProduct(remainingProducts,"X");
//        remainingProducts = simpleProduct(remainingProducts,"Y");
//        remainingProducts = simpleProduct(remainingProducts,"Z");


//        //Special offers remove for 2E have 1 B
//        remainingProducts = offerMixedProducts(remainingProducts,"E",2,"B");
//        prices.put("B", countSpecialProducts(remainingProducts,"B"));
//
//        // 3N get one M free
//        remainingProducts = offerMixedProducts(remainingProducts,"N",3,"M");
//        prices.put("M", countSpecialProducts(remainingProducts,"M"));
//
//        //3R get one Q free
//        remainingProducts = offerMixedProducts(remainingProducts,"R",3,"Q");
//        prices.put("Q", countSpecialProducts(remainingProducts,"Q"));
//
//
//        remainingProducts = simpleProduct(remainingProducts,"M");
//        remainingProducts = simpleProduct(remainingProducts,"Q");




//        int countProdA = prices.get("A");
//        if(countProdA > 0 ) {
//            int countProd5A = prices.get("A") / 5;
//            if (countProd5A > 0) countProdA = countProdA - countProd5A*5;
//
//            int countProd3A = countProdA / 3;
//            int countRestA = countProdA % 3;
//            sum.put("A", countProd5A*values.get("5A") + countProd3A * values.get("3A") + countRestA * values.get("A"));
//            System.out.println("======>A " + countProd5A + "--" + prices.get("A") + "--" + countProd3A + "--" + countRestA + "--------" + sum.get("A"));
//            remainingProducts = remainingProducts.replace("A", "");
//        }

//        int countProdB = prices.get("B");
//        if(countProdB > 0 ) {
//            int countProd2B = countProdB / 2;
//            int countRestB = countProdB % 2;
//            sum.put("B", countProd2B * values.get("2B") + countRestB * values.get("B"));
//            System.out.println("======>B " + countProd2B + "--" + countRestB + "--------" + sum.get("B"));
//            remainingProducts = remainingProducts.replace("A", "");
//        }

//        //System.out.println("==>remainingProducts AFTER E[" + remainingProducts + "]");
//        int countProdF = prices.get("F");
//        if(countProdF > 0) {
//            sum.put("F",values.get("F") * countProdF);
//            sum.put("F", offerSameProduct("F", 2, sum.get("F")));
//            System.out.println("======>F " + sum.get("F"));
//            remainingProducts = remainingProducts.replace("F", "");
//        }

//        int countProdU = prices.get("U");
//        if(countProdU > 0) {
//            sum.put("U",values.get("U") * countProdU);
//            sum.put("U", offerSameProduct("U", 3, sum.get("U")));
//            System.out.println("======>U " + sum.get("U"));
//            remainingProducts = remainingProducts.replace("U", "");
//        }


        int totalSum = 0;
        for(Integer v : sum.values()) {
            totalSum+=v;
        }


        System.out.println("SUM ("+skus+") = [" + sum + "]");
        return totalSum;
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
        allowedChars.add("G");
        allowedChars.add("H");
        allowedChars.add("I");
        allowedChars.add("J");
        allowedChars.add("K");
        allowedChars.add("L");
        allowedChars.add("M");
        allowedChars.add("N");
        allowedChars.add("O");
        allowedChars.add("P");
        allowedChars.add("Q");
        allowedChars.add("R");
        allowedChars.add("S");
        allowedChars.add("T");
        allowedChars.add("U");
        allowedChars.add("V");
        allowedChars.add("w");
        allowedChars.add("X");
        allowedChars.add("Y");
        allowedChars.add("Z");

        System.out.println("-->" + skus);
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

    public static String offerMixedProducts(String remainingProducts, String prodActivator, int prodFree, String prodFreeString) {
        //System.out.println("==>remainingProducts ORIG[" + remainingProducts + "]");
        int countProdActivator = countSpecialProducts(remainingProducts,prodActivator);
        int countFree = countProdActivator / prodFree;
        if(countFree > 0) {
            for(int i=0; i< countFree; i++) {
                remainingProducts = remainingProducts.replaceFirst(prodFreeString,"");
                System.out.println("==>remainingProducts AFTER PROD OFFER -- "+ i + " [" + remainingProducts + "]");
            }
        }
        return remainingProducts;
    }

    public static int offerSameProduct(String product, int freeAtNumber,  int startingSum ) {
        int countFree = prices.get(product) / (freeAtNumber+1);

        for(int i=0;i<countFree;i++) {
            startingSum = startingSum - values.get("F");
        }

        return startingSum;
    }

    public static String simpleProduct(String remainingProducts, String product) {
        int countProdG = prices.get(product);
        if(countProdG > 0) {
            sum.put(product, values.get(product) * countProdG);
            //System.out.println("======>G " + sum.get(product));
            remainingProducts = remainingProducts.replace(product, "");
        }
        return  remainingProducts;
    }


}









