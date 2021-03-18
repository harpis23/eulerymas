package programa.euler.y.más;

import java.util.Scanner;                                                      //Elaborado por: 

public class ProgramaEulerYMás {                                               //Jesús Abraham Canul Couoh
                                                                               //Evan Jazheel Ku Canche 
    public static void main(String[] args) {                                   //Fernando Javier Noh Requena                                             
        Scanner teclado = new Scanner(System.in);
        Scanner kb = new Scanner(System.in);

        int opciones, sucesiones, termino, otra; //Atributos de la clase
        boolean salir = false;
        double a1, b1, c1, x1, x2, raiz = 0, valora, valorb, valorc, real = 0, recep1 = 0;

        do {//inicio del ciclo 
            try { //Inicio de búsqueda de errores 
                System.out.println("Bienvenido al menú de cálculos, seleccione la opción que desee realizar ");//menú de opciones 
                System.out.println("1.Euler elevado a la X");
                System.out.println("2.Euler elevado a la -X");
                System.out.println("3.Varianza de los primeros 1500");
                System.out.println("");
                System.out.println("Métodos para cálcular ecuaciones cuadráticas:");
                System.out.println("4.Fórmula General, 5. Fórmula general inversa, 6.Racionalización");
                opciones = teclado.nextInt();

                switch (opciones) {

                    case 1://Euler elevado a X

                        System.out.println("Introduzca el valor de X"); //Datos 
                        termino = teclado.nextInt();
                        System.out.println("Introduzca el número de sucesiones (n)");
                        sucesiones = teclado.nextInt();

                        //Operaciones 
                        double valor = 0;
                        for (int i = 0; i < sucesiones + 1; i++) {
                            factorial fact11 = new factorial(i);//creación del objeto de la clase factorial

                            valor = valor + Math.pow(sucesiones, i) / fact11.Factorial(i);//Envio de datos 
                            real = fact11.aux;//Recepción de datos 

                        }

                        System.out.println("El resultado de Euler elevado a X es " + real);//Impresión del resultado

                        break;

                    case 2://Euler elevado a -X

                        System.out.println("Usando Euler ^-x, e^-x=1/∑(n) (x^j/j!)/n "); //Datos
                        System.out.println("Introduzca x");
                        int x = teclado.nextInt();
                        System.out.println("Introduzca j ");
                        int j = teclado.nextInt();

                        //operaciones 
                        double suma = 0;
                        for (int i = 0; i < j + 1; i++) { //ciclo for 
                            suma = suma + 1 / (Math.pow(x, i) / (factorial(i)));
                        }

                        System.out.println("");
                        System.out.println("El resultado es : " + suma); //Impresión del resultado
                        break;

                    case 3://Varianza
                        System.out.println("Varianza de los primeros 1500 numeros");
                        double n = 1500;
                        double s = n * (n + 1) / 2; //suma de los elementos
                        double media = s / 1500; //media
                        double subT = 0;
                        double t = 0;
                        System.out.println(media + " es la media");
                        for (int i = 1; i <= 1500; i++) {
                            double p = Math.pow((i - media), 2);

                            subT = 0 + p; //subtotal
                            t += subT; //acumulador
                        }
                        double v = t / 1500; //varianza
                        System.out.println(v + " es la varianza");
                        break;

                    case 4://Fórmula general 

                        System.out.println("Resolver una ecuacion cuadratica  de la forma \n"
                                + "ax^2+bx+c \n"
                                + "Mediante la formula general\n");

                        System.out.println("Ingresa el valor de a");
                        a1 = kb.nextDouble();
                        System.out.println("Ingresa el valor de b");
                        b1 = kb.nextDouble();
                        System.out.println("Ingresa el valor de c");
                        c1 = kb.nextDouble();

                        raiz = (Math.pow(b1, 2) - 4 * a1 * c1); //Eliminar el radical

                        x1 = (-b1 + Math.sqrt(raiz)) / (2 * a1);//Obtener los resultados de las variables x1, x2
                        x2 = (-b1 - Math.sqrt(raiz)) / (2 * a1);

                        if (raiz < 0) {
                            System.out.println("Raiz negativa no hay solucion");//En caso de que la raiz sea imaginaria
                        } else {
                            System.out.println("\nLos resultados son"); //Impresión de los resultados 
                            System.out.println("x1= " + x1);
                            System.out.println("x2= " + x2);
                        }

                        break;

                    case 5:// Fórmula general inversa 
                        double a,
                         b,
                         c;
                        System.out.println("Ingresa el valor de x^2 ");//Datos
                        a = teclado.nextDouble();
                        System.out.println("Ingresa el valor de x ");
                        b = teclado.nextDouble();
                        System.out.println("Ingresa el valor de c ");
                        c = teclado.nextDouble();

                        System.out.println("Resolución con el método de formula general inversa");//impresión de datos
                        FormulaGeneralInversa(a, b, c); //Llamando a la clase FormulaGeneralInversa
                        break;

                    case 6://Racionalización 
                        System.out.println("Ingrese el valor de a");
                        valora = teclado.nextDouble();
                        System.out.println("ingrese el valor de b");
                        valorb = teclado.nextDouble();
                        System.out.println("Ingrese el valor de c");
                        valorc = teclado.nextDouble();
                        racionalización raz1 = new racionalización(valora, valorb, valorc);//Creación del objeto 
                        if (valora < 0) {
                            if (valorb < 0) {
                                if (valorc < 0) {
                                    System.out.println("La raiz es negativa, por lo que no hay solución");
                                }
                            }

                        } else {
                            System.out.println(raz1.Racionalización());//Llamando al método
                        }

                        break;
                }

            } catch (NumberFormatException k) {//fin de corrección de errores 

            }
            System.out.println(""); //Seguir o salir del programa 
            System.out.println("¿Desea realizar alguna otra operación? 1.Si, 2.No");
            otra = teclado.nextInt();

        } while (otra != 2);

    }

