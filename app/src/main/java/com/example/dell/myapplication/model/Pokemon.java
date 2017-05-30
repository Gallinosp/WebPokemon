package com.example.dell.myapplication.model;

import java.util.ArrayList;

/**
 * Created by Gallo on 29/05/2017.
 */

public class Pokemon {
    private String name;
    private String weight;
    private String height;
    private String url;

    public String getUrl() {
        return url;
    }

    public Integer getNumber() {

        String[] urlPartes = url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length - 1]);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }

    private Integer number;

    private ArrayList<Types> types;
    private ArrayList<Moves> moves;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {

        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }



    public ArrayList<Types> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Types> types) {
        this.types = types;
    }


    public ArrayList<Moves> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<Moves> moves) {
        this.moves = moves;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}

