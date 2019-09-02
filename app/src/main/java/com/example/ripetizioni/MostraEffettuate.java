package com.example.ripetizioni;

import java.io.Serializable;

public class MostraEffettuate implements Serializable {

    private String utente; //utente+idCatalogo chiave per db
    private int idCatalogo;
    private int idDocente; //db
    private int idCorso; //db
    private String giorno; //giorno in cui è prevista la ripetizione ("LUNEDI"-"MARTEDI"-"MERCOLEDI"-"GIOVEDI"-"VENERDI"-"SABATO"-"DOMENICA")
    private int oraInizio; //orario inizio "15-16-17-18-19"
    private int oraFine; //16-17-18-19-20
    private String stato;
    private String nome; //nome docente
    private String cognome; //cognome docente
    private String titolo; //titolo corso

    public MostraEffettuate(String utente, int idCatalogo, int idDocente, int idCorso, String giorno, int oraInizio, int oraFine, String stato, String nome, String cognome, String titolo) {
        this.utente = utente;
        this.idCatalogo = idCatalogo;
        this.idDocente = idDocente;
        this.idCorso = idCorso;
        this.giorno = giorno;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.stato = stato;
        this.nome = nome;
        this.cognome = cognome;
        this.titolo = titolo;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
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

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
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

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "MostraEffettuate{" + "utente=" + utente + ", idCatalogo=" + idCatalogo + ", idDocente=" + idDocente + ", idCorso=" + idCorso + ", giorno=" + giorno + ", oraInizio=" + oraInizio + ", oraFine=" + oraFine + ", stato=" + stato + ", nome=" + nome + ", cognome=" + cognome + ", titolo=" + titolo + '}';
    }


}