package experiment1;

import org.junit.Before;
import org.junit.Test;

/**
 * ClassName: LinearTest <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/11 0011
 * @since JDK 11
 */
public class LinearTest {

    private Linear linear;
    @Before
    public void init(){
        linear = new Linear(1, 10, new MyFunction(),  -5);
    }
    @Test
    public void getXiTest(){
        double[] xi = linear.getXi();
        for (double v : xi) {
            System.out.println(v);
        }
    }

    @Test
    public void calculateTest(){
        double calculate = linear.calculate(4.5);
        System.out.println(calculate);
    }
    @Test
    public void errTest(){
        double error = linear.error(4.5);
        System.out.println(error);
    }
}
