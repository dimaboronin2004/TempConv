public abstract class RomerConverter extends Converter{

    protected static double convert(double temp){
        //By formula, Ro = C × (21/40) + 7.5
        return temp * ((double) 21 / 40)  + 7.5;
    }

    protected static double convertToCelsius(double temp){
        //By formula, C = (Ro - 7.5) * (40/21)
        return (temp - 7.5) * ((double) 40 / 21);
    }
}
