/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.copesadamoli.verificaanalisisangue;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author FEDERICOCOPES
 */
public class VerificaAnalisiSangue {

    private static String readStringFromFile(String filepath) throws IOException {
        byte[] content = Files.readAllBytes(Paths.get(filepath));
        return new String(content);
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Gson gson = new Gson();
        String json = readStringFromFile("esito.json");
        Esito esito = gson.fromJson(json, Esito.class);
        
        System.out.println("Nome: " + esito.getNome());
        System.out.println("Cognome: " + esito.getCognome());
        System.out.println("Codice Fiscale: " + esito.getCodice_fiscale());
        System.out.println("Sesso: " + esito.getSesso());
        System.out.println("Età: " + esito.getEta());
        System.out.println("Data prelievo: " + esito.getData_prelievo());
        System.out.println("Ora prelievo: " + esito.getOra_prelievo());
        System.out.println("Luogo prelievo: " + esito.getLuogo_prelievo());
        System.out.println("\nESAMI:\n");
        
        //System.out.println("Esami: " + esito.getEsami());
        for(int i=0; i<esito.getEsami().size(); i++) {
            System.out.println("Denominazione: " + esito.getEsami().get(i).getDenominazione());
            System.out.println("Data: " + esito.getEsami().get(i).getData());
            System.out.println("Ora: " + esito.getEsami().get(i).getOra());
            System.out.println("Codice operatore: " + esito.getEsami().get(i).getCodice_operatore());
            
            for(int j=0; j<esito.getEsami().get(i).getStrumenti().size(); j++) { //lista strumenti
                System.out.println("Strumento: " + esito.getEsami().get(i).getStrumenti().get(j));
            }
            
            System.out.println("Valore: " + esito.getEsami().get(i).getValore());
            System.out.println("Unità di misura: " + esito.getEsami().get(i).getUnita_di_misura());
            System.out.println("Valore minimo: " + esito.getEsami().get(i).getValore_minimo());
            System.out.println("Valore massimo: " + esito.getEsami().get(i).getValore_massimo());
        }
    }
}
