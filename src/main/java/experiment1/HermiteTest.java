package experiment1;

import org.junit.Test;

/**
 * ClassName: HermiteTest <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/11 0011
 * @since JDK 11
 */
public class HermiteTest {
    @Test
    public void hermiteTest(){
        double[] xi = {1,2};
        double[] yi = {1,9};
        double[] x_1 = {4,12};
        double hermite = Hermite.hermite(xi, yi, x_1, 1.65);
        System.out.println(hermite);
    }
    @Test
    public void printTest(){
        double[] xi = {1,2};
        double[] yi = {1,9};
        double[] y_1 = {4,12};
        Hermite.printExpression(xi,yi,y_1);
    }
    @Test
    public void expressionTest(){
        double t = 1.65;
        double res = (t - 2.0)*(t - 2.0) / (-1.0)*(-1) * ((1.0 - t) * (2 * -1.0 * 1.0 - 4.0) + 1.0) + (t - 1.0)*(t - 1.0) / (1.0)*(1.0) * ((2.0 - t) * (2 * 1.0 * 9.0 - 12.0) + 9.0);
        System.out.println(res);
    }
}
