public class LinearReg
{
    // Solves an equation in the form of y = mx + b
    private double m;
    private double b;
    private double varm;
    private double varb;
    private double fitness;
    private double[] datax;
    private double[] datay;
    // Helper Get Min of Arr
    private mini(double[] arr)
    {
        double min = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] < min)
            {
                min = arr[i];
                index = i;
            }
        }
        return i;
    }
    // Contructor
    public LinearReg(double[] datax, double[] datay)
    {
        this.datax = datax;
        this.datay = datay;
        // Set training params
        // I'm just gonna set everything to 69
        m = 69;
        b = 69;
        varm = 69;
        varb = 69;
    }
    // Exam for ML
    private double score(double m, double b)
    {
        double err = 0;
        // equation y = mx + b
        for (int i = 0; i < datax.length; i++)
        {
            double pred = datax[i] * m + b;
            err += datay[i] - pred;
        }
        return Math.pow(err / datax.length, -2);  // Reciprocal Squared
    }
    // Coeffienct Generater
    // Resursion go brr
    private void fit(double m, double b, double varm, double varb)
    {
        double[] scores = new double[9];  // Maping just for ease
        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                scores[(i+1)*3+(j+1)] = score(m + varm * i, b + varb * j);
            }   
        }
        if (Math.min(score[1], score[7]) > score[4])
            varm /= 2;
        if (Math.min(score[3], score[5]) > score[4])
            varb /= 2;
        int best = mini(score);
        this.m += varm * (best / 3 - 1);
        this.b += varb * (best % 3 - 1);
        this.varm = varm;
        this.varb = varb;
        this.fitness = score[best];
    }
    public void train(int Epochs)
    {
        System.out.println("Training LinReg For " + Epochs + " Epochs");
        for (int i = 1; i <= Epochs; i++)
        {
            fit(m, b, vram, varb);
            System.out.println("Epoch " + Epochs ": fitness-" + fitness + " equation- y= " + m + "x + " + b);
        }
        System.out.println("Final Fitness: " + fitness + " equation- y= " + m + "x + " + b);
        System.out.println("Done");
    }
}