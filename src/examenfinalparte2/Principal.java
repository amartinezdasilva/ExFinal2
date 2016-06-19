
package examenfinalparte2;

import java.util.Scanner;

/**
 * 
 * @author Aaron
 */
public class Principal {

    public static boolean primo = false;
    
    public static void main(String arg[])
        {
         int dig;
         int ndig;
        do {
            dig = meterDigito();
            if (dig <= 0) {
                System.out.println("Ingrese como parámetro, un numero de digito correcto (mayor que 0): ");
            }
        } while (dig <= 0); 
        for (int comparar = 1; comparar <= 99999; comparar++) {
            ndig = divisionEntera(comparar); 
            
           
            if (ndig == dig) {
                if (comparar < 4) { 
                    primo = true;
                } else if (comparar % 2 == 0) {
                    primo = false;
                } else { 
                    int divisores = 0;
                    int i1 = 1;
                    int limite = (comparar - 1) / 2;
                    if (limite % 2 == 0) {
                        limite--;
                    }

                    primo = calculoNumeroDivisores(i1, limite, comparar, divisores);
                }

                if (primo == true) {
                    System.out.println(comparar);
                }
            }
        }
    }
   
    private static boolean calculoNumeroDivisores(int i1, int limite, int numComparar, int countDivisores) {
        boolean esPrimo = false;
        while (i1 <= limite) {
            if (numComparar % i1 == 0) {
                countDivisores++;
            }
            i1 += 2;
            if (countDivisores == 2) {
                i1 = limite + 1;
            }
        }
        
        if (countDivisores == 1) {
            esPrimo = true;
        }
        
        return esPrimo;
    }

    
    private static int divisionEntera(int numComparar) {
        int aux = numComparar;
        int contador = 0;
        while (aux != 0) {
            aux = aux / 10;
            contador++;
        }
        return contador;
    }
    
    
    public static int meterDigito() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un dígito:");
        return teclado.nextInt();
    }

}