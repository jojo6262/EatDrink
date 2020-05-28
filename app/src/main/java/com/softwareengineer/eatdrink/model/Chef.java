package com.softwareengineer.eatdrink.model;

public class Chef {
    String Name;
    String CountOrder;
    String Price;
    String IDOrder;

    public Chef(){
    }

    public Chef(String IDOrder, String Name, String CountOrder, String Price){
        this.IDOrder=IDOrder;
        this.Name=Name;
        this.CountOrder=CountOrder;
        this.Price=Price;
    }

    public String getIDOrder() {
        return IDOrder;
    }

    public String getCountOrder() {
        return CountOrder;
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }

    public void setCountOrder(String countOrder) {
        CountOrder = countOrder;
    }

    public void setIDOrder(String IDOrder) {
        this.IDOrder = IDOrder;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
