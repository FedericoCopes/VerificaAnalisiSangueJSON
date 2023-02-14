package com.copesadamoli.verificaanalisisangue;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
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

    public static boolean checkOperator(String operatore, String denominazione_esame, Analisi[] an) 
                            throws IOException {//controllo operatore autorizzato
        
        for (Analisi analisi : an) {
            if (analisi.getNome().equals(denominazione_esame)) {
                for (int i = 0; i < analisi.getStrumenti().size(); i++) {
                    if (analisi.getStrumenti().get(i).getOperatoriAbilitati().contains(operatore)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void checkUtensil(ArrayList<Integer> strumenti, String denominazione_esame, Analisi[] an) 
                                throws IOException {//controllo degli strumenti utilizzati
        
        ArrayList<Integer> macchinari_letti = new ArrayList<Integer>();
        Boolean check = true;
        for (Analisi analisi : an) {
            if (analisi.getNome().equals(denominazione_esame)) {
                for (int i = 0; i < analisi.getStrumenti().size(); i++) {
                    macchinari_letti.add(analisi.getStrumenti().get(i).getMatricola());
                }
            }
        }
        Collections.sort(strumenti);
        Collections.sort(macchinari_letti);

        if (strumenti.equals(macchinari_letti)) {
            System.out.print("Tutti gli strumenti sono consentiti.");
        } else {
            System.out.print("Strumenti non consentiti: ");
            for (Integer num : strumenti) {
                if (!macchinari_letti.contains(num)) {
                    System.out.print(num +"");
                }
            }
        }
    }

    public static boolean checkDate(String dataAnalisi, String dataPrelievo, String denominazione_esame, Analisi[] an) 
                                        throws IOException, ParseException {//controllo della data
        
        LocalDate date1 = LocalDate.parse(dataAnalisi);
        LocalDate date2 = LocalDate.parse(dataPrelievo);
        
        for (Analisi analisi : an) {
            if (analisi.getNome().equals(denominazione_esame)) {
                long diffInDays = ChronoUnit.DAYS.between(date2, date1);
                int intValue = (int) diffInDays;
                if (intValue < analisi.getTempoDopoPrelievo()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

        Gson gson = new Gson();
        Gson gson1 = new Gson();
        String jsonEsito = readStringFromFile("esito.json");
        Esito esito = gson.fromJson(jsonEsito, Esito.class);
        ArrayList<String> operatori_abilitati = new ArrayList<String>();
        ArrayList<String> operatore_esami = new ArrayList<String>();
        String operatori_abilitati_esame = "";
        String json1;
        json1 = readStringFromFile("verificaAnalisi.json");
        Analisi[] an = gson1.fromJson(json1, Analisi[].class);
        ArrayList<Integer> strumenti = new ArrayList<Integer>();
        for (Analisi analisi : an) {
            for (int i = 0; i < analisi.getStrumenti().size(); i++) {
                operatori_abilitati.add(analisi.getStrumenti().get(i).getOperatoriAbilitati().get(i));
            }
        }
        System.out.println("Nome: " + esito.getNome());
        System.out.println("Cognome: " + esito.getCognome());
        System.out.println("Codice Fiscale: " + esito.getCodice_fiscale());
        System.out.println("Sesso: " + esito.getSesso());
        System.out.println("Età: " + esito.getEta());
        System.out.println("Data prelievo: " + esito.getData_prelievo());
        System.out.println("Ora prelievo: " + esito.getOra_prelievo());
        System.out.println("Luogo prelievo: " + esito.getLuogo_prelievo());
        
        System.out.println("\nEsami effettuati da: " + esito.getNome() + " " + esito.getCognome());
        
        for (int i = 0; i < esito.getEsami().size(); i++) {//lista esami
            System.out.println("Denominazione: " + esito.getEsami().get(i).getDenominazione().toUpperCase());
            System.out.println("Data: " + esito.getEsami().get(i).getData());
            System.out.println("Ora: " + esito.getEsami().get(i).getOra());
            boolean resultdate = checkDate(esito.getEsami().get(i).getData(), esito.getData_prelievo(), esito.getEsami().get(i).getDenominazione(), an);
            if (resultdate == true) {
                System.out.println("L'analisi è stata svolta nei tempi previsti");
            } else {
                System.out.println("L'analisi non è stata svolta nei tempi previsti");
            }
            System.out.println("Codice operatore: " + esito.getEsami().get(i).getCodice_operatore());
            boolean resultOperator = checkOperator(esito.getEsami().get(i).getCodice_operatore(), esito.getEsami().get(i).getDenominazione(), an);
            if (resultOperator == true) {
                System.out.println("L'operatore è abilitato");
            } else {
                System.out.println("L'operatore non è abilitato");
            }
            operatore_esami.add(esito.getEsami().get(i).getCodice_operatore());
            for (int j = 0; j < esito.getEsami().get(i).getStrumenti().size(); j++) { //lista strumenti
                strumenti.add(esito.getEsami().get(i).getStrumenti().get(j));
            }
            checkUtensil(strumenti, esito.getEsami().get(i).getDenominazione(), an);
            strumenti.clear();
            System.out.println("\nValore rilevato: " + esito.getEsami().get(i).getValore());
            if (esito.getEsami().get(i).getValore() < esito.getEsami().get(i).getValore_massimo() && esito.getEsami().get(i).getValore() > esito.getEsami().get(i).getValore_minimo()) {
                System.out.println("Valore nella norma \n");
            } else if (esito.getEsami().get(i).getValore() > esito.getEsami().get(i).getValore_massimo()) {
                System.out.println("Valore superiore alla norma \n");
            } else {
                System.out.println("Valore inferiore alla norma \n");
            }
        }
    }
}
