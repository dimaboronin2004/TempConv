public abstract class DelisleConverter extends Converter {

    protected static double convert(double temp){
        //By formula, De = (100 - C) × (3/2)
        return (100 - temp) * ((double) 3 / 2);
    }

    protected static double convertToCelsius(double temp){
        //By formula, C = 100 - De × (2/3)
        return 100 - temp * ((double) 2 / 3);
    }
}
