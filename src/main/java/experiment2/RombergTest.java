package experiment2;

import org.junit.Test;

/**
 * ClassName: RombergTest <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/18 0018
 * @since JDK 11
 */
public class RombergTest {
    @Test
    public void rombergTest(){
        double[] interval = {0,1};
        Romberg romberg = new Romberg(interval, new ProblemFunction(), 8);
        romberg.calculateByN();
        System.out.println(romberg.getResult());
    }
}
