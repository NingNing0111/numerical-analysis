package experiment2;

import org.junit.Test;

/**
 * ClassName: CompoundTrapezoidTest <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/18 0018
 * @since JDK 11
 */

public class CompoundTrapezoidTest {
    @Test
    public void compoundTrapezoidTest(){
        double[] interval = {0,1};
        CompoundTrapezoid compoundTrapezoid = new CompoundTrapezoid(interval, Math.pow(10, -5), new ProblemFunction());
        compoundTrapezoid.calculateByError();
        System.out.println(compoundTrapezoid.getResult());
        System.out.println(compoundTrapezoid.getN());
    }
}
