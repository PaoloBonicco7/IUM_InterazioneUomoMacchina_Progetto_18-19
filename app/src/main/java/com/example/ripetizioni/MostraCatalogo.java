package com.example.ripetizioni;

public class MostraCatalogo {

    private int idCatalogo; //chiave DB
    private int idDocente; //db
    private int idCorso; //db
    private String giorno; //giorno in cui è prevista la ripetizione ("LUNEDI"-"MARTEDI"-"MERCOLEDI"-"GIOVEDI"-"VENERDI"-"SABATO"-"DOMENICA")
    private int oraInizio; //orario inizio "15-16-17-18-19"
    private int oraFine; //16-17-18-19-20
    private boolean prenotabile; //false = occupata - true = prenotabile
    private String nome; //nome docente
    private String cognome; //cognome docente
    private String titolo; //titolo corso

    public MostraCatalogo(int idCatalogo, int idDocente, int idCorso, String giorno, int oraInizio, int oraFine, boolean prenotabile, String nome, String cognome, String titolo) {
        this.idCatalogo = idCatalogo;
        this.idDocente = idDocente;
        this.idCorso = idCorso;
        this.giorno = giorno;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.prenotabile = prenotabile;
        this.nome = nome;
        this.cognome = cognome;
        this.titolo = titolo;
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

    public boolean isPrenotabile() {
        return prenotabile;
    }

    public void setPrenotabile(boolean prenotabile) {
        this.prenotabile = prenotabile;
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
        return "MostraCatalogo{" + "idCatalogo=" + idCatalogo + ", idDocente=" + idDocente + ", idCorso=" + idCorso + ", giorno=" + giorno + ", oraInizio=" + oraInizio + ", oraFine=" + oraFine + ", prenotabile=" + prenotabile + ", nome=" + nome + ", cognome=" + cognome + ", titolo=" + titolo + '}';
    }

}
