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
public class Strumenti {

    private int matricola;
    private ArrayList<String> operatori_abilitati;

    public Strumenti(int matricola, ArrayList<String> operatori_abilitati) {
        this.matricola = matricola;
        this.operatori_abilitati = operatori_abilitati;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public ArrayList<String> getOperatoriAbilitati() {
        return operatori_abilitati;
    }

    public void setOperatoriAbilitati(ArrayList<String> operatoriAbilitati) {
        this.operatori_abilitati = operatoriAbilitati;
    }

}
