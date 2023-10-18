package experiment1;

/**
 * ClassName: Newton <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/11 0011
 * @since JDK 11
 */
public class Newton {
    public double calculate(double x,double[] xi, double[] yi){
        double res = 0;
        double[][] li = new double[xi.length][xi.length];
        double[] g = new double[xi.length];
        for(int i=0;i<xi.length;i++) {
            li[i][0] = yi[i];
        }
        for(int j=1;j<xi.length;j++){
            for(int i=j;i<xi.length;i++){
                li[i][j] = (li[i][j-1] - li[i-1][j-1]) / (xi[i] - xi[i-j]);
            }
        }
        for(int i=0;i<xi.length;i++) {
            g[i] = 1.0;
        }
        for(int i=0;i<xi.length;i++){
            for(int j=0;j<i;j++){
                g[i] *= (x - xi[j]);
            }
            res += g[i] * li[i][i];
        }
        return res;
    }
}
