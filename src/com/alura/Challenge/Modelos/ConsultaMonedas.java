package com.alura.Challenge.Modelos;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;

public class ConsultaMonedas {

    public Moneda buscaMoneda(String monedaUsuarioBase, String monedaUsuarioObjetivo, int cantidadAConvertir) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b8648ca55f472f3fff45abaf/pair/"
                + monedaUsuarioBase + "/" + monedaUsuarioObjetivo + "/" + cantidadAConvertir);
        try {


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion) //URL
                    .build();

            HttpResponse<String>
                    response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Moneda.class);

        } catch (JsonSyntaxException e) {
            throw new RuntimeException("Digite correctamente la moneda que eligeInputMismatchException.");
        } catch (IOException e) {
            throw new RuntimeException("no encontre esa moneda.");
        } catch (InterruptedException e) {
            throw new RuntimeException("Digite correctamente la moneda que elige.");
        }
    }
}