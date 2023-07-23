package com.furkanharmanci.landmarkagain;

import java.io.Serializable;


 // UI kısmında görünecekler propları bir sınıf içinde derli toplu yazdık.
public class LandMark implements Serializable {
    String name;
    String country;
    int image;

    public LandMark(String name, String country, int image) {
        this.name = name;
        this.country = country;
        this.image = image;
    }
}
