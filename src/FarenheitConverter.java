public abstract class FarenheitConverter extends Converter {


    protected static double convert(double temp){
        //By formula, F = C × (9/5) + 32
        return ((double) 9 / 5) * temp + 32;
    }

    protected static double convertToCelsius(double temp) {
        //By formula, C = (F – 32) × (5/9)
        return (temp - 32) * ((double) 5 / 9);
    }
}
