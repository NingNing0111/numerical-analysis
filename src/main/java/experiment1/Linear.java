package experiment1;

/**
 * ClassName: Linear <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/11 0011
 * @since JDK 11
 */
public class Linear {
    private final int numOfNode;
    private final double start;
    private final double length;
    private final Function function;

    public Linear(double length,int n,Function function,double start){
        this.numOfNode = n + 1;
        this.start = start;
        this.length = length;
        this.function = function;
    }

    public double calculate(double x){
        int j = findIndex(x);
        double[] xi = getXi();
        double result = function.calculate(xi[j]) * (x - xi[j+1]) / (xi[j] - xi[j+1]) + function.calculate(xi[j+1]) * (x-xi[j]) / (xi[j+1] -xi[j]);
        return result;
    }

    public double[] getXi(){
        double[] xi = new double[numOfNode];
        xi[0] = start;
        for(int i=1;i<numOfNode;i++){
            xi[i] = xi[i-1] + length;
        }
        return xi;
    }

    public int findIndex(double x){
        int index = 0;
        double xi[] = getXi();
        if(x < xi[0]){
            return index;
        }
        if(x > xi[numOfNode - 1]){
            return numOfNode - 2;
        }
        for(index=1;index < numOfNode;index++){
            if(x <= xi[index]){
                index--;
                break;
            }
        }
        return index;
    }

    public double error(double x){
        return function.calculate(x) - calculate(x);
    }
}
