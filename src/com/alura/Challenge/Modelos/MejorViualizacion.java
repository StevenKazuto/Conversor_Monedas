package com.alura.Challenge.Modelos;
import java.text.DecimalFormat;

public class MejorViualizacion {

    public static String convertir(double val) {

        DecimalFormat num = new DecimalFormat("#,###.000");
        return num.format(val);
    }

    public static String convertir2(double val) {

        DecimalFormat num = new DecimalFormat("#,###.000000");
        return num.format(val);
    }


}
