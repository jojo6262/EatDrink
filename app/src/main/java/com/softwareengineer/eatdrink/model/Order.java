package com.softwareengineer.eatdrink.model;

public class Order {
    String NAME;
    int COUNT;
    int PRICE;
    String Idmenu;

    public Order(){
    }

    public Order(String NAME,int COUNT,int PRICE,String idmenu){
        this.NAME=NAME;
        this.COUNT=COUNT;
        this.PRICE=PRICE;
        this.Idmenu=idmenu;
    }

    public int getCOUNT() {
        return COUNT;
    }

    public String getNAME() {
        return NAME;
    }

    public int getPRICE() {
        return PRICE;
    }

    public void setCOUNT(int COUNT) {
        this.COUNT = COUNT;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setPRICE(int PRICE) {
        this.PRICE = PRICE;
    }

    public String getIdmenu() {
        return Idmenu;
    }

    public void setIdmenu(String idmenu) {
        Idmenu = idmenu;
    }
}
