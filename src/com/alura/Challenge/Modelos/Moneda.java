package com.alura.Challenge.Modelos;

public record Moneda(String base_code,              // "COP"
                     String target_code,            // "USD"
                     Double conversion_rate,        // valor de base a target
                     Double conversion_result //convercion multiplicando la cantidad
                                                    ) {
}
