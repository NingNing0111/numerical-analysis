package experiment1;

/**
 * ClassName: Hermite <br/>
 *
 * @author Ning <br/>
 * @date 2023/10/11 0011
 * @since JDK 11
 */
public class Hermite {
    public static double hermite(double[] x, double[] y, double[] y_1, double x0) {
        int n = x.length;
        if (n != y.length || n != y_1.length) {
            System.out.println("x, y, y_1 dimensions are not equal!");
            return 0.0;
        }

        double f = 0.0;
        for (int i = 0; i < n; i++) {
            double h = 1.0;
            double a = 0.0;

            // 计算hi和ai
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    h *= Math.pow(x0 - x[j], 2) / Math.pow(x[i] - x[j], 2);
                    a += 1 / (x[i] - x[j]);
                }
            }

            f += h * ((x[i] - x0) * (2 * a * y[i] - y_1[i]) + y[i]);
        }

        return f;
    }

    public static void printExpression(double[] x, double[] y, double[] y_1) {
        int n = x.length;
        if (n != y.length || n != y_1.length) {
            System.out.println("x, y, y_1 dimensions are not equal!");
            return;
        }

        StringBuilder expression = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringBuilder term = new StringBuilder();
            double a = 0.0;

            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term.append("(t - ").append(x[j]).append(")^2 / (").append(x[i] - x[j]).append(")^2 * ");
                    a += 1 / (x[i] - x[j]);
                }
            }

            term.append("((").append(x[i]).append(" - t) * (2 * ").append(a).append(" * ").append(y[i]).append(" - ").append(y_1[i]).append(") + ").append(y[i]).append(")");

            if (i != n - 1) {
                term.append(" + ");
            }

            expression.append(term);
        }

        System.out.println("Hermite Interpolation Expression: f(t) = " + expression);
    }

}
