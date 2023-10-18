package experiment2;

/**
 * ClassName: ProblemFunction <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/18 0018
 * @since JDK 11
 */
public class ProblemFunction implements Function{
    @Override
    public double calculate(double x) {
        return Math.exp(x) * x / Math.pow(1 + x, 2);
    }
}
