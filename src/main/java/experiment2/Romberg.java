package experiment2;

/**
 * ClassName: Romberg <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/18 0018
 * @since JDK 11
 */
public class Romberg extends CompositeBase{

    public Romberg(double[] interval, Function function, int n) {
        super(interval, function, n);
    }

    @Override
    public double compoundCalculate(double a, double b, double n) {
        int maxIterations = (int) (Math.log(n) / Math.log(2)) + 1;
        double[] s = new double[maxIterations];

        double var = 0;
        double lastVal = Double.NEGATIVE_INFINITY;

        for (int k = 1;k < maxIterations;k++){
            for(int i=1;i <= k;i++){
                if (i == 1){
                    var = s[i];
                    s[i] = trapz(a,b,(int)Math.pow(2,k-1));
                }else{
                    s[k] = (Math.pow(4,i-1) * s[i-1] - var) / (Math.pow(4,i-1) - 1);
                    var = s[i];
                    s[i] = s[k];
                }
            }
            if(Math.abs(lastVal - s[k]) < 1e-10){
                return s[k];
            }else{
                lastVal = s[k];
            }
        }
        return s[maxIterations-1];

    }

    private double trapz(double a,double b,int N){
        if(a == b){
            return 0;
        }
        double sum = 0;
        for(int k=1;k<N;k++){
            sum += getFunction().calculate(a + k * (b-a) / N);
        }
        sum += (getFunction().calculate(a) + getFunction().calculate(b) ) / 2;
        return (b-a) / N * sum;
    }
}
