package com.alura.Challenge.Modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Historial {

    public ArrayList<String> fechasHistorial = new ArrayList<>();

    public ArrayList<String> getFechasHistorial() {
        return fechasHistorial;
    }

    public void registro(String paisbase, String paisObjetivo, int cantidad, String resultadoConversion) {

        String fecha = String.valueOf(LocalDate.now());
        String hora = String.valueOf(LocalTime.now());
        String aviso = String.format("%S %S : Se convirtio %d %S a %S %S", fecha, hora, cantidad, paisbase, resultadoConversion, paisObjetivo);
        fechasHistorial.add(aviso);
    }


    public void registro(String paisbase, String monedaConvertidaEUR, String monedaConvertidaUSD) {
        String fecha = String.valueOf(LocalDate.now());
        String hora = String.valueOf(LocalTime.now());
        String aviso = String.format("%S %S : Se convirtio 1 %S a %S EUR y %S USD", fecha, hora, paisbase, monedaConvertidaEUR, monedaConvertidaUSD);
        fechasHistorial.add(aviso);
    }
}
