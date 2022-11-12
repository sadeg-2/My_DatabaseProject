package Java;

public class Question_A_B {
    public static void main(String[] args) {
        double x = 1;
        double y = 2;

        double a = Math.abs((3.0/7)*y + (2.0*y)/(2*Math.PI*x));
        double b = Math.sqrt((4*Math.pow(y,3))/(3*Math.pow(x,3)+Math.pow(y,12)));

        System.out.println("Solution for Q 1 : " + a);
        System.out.println("Solution for Q 2 : " + b);

    }
}
