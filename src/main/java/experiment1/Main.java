package experiment1;

import java.util.Scanner;

/**
 * ClassName: Main <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/11 0011
 * @since JDK 11
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

//    public static void main(String[] args) {
//        System.out.println(">>>>>> Problem One:");
//        problem1();
////        System.out.println(">>>>>> Problem Two:");
////        problem2();
////        System.out.println(">>>>>> Problem Three:");
////        problem3();
//    }

    public static void problem1(){
        System.out.println("Enter interval length：");
        int length = scanner.nextInt();
        System.out.println("Enter n:");
        int n = scanner.nextInt();
        System.out.println("Enter prediction x:");
        double preX = scanner.nextDouble();
        Lagrange lagrange = new Lagrange(length, n, new MyFunction(), -5);
        Linear linear = new Linear(length, n, new MyFunction(), -5);
        System.out.println("Lagrange calculate result:");
        double estimatedValue = lagrange.calculate(preX);
        double exactValue = new MyFunction().calculate(preX);
        double error = lagrange.error(preX);
        System.out.println("estimated value:"+estimatedValue);
        System.out.println("exact value:"+exactValue);
        System.out.println("error value:"+error);
        System.out.println("Linear calculate result:");
        estimatedValue = linear.calculate(preX);
        error = linear.error(preX);
        System.out.println("estimated value:"+estimatedValue);
        System.out.println("exact value:"+exactValue);
        System.out.println("error value:"+error);
        System.out.println("Enter prediction x:");

        preX = scanner.nextDouble();
        estimatedValue = lagrange.calculate(preX);
        exactValue = new MyFunction().calculate(preX);
        error = lagrange.error(preX);
        System.out.println("estimated value:"+estimatedValue);
        System.out.println("exact value:"+exactValue);
        System.out.println("error value:"+error);
        System.out.println("Lagrange calculate result:");
        estimatedValue = lagrange.calculate(preX);
        exactValue = new MyFunction().calculate(preX);
        error = lagrange.error(preX);
        System.out.println("estimated value:"+estimatedValue);
        System.out.println("exact value:"+exactValue);
        System.out.println("error value:"+error);
        System.out.println("Linear calculate result:");
        estimatedValue = linear.calculate(preX);
        error = linear.error(preX);
        System.out.println("estimated value:"+estimatedValue);
        System.out.println("exact value:"+exactValue);
        System.out.println("error value:"+error);
    }

    public static void problem2(){
        System.out.println("Enter the number of data points:");
        int numberOfPoint = scanner.nextInt();
        double[] xi = new double[numberOfPoint];
        double[] yi = new double[numberOfPoint];
        System.out.println("Enter the value for each point:");
        for (int i = 0; i < numberOfPoint; i++) {
            xi[i] = scanner.nextDouble();
            yi[i] = scanner.nextDouble();
        }
        System.out.println("Enter prediction x:");
        double preX = scanner.nextDouble();
        Lagrange lagrange = new Lagrange(1, 3, null, 0);
        double calculateLagrange = lagrange.calculate(preX, xi, yi);
        Newton newton = new Newton();
        double calculateNewton = newton.calculate(preX, xi, yi);
        System.out.println("Lagrange calculate result:"+calculateLagrange);
        System.out.println("Newton calculate result:"+calculateNewton);
        lagrange.printExpression(xi,yi);
    }

    public static void problem3(){
        double[] xi = {1,2};
        double[] yi = {1,9};
        double[] yi_1 = {4,12};
        System.out.println("Enter prediction x:");
        double preX = scanner.nextDouble();
        double result = Hermite.hermite(xi, yi, yi_1, preX);
        Hermite.printExpression(xi,yi,yi_1);
        System.out.println("The result:"+result);
    }
}
