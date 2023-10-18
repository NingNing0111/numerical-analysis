package experiment2;

/**
 * ClassName: CompositeSimpson <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/18 0018
 * @since JDK 11
 */
public class CompositeSimpson extends CompositeBase{


    public CompositeSimpson(double[] interval, double errorLimit, Function function) {
        super(interval, errorLimit, function);
    }

    @Override
    public double compoundCalculate(double a, double b, double n) {
        double h = (b - a) / n;
        double sum = getFunction().calculate(a) + getFunction().calculate(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 2 == 0) {
                sum += 2 * getFunction().calculate(x);
            } else {
                sum += 4 * getFunction().calculate(x);
            }
        }

        return (h / 3) * sum;
    }
}
