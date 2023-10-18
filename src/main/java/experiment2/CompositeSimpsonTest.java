package experiment2;

import org.junit.Test;

/**
 * ClassName: CompositeSimpsonTest <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/18 0018
 * @since JDK 11
 */
public class CompositeSimpsonTest {
    @Test
    public void compositeSimpsonTest(){
        double[] interval = {0,1};
        CompositeSimpson compositeSimpson = new CompositeSimpson(interval, Math.pow(10, -5), new ProblemFunction());
        compositeSimpson.calculateByError();
        System.out.println(compositeSimpson.getResult());
        System.out.println(compositeSimpson.getN());
    }
}
