package com.example.census;

public class SurveyData {
    String familyNAme;
    Integer numberInFamily, numberReachedSec;

    public SurveyData(String familyNAme, Integer numberInFamily, Integer numberReachedSec) {
        this.familyNAme = familyNAme;
        this.numberInFamily = numberInFamily;
        this.numberReachedSec = numberReachedSec;
    }

    public String getFamilyNAme() {
        return familyNAme;
    }

    public void setFamilyNAme(String familyNAme) {
        this.familyNAme = familyNAme;
    }

    public Integer getNumberInFamily() {
        return numberInFamily;
    }

    public void setNumberInFamily(Integer numberInFamily) {
        this.numberInFamily = numberInFamily;
    }

    public Integer getNumberReachedSec() {
        return numberReachedSec;
    }

    public void setNumberReachedSec(Integer numberReachedSec) {
        this.numberReachedSec = numberReachedSec;
    }
}
