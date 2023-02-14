/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.copesadamoli.verificaanalisisangue;

import java.util.ArrayList;

/**
 *
 * @author MATTIAADAMOLI
 */
public class Analisi {

    private String nome;
    private int tempo_dopo_prelievo;
    private ArrayList<Strumenti> strumenti;

    public Analisi(String nome, int tempo_dopo_prelievo, ArrayList<Strumenti> strumenti) {
        this.nome = nome;
        this.tempo_dopo_prelievo = tempo_dopo_prelievo;
        this.strumenti = strumenti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoDopoPrelievo() {
        return tempo_dopo_prelievo;
    }

    public void setTempoDopoPrelievo(int tempoDopoPrelievo) {
        this.tempo_dopo_prelievo = tempoDopoPrelievo;
    }

    public ArrayList<Strumenti> getStrumenti() {
        return strumenti;
    }

    public void setStrumenti(ArrayList<Strumenti> strumenti) {
        this.strumenti = strumenti;
    }

    
}
