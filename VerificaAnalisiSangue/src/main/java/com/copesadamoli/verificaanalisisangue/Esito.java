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
public class Esito {

    private String nome;
    private String cognome;
    private String codice_fiscale;
    private String sesso;
    private int eta;
    private String data_prelievo;
    private String ora_prelievo;
    private String luogo_prelievo;
    private ArrayList<Esame> esami;

    public Esito(String nome, String cognome, String codice_fiscale, String sesso, int eta, String data_prelievo, String ora_prelievo, String luogo_prelievo, ArrayList<Esame> esami) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice_fiscale = codice_fiscale;
        this.sesso = sesso;
        this.eta = eta;
        this.data_prelievo = data_prelievo;
        this.ora_prelievo = ora_prelievo;
        this.luogo_prelievo = luogo_prelievo;
        this.esami = esami;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodice_fiscale() {
        return codice_fiscale;
    }

    public void setCodice_fiscale(String codice_fiscale) {
        this.codice_fiscale = codice_fiscale;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getData_prelievo() {
        return data_prelievo;
    }

    public void setData_prelievo(String data_prelievo) {
        this.data_prelievo = data_prelievo;
    }

    public String getOra_prelievo() {
        return ora_prelievo;
    }

    public void setOra_prelievo(String ora_prelievo) {
        this.ora_prelievo = ora_prelievo;
    }

    public String getLuogo_prelievo() {
        return luogo_prelievo;
    }

    public void setLuogo_prelievo(String luogo_prelievo) {
        this.luogo_prelievo = luogo_prelievo;
    }

    public ArrayList<Esame> getEsami() {
        return esami;
    }

    public void setEsami(ArrayList<Esame> esami) {
        this.esami = esami;
    }

    
}
