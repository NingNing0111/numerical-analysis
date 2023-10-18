package experiment2;

/**
 * ClassName: CompositeBase <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/18 0018
 * @since JDK 11
 */
public abstract class CompositeBase {
    private double[] interval;
    private double errorLimit;
    private Function function;
    private int n;

    private double result;

    public Function getFunction(){
        return function;
    }

    public double getResult(){
        return result;
    }

    public int getN(){
        return n;
    }

    public CompositeBase(double[] interval,double errorLimit,Function function){
        this.interval = interval;
        this.errorLimit = errorLimit;
        this.function = function;
    }

    public CompositeBase(double[] interval,Function function,int n){
        this.interval = interval;
        this.function = function;
        this.n = n;
    }
    public abstract double compoundCalculate(double a,double b,double n);

    public void calculateByError(){
        n = 1;
        double a = interval[0];
        double b = interval[1];

        double curResult = compoundCalculate(a,b,n);
        double preResult = 0;
        do {
            preResult = curResult;
            n *=2 ;
            curResult = compoundCalculate(a,b,n);
        }while (Math.abs(preResult - curResult) >= errorLimit);
        result = curResult;
    }

    public void calculateByN(){
        double a = interval[0];
        double b = interval[1];
        result = compoundCalculate(a,b,n);
    }

}
