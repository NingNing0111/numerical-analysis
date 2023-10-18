package experiment1;

import org.junit.Before;
import org.junit.Test;

/**
 * ClassName: LagrangeTest <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/11 0011
 * @since JDK 11
 */
public class LagrangeTest {
    private Lagrange lagrange;
    @Before
    public void init(){
        lagrange = new Lagrange(1, 10, new MyFunction(),  -5);
    }
    @Test
    public void getXiTest(){
        double[] xi = lagrange.getXi();
        for(double i:xi){
            System.out.println(i);
        }
    }
    @Test
    public void getYiTest(){
        double[] yi = lagrange.getYi();
        for (double v : yi) {
            System.out.println(v);
        }
    }
    @Test
    public void getResultTest(){
        double result1 = lagrange.calculate(4.5);
        double result2 = lagrange.calculate(0.5);
        System.out.println("4.5:"+result1);
        System.out.println("0.5:"+result2);

        double error_result1 = lagrange.error(4.5);
        double error_result2 = lagrange.error(0.5);
        System.out.println(error_result1);
        System.out.println(error_result2);
    }

    @Test
    public void calculateTest(){
        double[] xi = {0,1,2,3};
        double[] yi = {-7,-4,5,26};
        double calculate = lagrange.calculate(1.65, xi, yi);
        System.out.println(calculate);
    }

    @Test
    public void printTest(){
        double[] xi = {0,1,2,3};
        double[] yi = {-7,-4,5,26};
        lagrange.printExpression(xi,yi);
    }

    @Test
    public void expressionTest(){
        double x = 1.65;
        double result = 1.1666666666666667*(x - 1.0)*(x - 2.0)*(x - 3.0) - 2.0*(x - 0.0)*(x - 2.0)*(x - 3.0) - 2.5*(x - 0.0)*(x - 1.0)*(x - 3.0) + 4.333333333333333*(x - 0.0)*(x - 1.0)*(x - 2.0);
        System.out.println(result);
    }
}
