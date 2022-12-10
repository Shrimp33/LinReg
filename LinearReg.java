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
    private int mini(double[] arr)
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
        return index;
    }
    private int maxi(double[] arr)
    {
        double max = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }
    // Contructor
    public LinearReg(double[] datax, double[] datay)
    {
        this.datax = datax;
        this.datay = datay;
        // Set training params
        m = (datay[maxi(datax)] - datay[mini(datax)]) / (maxi(datax) - mini(datax));
        b = datay[mini(datax)];
        varm = 10;
        varb = 10;
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
        return Math.pow(err / datax.length, 2);  // Squared
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
        if (Math.min(scores[1], scores[7]) > scores[4])
            varm *= .9;
        if (Math.min(scores[3], scores[5]) > scores[4])
            varb *= .9;
        int best = mini(scores);
        this.m += varm * (best / 3 - 1);
        this.b += varb * (best % 3 - 1);
        this.varm = varm;
        this.varb = varb;
        this.fitness = scores[best];
    }
    public void train(int Epochs)
    {
        System.out.println("Training LinReg For " + Epochs + " Epochs");
        for (int i = 1; i <= Epochs; i++)
        {
            fit(m, b, varm, varb);
            System.out.println("Epoch " + Epochs + ": fitness-" + 1/fitness + " equation- y= " + m + "x + " + b);
        }
        System.out.println("Final Fitness: " + 1/fitness + " equation- y= " + m + "x + " + b);
        System.out.println("Done");
    }
}