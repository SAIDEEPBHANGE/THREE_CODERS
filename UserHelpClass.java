package com.example.adhar;

public class UserHelpClass {
    String noadhr,nophone,idemail,firstadd,secondadd;

    public UserHelpClass() {
    }

    public UserHelpClass(String noadhr, String nophone, String idemail, String firstadd, String secondadd) {
        this.noadhr = noadhr;
        this.nophone = nophone;
        this.idemail = idemail;
        this.firstadd = firstadd;
        this.secondadd = secondadd;
    }

    public String getNoadhr() {
        return noadhr;
    }

    public void setNoadhr(String noadhr) {
        this.noadhr = noadhr;
    }

    public String getNophone() {
        return nophone;
    }

    public void setNophone(String nophone) {
        this.nophone = nophone;
    }

    public String getIdemail() {
        return idemail;
    }

    public void setIdemail(String idemail) {
        this.idemail = idemail;
    }

    public String getFirstadd() {
        return firstadd;
    }

    public void setFirstadd(String firstadd) {
        this.firstadd = firstadd;
    }

    public String getSecondadd() {
        return secondadd;
    }

    public void setSecondadd(String secondadd) {
        this.secondadd = secondadd;
    }
}