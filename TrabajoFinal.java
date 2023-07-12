package TrabajoFinal;

import java.util.Arrays;

public class TrabajoFinal {
    public static void main(String[] args) {
        //Datos de los clientes
        String[] clientes = {"Fabio","Luis","Daniel"};
        String[] fechas = {"15/07/2023","26/07/2023","11/07/2023"};
        int[] montos = {170,850,650};

        //Condiciones del sorteo
        int diaSorteo = 15;
        int mesSorteo = 7;
        int aoSorteo = 2023;
        int montoSorteo = 500;

        //Verificar si cliente realizo la compra en el periodo de tiempo correcto
        String[] condicionFecha = calcularFecha(fechas,diaSorteo,mesSorteo,aoSorteo);
        System.out.println("Los dias que entran al sorteo son: " + Arrays.toString(condicionFecha));

        //Verificar si el monto de compra es mayor o igual al monto requerido
        int[] condicionCompra = calcularCompra(montos,montoSorteo);
        System.out.println("Las compras que entran al sorteo son: " + Arrays.toString(condicionCompra));

        //Devolver una lista con los nombres de los clientes que entraron al sorteo
        String sorteoClientes = calcularClientes(clientes,condicionFecha,condicionCompra);
        System.out.println("Los clientes que entraron al sorteo son: " + sorteoClientes);
    }

    private static String[] calcularFecha(String[] fechas, int diaSorteo, int mesSorteo, int aoSorteo){
        String[] lista = new String[fechas.length];

        for (int i=0;i<fechas.length;i++){
            int dia = Integer.parseInt(fechas[i].substring(0,2));
            int mes = Integer.parseInt(fechas[i].substring(3,5));
            int ao = Integer.parseInt(fechas[i].substring(6,10));
            if (dia<=diaSorteo && mes == mesSorteo && ao == aoSorteo){
                lista[i] = fechas[i];
            }
        }

        return lista;
    }
//Aqui se calculan si la compra entra al sorteo
    private static int[] calcularCompra(int[] montos, int montoSorteo){
        int[] lista = new int[montos.length];

        for (int i=0;i<montos.length;i++){
            if (montos[i]>=montoSorteo){
                lista[i] = montos[i];
            }
        }

        return lista;
    }
//Aqui se calculan los clientes que entraron al sorteo
    private static String calcularClientes(String[] clientes, String[] condicionFecha, int[] condicionCompra){
        String[] lista = new String[clientes.length];

        for (int i=0; i<clientes.length;i++){
            if (condicionFecha[i] != null && condicionCompra[i] != 0){
                lista[i] = clientes[i];
            }
        }

        return Arrays.toString(lista);
    }
}

