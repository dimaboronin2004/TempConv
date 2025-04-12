public abstract class KelvinConverter extends Converter {

    protected static double convert(double temp){
        //By formula, K = C + 273,15
        return temp + 273.15;
    }

    protected static double convertToCelsius(double temp){
        //By formula, C = K + 273,15
        return temp - 273.15;
    }
}
