package com.example.ripetizioni;


import java.io.Serializable;

public class Catalogo implements Serializable {
    //classe che contiene tutte le prenotazioni (disponibili e non) di tutti i corsi tenute dai docenti.
    private int idCatalogo; //chiave DB
    private int idDocente; //db
    private int idCorso; //db
    private String giorno; //giorno in cui è prevista la ripetizione ("LUNEDI"-"MARTEDI"-"MERCOLEDI"-"GIOVEDI"-"VENERDI"-"SABATO"-"DOMENICA")
    private int oraInizio; //orario inizio "15-16-17-18-19"
    private int oraFine; //16-17-18-19-20
    private String stato; //false =occupata - true=prenotabile


    public Catalogo(int idCatalogo, int idDocente, int idCorso, String giorno, int oraInizio, int oraFine, String stato) {
        this.idCatalogo = idCatalogo;
        this.idDocente = idDocente;
        this.idCorso = idCorso;
        this.giorno = giorno;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.stato = stato;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public int getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(int idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getIdCorso() {
        return idCorso;
    }

    public void setIdCorso(int idCorso) {
        this.idCorso = idCorso;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public int getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(int oraInizio) {
        this.oraInizio = oraInizio;
    }

    public int getOraFine() {
        return oraFine;
    }

    public void setOraFine(int oraFine) {
        this.oraFine = oraFine;
    }

    @Override
    public String toString() {
        return "Catalogo{" + "idCatalogo=" + idCatalogo + ", idDocente=" + idDocente + ", idCorso=" + idCorso + ", giorno=" + giorno + ", oraInizio=" + oraInizio + ", oraFine=" + oraFine + ", stato=" + stato + '}';
    }







}