    public static boolean discriminante(double a, double b, double c) {//clase para formula general inversa
        double discriminante;
        discriminante = (Math.pow(b, 2)) - (4 * (a) * (c));
        if (discriminante < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int factorial(int numero) {//clase factorial 
        double factorial;
        if (numero == 0) {
            return 1;
        } else {
            return numero * factorial(numero - 1);
        }
    }

    public static void FormulaGeneralInversa(double a, double b, double c) {//método de fórmula general inversa
        if (discriminante(a, b, c) == true) {
            System.out.println("El problema no tiene solucion");
        } else {
            double x1 = (-2 * c) / (b + (Math.sqrt(Math.pow(b, 2) - (4 * a * c))));
            double x2 = (-2 * c) / (b - (Math.sqrt(Math.pow(b, 2) - (4 * a * c))));
            System.out.println("x1=" + x1);
            System.out.println("x2=" + x2);
        }

    }

}

class factorial { //Clase factorial para Euler elevado a la X

    double aux;

    factorial(double f) {
        aux = f;
    }

    double Factorial(int n) {

        for (int i = 1; i <= n; i++) {
            aux *= i;
        }
        return aux;
    }

}

class racionalización {//Clase para el método de racionalización 

    double cal1, cal12, cal21, cal22, Valora, ValorB, ValorC, recp2, op, calsu1, calsu2;

    racionalización(double j, double s, double w) {
        Valora = j;
        ValorB = s;
        ValorC = w;
    }

    double Racionalización() {//método de racionalización 
        cal1 = Math.pow(ValorB, 2) - (Math.pow(ValorB, 2) - (4 * (Valora) * (ValorC)));
        cal12 = 2 * (Valora) * ((-ValorB - (Math.sqrt(Math.pow(ValorB, 2) - 4 * (Valora * ValorC)))));
        calsu1 = cal1 / cal12;

        cal21 = Math.pow(ValorB, 2) - (Math.pow(ValorB, 2) - (4 * (Valora) * (ValorC)));
        cal22 = 2 * (Valora) * ((-ValorB + (Math.sqrt(Math.pow(ValorB, 2) - 4 * (Valora * ValorC)))));
        calsu2 = cal21 / cal22;

        System.out.println("El resultado de x1 es " + calsu1);
        System.out.println("El resultado de x2 es " + calsu2);

        return op;
    }
}
