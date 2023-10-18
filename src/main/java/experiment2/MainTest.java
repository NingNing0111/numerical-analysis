package experiment2;

import org.junit.Test;

import java.util.Scanner;

/**
 * ClassName: MainTest <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/18 0018
 * @since JDK 11
 */
public class MainTest {
    private Scanner scanner;
    @Test
    public void mainTest(){
        scanner = new Scanner(System.in);
        System.out.println("[1] Function one: f(x) = Math.exp(x) * x / Math.pow(1 + x, 2)");
        System.out.println("Choose your function:");
        int functionChoose = scanner.nextInt();
        Function function = null;
        if (functionChoose == 1){
            function = new ProblemFunction();
        }else {
            System.out.println("Error!");
            return;
        }
        System.out.println("Enter interval:");
        double init = scanner.nextDouble();
        double fina = scanner.nextDouble();
        double[] interval = {init,fina};
        System.out.println("Problem One:");
        problemOne(interval,function);
        System.out.println("Problem Two:");
        problemTwo(interval,function);
        System.out.println("Problem Three");
        problemThree(interval,function);
    }

    private void problemOne(double[] interval,Function function){
        System.out.println("Enter error limit:");
        double errorLimit = scanner.nextDouble();
        CompoundTrapezoid compoundTrapezoid = new CompoundTrapezoid(interval, errorLimit, function);
        compoundTrapezoid.calculateByError();
        System.out.println("区间等分数："+compoundTrapezoid.getN());
        System.out.println("区间近似结果："+compoundTrapezoid.getResult());
    }

    private void problemTwo(double[] interval,Function function){
        System.out.println("Enter error limit:");
        double errorLimit = scanner.nextDouble();
        CompositeSimpson compositeSimpson = new CompositeSimpson(interval, errorLimit, function);
        compositeSimpson.calculateByError();
        System.out.println("区间等分数："+compositeSimpson.getN());
        System.out.println("区间近似结果："+compositeSimpson.getResult());
    }

    private void problemThree(double[] interval,Function function){
        System.out.println("Enter n:");
        int n = scanner.nextInt();
        Romberg romberg = new Romberg(interval, function, n);
        romberg.calculateByN();
        System.out.println("积分近似值: " + romberg.getResult());
    }

}
