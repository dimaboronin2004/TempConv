public abstract class ReaumurConverter extends Converter{

    protected static double convert(double temp){
        //By formula, Re = C × (4/5)
        return temp * ((double) 4 / 5);
    }

    protected static double convertToCelsius(double temp){
        //By formula, C = Re × (5/4)
        return temp * ((double) 5 / 4);
    }
}
