package experiment1;

/**
 * ClassName: MyFunction <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/11 0011
 * @since JDK 11
 */
public class MyFunction implements Function{
    @Override
    public double calculate(double x) {

        return 1.0 / (1 + x*x);
    }
}
