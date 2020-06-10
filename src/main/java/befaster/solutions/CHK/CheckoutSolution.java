package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;




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
}


