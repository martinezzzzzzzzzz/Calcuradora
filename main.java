import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Seleccione una categoría de conversión:");
            System.out.println("1. Longitud");
            System.out.println("2. Masa");
            System.out.println("3. Temperatura");
            System.out.println("4. Volumen");
            System.out.println("0. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convertirLongitud(scanner);
                    break;
                case 2:
                    convertirMasa(scanner);
                    break;
                case 3:
                    convertirTemperatura(scanner);
                    break;
                case 4:
                    convertirVolumen(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void convertirLongitud(Scanner scanner) {
        System.out.println("Seleccione la unidad de origen:");
        System.out.println("1. Metros");
        System.out.println("2. Centímetros");
        System.out.println("3. Kilómetros");
        System.out.println("4. Pulgadas");
        System.out.println("5. Pies");
        System.out.println("6. Yardas");
        int origen = scanner.nextInt();
        
        System.out.println("Seleccione la unidad de destino:");
        int destino = scanner.nextInt();

        System.out.println("Ingrese el valor a convertir:");
        double valor = scanner.nextDouble();

        double resultado = convertirLongitud(origen, destino, valor);
        System.out.println("El valor convertido es: " + resultado);
    }

    private static double convertirLongitud(int origen, int destino, double valor) {
        
        double[] conversionRates = {1.0, 100.0, 0.001, 39.3701, 3.28084, 1.09361};
        return valor * conversionRates[destino - 1] / conversionRates[origen - 1];
    }

    private static void convertirMasa(Scanner scanner) {
        System.out.println("Seleccione la unidad de origen:");
        System.out.println("1. Gramos");
        System.out.println("2. Kilogramos");
        System.out.println("3. Libras");
        System.out.println("4. Onzas");
        System.out.println("5. Toneladas");
        int origen = scanner.nextInt();
        
        System.out.println("Seleccione la unidad de destino:");
        int destino = scanner.nextInt();

        System.out.println("Ingrese el valor a convertir:");
        double valor = scanner.nextDouble();

        double resultado = convertirMasa(origen, destino, valor);
        System.out.println("El valor convertido es: " + resultado);
    }

    private static double convertirMasa(int origen, int destino, double valor) {
        double[] conversionRates = {1.0, 0.001, 0.00220462, 0.035274, 1e-6};
        return valor * conversionRates[destino - 1] / conversionRates[origen - 1];
    }

    private static void convertirTemperatura(Scanner scanner) {
        System.out.println("Seleccione la unidad de origen:");
        System.out.println("1. Grados Celsius");
        System.out.println("2. Grados Fahrenheit");
        System.out.println("3. Kelvin");
        System.out.println("4. Rankine");
        int origen = scanner.nextInt();
        
        System.out.println("Seleccione la unidad de destino:");
        int destino = scanner.nextInt();

        System.out.println("Ingrese el valor a convertir:");
        double valor = scanner.nextDouble();

        double resultado = convertirTemperatura(origen, destino, valor);
        System.out.println("El valor convertido es: " + resultado);
    }

    private static double convertirTemperatura(int origen, int destino, double valor) {
        double celsius = switch (origen) {
            case 1 -> valor;
            case 2 -> (valor - 32) * 5 / 9;
            case 3 -> valor - 273.15;
            case 4 -> (valor - 491.67) * 5 / 9;
            default -> 0;
        };
        
        return switch (destino) {
            case 1 -> celsius;
            case 2 -> celsius * 9 / 5 + 32;
            case 3 -> celsius + 273.15;
            case 4 -> (celsius + 273.15) * 9 / 5;
            default -> 0;
        };
    }

    private static void convertirVolumen(Scanner scanner) {
        System.out.println("Seleccione la unidad de origen:");
        System.out.println("1. Litros");
        System.out.println("2. Mililitros");
        System.out.println("3. Galones");
        System.out.println("4. Onzas líquidas");
        int origen = scanner.nextInt();
        
        System.out.println("Seleccione la unidad de destino:");
        int destino = scanner.nextInt();

        System.out.println("Ingrese el valor a convertir:");
        double valor = scanner.nextDouble();

        double resultado = convertirVolumen(origen, destino, valor);
        System.out.println("El valor convertido es: " + resultado);
    }

    private static double convertirVolumen(int origen, int destino, double valor) {
        double[] conversionRates = {1.0, 1000.0, 0.264172, 33.814};
        return valor * conversionRates[destino - 1] / conversionRates[origen - 1];
    }
}