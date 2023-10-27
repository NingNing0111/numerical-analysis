package experiment1;

/**
 * ClassName: Lagrange <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/11 0011
 * @since JDK 11
 */
public class Lagrange {
    private final double length;

    private final int numOfNode;
    private final Function function;
    private final double start;
    public Lagrange(double length,int n,Function function,double start){
        this.length = length;
        this.function = function;
        this.numOfNode = n + 1;
        this.start = start;
    }

    public double[] getXi(){
        double[] xi = new double[numOfNode];
        xi[0] = start;
        for(int i = 1; i<numOfNode;i++){
            xi[i] = xi[i-1] + length;
        }
        return xi;
    }
    public double[] getYi(){
        double[] yi = new double[numOfNode];
        double[] xi = getXi();
        for(int i = 0;i < numOfNode; i++){
            yi[i] = function.calculate(xi[i]);
        }
        return yi;
    }

    public double getLi(double x,double[] xi, double[] yi){
        double result = 0;
        for(int k=0;k<xi.length;k++){
            double cur = yi[k];
            for(int j=0;j<xi.length;j++){
                if(k != j){
                    cur *= (x - xi[j]) / (xi[k] - xi[j]);
                }
            }
            result += cur;
        }
        return result;
    }

    public double calculate(double x){
        double[] xi = getXi();
        double[] yi = getYi();
        return getLi(x,xi,yi);
    }

    public double calculate(double x,double[] xi,double[] yi){
        return getLi(x,xi,yi);
    }

    public double error(double x){
        return function.calculate(x) - calculate(x);
    }

    public void printExpression(double[] xi,double[] yi) {
        StringBuilder expression = new StringBuilder("p(x) = ");

        for (int k = 0; k < xi.length; k++) {
            double coefficient = yi[k];
            StringBuilder term = new StringBuilder();
            double curr = 1;
            // 构建每一项的表达式
            for (int j = 0; j < xi.length; j++) {
                if (k != j) {
                    if (xi[j] < 0) {
                        term.append("*(x + ").append(-xi[j]).append(")");
                    } else {
                        term.append("*(x - ").append(xi[j]).append(")");
                    }
                    curr = curr * (xi[k]-xi[j]);
                }
            }
            coefficient /= curr;

            // 拼接每一项的表达式
            if (coefficient < 0) {
                expression.append(" - ").append(-coefficient).append(term);
            } else {
                if (k == 0){
                    expression.append(coefficient).append(term);
                }else{
                    expression.append(" + ").append(coefficient).append(term);
                }

            }
        }

        System.out.println(expression.toString());
    }

}
