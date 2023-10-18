package experiment1;

import org.junit.Test;

/**
 * ClassName: NewtonTest <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/11 0011
 * @since JDK 11
 */
public class NewtonTest {
    @Test
    public void calculateTest(){
        Newton newton = new Newton();
        double[] xi = {0,1,2,3};
        double[] yi = {-7,-4,5,26};
        double calculate = newton.calculate(1.65, xi, yi);
        System.out.println(calculate);
    }
}
