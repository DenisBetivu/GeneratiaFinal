package com.example.denis.generatia;

/**
 * Created by Denis on 07.02.2018.
 */

public class User {
    private String Nume;
    private String Prenume;
    private int CNP;
    private int An_studiu;
    private String Facultate;
    private int Varsta;
    private int Credite;


    public User(String snume,String sprenume, int scnp,
               int sAn_studiu, String sfacultate, int sVarsta, int scredite ){
        Nume = snume;
        Prenume = sprenume;
        CNP = scnp;
        An_studiu = sAn_studiu;
        Facultate = sfacultate;
        Varsta = sVarsta;
        Credite = scredite;

    }

    public String getNume() {
        return Nume;
    }
    public void setNume(String snume) {
        Nume = snume;
    }


    public String getPrenume() {
        return Prenume;
    }
    public void setPrenume(String sprenume) {
        Prenume = sprenume;
    }


    public String getCNP() {
        return CNP+"";
    }
    public void setCNP(int scnp) {
        CNP = scnp;
    }


    public String getAn_studiu() {
        return An_studiu+"";
    }
    public void setAn_studiu(int sAn_Studiu) {
        An_studiu = sAn_Studiu;
    }



    public String getFacultate() {
        return Facultate;
    }
    public void setFacultate(String sfacultate) {
        Facultate = sfacultate;
    }


    public String getVarsta() {
        return Varsta+"";
    }
    public void setVarsta(int sVarsta) {
        Varsta = sVarsta;
    }



    public String getCredite() {
        return Credite+"";
    }
    public void setCredite(int scredite) {
        Credite = scredite;
    }

}