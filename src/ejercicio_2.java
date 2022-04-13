/*
El astrónomo Metón de Atenas descubrió hacia el siglo V a.C que la luna
repite su ciclo cada 19 años (el mismo día del mismo mes tendrá la misma
fase lunar). Sus aportes permitieron determinar la fase de la luna para una
fecha dada. Los pasos para obtener esa información son:
a. Calcular el número áureo: permite conocer en qué año-tipo del ciclo
nos encontramos considerando la repetición de ciclos cada 19 años.
El número áureo se calcula de la siguiente forma:
– Tomamos la cifra del año que nos interesa (por ejemplo 2023) y le sumamos 1
(2023+1=2024)
– A continuación dividimos el resultado por 19 (ciclo de repetición) y nos
quedamos con el resto 2024/19 = 106 resto = 10 (10 es el resto entre 2024 y 19). Al
dividir por 19 hemos eliminado los ciclos repetidos. Así el número áureo es 10.
b. Calcular la epacta: es la edad de la luna en días el 1 de enero del
año elegido, y se calcula de la siguiente forma:
– Se resta 1 del número áureo, y se multiplica por 11 (en nuestro caso 10-1 = 9; 9*11
= 99)
– Después, se divide por 30 (un mes lunar) y de nuevo nos quedamos con el resto:
99/30 = 3 resto = 9. Significa que el 1 de enero de 2023 habrán pasado 9 días
desde la última luna nueva.
26

c. Finalmente, para saber la edad lunar en un día cualquiera,
(supongamos el 15 de junio de 2023) realizaremos la siguiente
operación:
1) A la epacta (9) le sumamos 1 por cada mes a partir de marzo (por
ejemplo: de marzo a junio sumamos 4, y si el mes fuera enero de
marzo a enero sumamos 11), y luego le sumamos el día del mes
requerido (15), es decir 9+4+15=28.
2) 28 es la edad lunar para esa fecha, y si pasara de 29 habría que
reducirlo obteniendo el resto de dividir por 30.
3) Es decir que el 15 de junio de 2023 habrán pasado 28 días desde la
última luna nueva, por lo que la luna será menguante casi nueva (a
falta de un día aproximadamente).
Se pide: hacer un programa completo en el cual se solicite de teclado el
ingreso de un día, un número de mes, y un año; luego calcule la cantidad
de días desde la última luna nueva (edad lunar), e informe por pantalla en
cual de las 4 fases se corresponde para esa fecha.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese un dia: ");
        int dia = Integer.valueOf(reader.readLine());
        System.out.println("Ingrese un numero de mes: ");
        int nmes = Integer.valueOf(reader.readLine());
        System.out.println("Ingrese el anio para calcular las fases lunares: ");
        int anio = Integer.valueOf(reader.readLine());

        float numAureo = CalcularNumAureo(anio);
        float epacta = CalcularEpacta(numAureo);
        float edadLunar = CalcularEdadLunar(epacta, nmes);

        System.out.println(edadLunar);
    }

    public static float CalcularNumAureo(int anio){
      return (anio+1)%19;
    }

    public static float CalcularEpacta(float aureo){
        return (aureo-1)*11%30;
    }

    public static float CalcularEdadLunar(float epacta, int nmes){
        int suma=0;
        while(nmes != 3) {
            if (nmes > 3) {
                for (int c = nmes; c <= 12; c++) {
                    suma++;
                }
                suma = suma + 2;
            } else {
                for (int c = nmes; c <= 3; c++) {
                    suma++;
                }
                suma = suma+9;
            }
            break;
        }
        return suma;
    }
}
