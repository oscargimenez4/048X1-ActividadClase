/*
 * Copyright 2019 Oscar G.4 - oscargimenez4@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.libraries;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Oscar G.4 - oscargimenez4@gmail.com
 */
public class UtilesEntrada {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final String MSG_USR = "Introducir número .....: ";
    public static final String MSG_OUT = "Número introducido ....: ";
    public static final String MSG_ERR = "ERROR: Entrada incorrecta ";

    public static final double obtener(String msgUsr, String msgErr) {
        double numero = 0;
        boolean testOK = false;

        do {
            try {
                System.out.print("Introduzca un numero entero....: ");
                numero = SCN.nextInt();
                testOK = true;
            } catch (Exception e) {
                System.out.println("ERROR: Entrada incorrecta");
            } finally {
                SCN.nextLine();
            }
        } while (!testOK);
        return numero;
    }

    public static final int leerNumero(String msgUsr, String msgErr) {
        return (int) obtener(msgUsr, msgErr);
    }

    public static final int AN_PAR = 0;
    public static final int AN_IMP = 1;
    public static final int AN_POS = 2;
    public static final int AN_NEG = 3;

    public static final boolean analizar(double n, int an) {
        boolean testOK;
        switch (an) {
            case AN_PAR:
                testOK = n % 2 == 0;
                break;
            case AN_IMP:
                testOK = n % 2 != 0;
                break;
            case AN_POS:
                testOK = n >= 0;
                break;
            case AN_NEG:
                testOK = n <= 0;
                break;
            default:
                throw new AssertionError();
        }
        return testOK;
    }

    public static final boolean validarPar(double n) {
        return analizar(n, AN_PAR);
    }

    public static final boolean validarImpar(double n) {
        return analizar(n, AN_IMP);
    }

    public static final boolean validarPositivo(double n) {
        return analizar(n, AN_POS);
    }

    public static final boolean validarNegativo(double n) {
        return analizar(n, AN_NEG);
    }
}
