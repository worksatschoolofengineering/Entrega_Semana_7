/*
 * 2. Contraseña segura
 * Una contraseña se considera segura si su longitud es mayor o igual a 10, tiene al menos una
 * letra (A-Z, a-z), tiene al menos un dígito (0-9), y tiene al menos un símbolo diferente a letras
 * o dígitos.
 * Escriba un programa que reciba como entrada una cadena y decida si esta corresponde a una
 * contraseña segura.
 */
import java.util.Scanner;

public class password {

    public static void main(String[] args) {
        // Definimos los caracteres que deberia incluir una contraseña segura
        String strMayusculas = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String strMinusculas = "abcdefgehijlkmnñoprstuvwxyz";
        String strNumeros = "1234567890";
        String strSimbolos = "@#!$€&^-+.,[]()|/*<-.'";       
        String password = "";
        int mayusculas, minusculas, numeros, simbolos, longitud, validacion;

        Scanner input = new Scanner(System.in);
        // Input para los valores de entrada
        System.out.print("Introduce una contraseña: ");
        password = input.nextLine();
        // Llama al metodo de validar y le pasa los parametros
        mayusculas = validar(password, strMayusculas);
        minusculas = validar(password, strMinusculas);
        numeros = validar(password, strNumeros);
        simbolos = validar(password, strSimbolos);
        // llama al metodo de validar la longitud y le pasamos el parametro que ingresamos por teclado
        longitud = validarLongitud(password);
        // Guarda en una variable la suma de los caracteres introducidos
        validacion = mayusculas + minusculas + numeros +
                simbolos + longitud;
        String print = printResult(validacion);
        System.out.println(print);
    }
        // Metodo de validacion de compatibilidad de caracteres
    public static int validar(String cadena, String alfabeto) {
        char[] caracteres = cadena.toCharArray();
        int totalCaracteres = caracteres.length;
        int contar = 0;
        for (int i = 0; i < totalCaracteres; i++) {
            String c = String.valueOf(caracteres[i]);
            if (String.valueOf(alfabeto).contains(c)) {
                contar++;
                break;
            }
        }
        return contar;
    }
    // Metodo de validar Longitud: validamos si la longitud de la contraseña es segura
    public static int validarLongitud(String cadena) {
        char[] caracteres = cadena.toCharArray();
        int totalCaracteres = caracteres.length;
        int contar = 0;
        if (totalCaracteres >= 10)
            contar = 1;
        return contar;
    }
    // Metodo verifica si la contraseña es correcta o no y retorna un mensaje dependiendo de su condicion
    public static String printResult(int validacion) {
        if (validacion == 5) {
            return "Es una contraseña segura ";
        } else {
            return "No es una contraseña segura ";
        }
    }
}