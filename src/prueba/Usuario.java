package prueba;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Usuario {
    static Scanner sc = new Scanner(System.in);
    //atributos
    static String id = null, nombre, correo, contra, idConfirm, contraConfirm;
    static boolean frecuente, casual;
    static double balance = 0, recarga;
    static int typeTrip;

    public static void main(String[] args) {
        Menu();
    }

    public static void Registrar() {
        System.out.println("ingrese su id: ");
        id = sc.next();
        System.out.println("ingrese su nombre:");
        nombre = sc.next();
        System.out.println("ingrese su correo:");
        correo = sc.next();
        System.out.println("ingrese contraseña:");
        contra = sc.next();

    }

    public static void iniciarSesion() {

        System.out.println("ingrese su id:");
        idConfirm = sc.next();
        System.out.println("ingrese contraseña:");
        contraConfirm = sc.next();
        if(idConfirm.equals(id) || contraConfirm.equals(contra)){
            System.out.println("id o contraseña incorreta");
        }else if (idConfirm.equals(id) && contraConfirm.equals(contra)) {
            frecuente = true;
            String answer;
            do {
                System.out.println("Bienvenido " + nombre);
                System.out.println("tu saldo es: " + balance);
                System.out.println("1- Recargar " + "\n" + "2- viajar");
                System.out.println("ingrese una opcion: ");
                int op = sc.nextInt();
                switch (op) {
                    case 1:
                        Recargar();
                        break;
                    case 2:
                        Viajar();
                        break;
                    default:
                            System.out.println("ingrese una opcion valida");
                }
                System.out.println("Quieres recargar o viajar? s/n");
                answer = sc.next();
            } while (answer.equals("s"));

        } else {
            casual = true;
            System.out.println("no estas registrado");
            System.out.println("!REGISTRATE¡");
        }
    }

    public static void Recargar() {
        System.out.println("Ingrese el valor a recargar: ");
        recarga = sc.nextDouble();
        balance = balance + recarga;
    }

    public static void Viajar() {
        if (balance > 3500) {
            System.out.println("tipo de viaje---");
            System.out.println("1- tranvia" + "\n" + "2- bus" + "\n" + "3- metrocable" + "\n" + "4- integrado");
            typeTrip = sc.nextInt();
            switch (typeTrip) {
                case 1:
                case 3:
                    System.out.println("no pagas valor adicional"+ "\n" + "valor del pasaje: 3600$" + "\n" + "saldo: " + balance);
                    break;
                case 2:
                    balance = balance - 3800;
                    System.out.println("valor adicional: 200$" + "\n" + "valor del pasaje: 3600$" + "\n" + "saldo: " + balance);
                    break;
                case 4:
                    balance = balance - 4100;
                    System.out.println("valor adicional: 500$" + "\n" + "valor del pasaje: 3600$" + "\n" + "saldo: " + balance);
                    break;
                default:
                    System.out.println("seleccione una opcion valida");
            }
        } else if (balance < 3600 && balance >= 0) {
            balance = balance - 3600;
            System.out.println("saldo: " + balance);
            System.out.println("te prestamos un pasaje");
        } else {
            System.out.println("no tienes saldo y debes un pasaje, debes recargar");
        }

    }

    public static void Menu() {
        String volver;
        do {
            System.out.println("Sistema metreo----");
            System.out.println("1- Resgistrar" + "\n" + "2- Iniciar sesion");
            System.out.println("ingrese una opcion: ");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    Registrar();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                default:
                    System.out.println("seleccione una opcion valida");
            }
            System.out.println("desea volver al sistema? s/n");
            volver = sc.next();
        } while (volver.equals("s"));

    }
}
