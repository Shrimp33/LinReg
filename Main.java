public class Main {
    public static main()
    {
        // Get random offsets off of y = x
        double[] datax = new double [500];  // 500 datas points bc why not
        double[] datay = new double [500];
        // Add some noise
        for (int i = 0; i < 500; i++)
        {
            datax[i] = Math.random + i - 1;
            datay[i] = Math.random + i - 1;
        }
        // Test. // Partent equation is y = x
        LinearReg linreg = new LinearReg(100);
        linreg.train(100);
    }
}