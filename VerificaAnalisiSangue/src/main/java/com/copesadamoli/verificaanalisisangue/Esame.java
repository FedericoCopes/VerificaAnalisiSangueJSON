/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.copesadamoli.verificaanalisisangue;

import java.util.ArrayList;

/**
 *
 * @author FEDERICOCOPES
 */
public class Esame {

    private String denominazione;
    private String data;
    private String ora;
    private String codice_operatore;
    private ArrayList<Integer> strumenti;
    private float valore;
    private String unita_di_misura;
    private int valore_minimo;
    private int valore_massimo;

    public Esame(String denominazione, String data, String ora, String codice_operatore, ArrayList<Integer> strumenti, float valore, String unita_di_misura, int valore_minimo, int valore_massimo) {
        this.denominazione = denominazione;
        this.data = data;
        this.ora = ora;
        this.codice_operatore = codice_operatore;
        this.strumenti = strumenti;
        this.valore = valore;
        this.unita_di_misura = unita_di_misura;
        this.valore_minimo = valore_minimo;
        this.valore_massimo = valore_massimo;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getCodice_operatore() {
        return codice_operatore;
    }

    public void setCodice_operatore(String codice_operatore) {
        this.codice_operatore = codice_operatore;
    }

    public ArrayList<Integer> getStrumenti() {
        return strumenti;
    }

    public void setStrumenti(ArrayList<Integer> strumenti) {
        this.strumenti = strumenti;
    }

    public float getValore() {
        return valore;
    }

    public void setValore(float valore) {
        this.valore = valore;
    }

    public String getUnita_di_misura() {
        return unita_di_misura;
    }

    public void setUnita_di_misura(String unita_di_misura) {
        this.unita_di_misura = unita_di_misura;
    }

    public int getValore_minimo() {
        return valore_minimo;
    }

    public void setValore_minimo(int valore_minimo) {
        this.valore_minimo = valore_minimo;
    }

    public int getValore_massimo() {
        return valore_massimo;
    }

    public void setValore_massimo(int valore_massimo) {
        this.valore_massimo = valore_massimo;
    }

    
}
