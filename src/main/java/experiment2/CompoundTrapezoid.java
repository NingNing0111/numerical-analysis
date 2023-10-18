package experiment2;

/**
 * ClassName: CompoundTrapezoid <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/18 0018
 * @since JDK 11
 */
public class CompoundTrapezoid extends CompositeBase{


    public CompoundTrapezoid(double[] interval, double errorLimit, Function function) {
        super(interval, errorLimit, function);
    }

    @Override
    public double compoundCalculate(double a, double b, double n) {
        double h = (b-a) / n;
        double sum = 0.5 * (getFunction().calculate(a) + getFunction().calculate(b));
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += getFunction().calculate(x);
        }
        return h * sum;
    }




}
