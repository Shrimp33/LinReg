public class Main {
    public static void main(String args[]) // WHY DOES JAVA FORCE YOU TO DO THIS
    {
        // Get random offsets off of y = x
        double[] datax = new double [500];  // 500 datas points bc why not
        double[] datay = new double [500];
        // Add some noise
        double noise = 3;
        // Set tester equation
        double m = 6;
        double b = 9;
        for (int i = 0; i < 500; i++)
        {
            datax[i] = (Math.random() - .5) * noise + i ;
            datay[i] = (Math.random() - .5) * noise + i * m + b ;
        }
        // Test. // Partent equation is y = x
        LinearReg linreg = new LinearReg(datax, datay);
        linreg.train(100);
    }
}