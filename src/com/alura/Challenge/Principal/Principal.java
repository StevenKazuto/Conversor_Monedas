package com.alura.Challenge.Principal;

import com.alura.Challenge.Modelos.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String paisBase = "";
        String paisObjetivo = "";
        int cantidadMonedas = 0;
        boolean salidaPregunta = true;
        ConsultaMonedas consultaMonedas = new ConsultaMonedas();

        Historial historial = new Historial();

        PrintsDelMenu menuPaises = new PrintsDelMenu();

        try {
            while (salidaPregunta) {
                System.out.println("""
                        Bienvenido al Conversor de Monedas de Steven Triviño
                        Elija:
                        1.Conversion entre 2 modeas a elegir
                        2.Conversion de una moneda a elgir a EURO y DOLAR 
                        3.Historial
                        4.Salir
                        """);
                int opcionMenu = teclado.nextInt();

                switch (opcionMenu) {
                    case 1:
                        menuPaises.menuPaisesPrint();
                        System.out.println("""
                                ---------------------------------------------
                                      Digite las monedas con el COD 
                                que se puede visualizar en la lista anterior
                                    y la cantidad numerica a convertir
                                ---------------------------------------------
                                """);

                        System.out.println("Digite la moneda que quiere convertir \n");
                        paisBase = teclado.next();

                        System.out.println("Digite la moneda a la quiere que se convierta \n");
                        paisObjetivo = teclado.next();

                        System.out.println("Digite la cantidad que quiere convertir");
                        cantidadMonedas = teclado.nextInt();

                        Moneda monedaAConvertir = consultaMonedas.buscaMoneda(paisBase, paisObjetivo, cantidadMonedas); //conSulta a la API
                        String monedaConvertida = MejorViualizacion.convertir(monedaAConvertir.conversion_result());

                        System.out.println(String.format("""
                                --------------------------------------------------------------------------------
                                                        El valor de su conversion es:
                                                        %S %S       ==>  %S %S
                                ---------------------------------------------------------------------------------
                                """, cantidadMonedas, paisBase, monedaConvertida, paisObjetivo));

                        historial.registro(paisBase, paisObjetivo, cantidadMonedas, monedaConvertida);

                        break;
                    case 2:
                        menuPaises.menuPaisesPrint();

                        System.out.println("Digite la moneda a la que quiere convertir a EUR y USD \n");
                        paisBase = teclado.next();

                        //convertir el json recibido en clase RECORD Moneda y acomoda su visualizacion en punteado
                        Moneda monedaAConvertirEUR = consultaMonedas.buscaMoneda(paisBase, "EUR", 1);
                        String monedaConvertidaEUR = MejorViualizacion.convertir2(monedaAConvertirEUR.conversion_result());

                        Moneda monedaAConvertirUSD = consultaMonedas.buscaMoneda(paisBase, "USD", 1);
                        String monedaConvertidaUSD = MejorViualizacion.convertir2(monedaAConvertirUSD.conversion_result());

                        System.out.println("1 " + paisBase + " Equivale a : " + monedaConvertidaEUR +
                                " EUR y a : " + monedaConvertidaUSD + " USD");

                        historial.registro(paisBase, monedaConvertidaEUR, monedaConvertidaUSD);

                        break;
                    case 3:
                        menuPaises.printHistorial(historial.getFechasHistorial());
                        break;

                    case 4:
                        salidaPregunta = false;
                        menuPaises.menuDespedidaPrint();
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("""
                                --------------------------------------------
                                Digite correctamente lo que va a realizar
                    -----------------------------------------------------------------
                    """);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
