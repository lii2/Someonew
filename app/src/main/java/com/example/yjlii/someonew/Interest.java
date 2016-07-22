package com.example.yjlii.someonew;

/**
 * Created by Lii2 on 7/18/2016.
 */
public class Interest {

    public String name;
    public int pictureID;

    public Interest() {
    }

    public Interest(String name, int pictureID) {

        this.name = name;
        this.pictureID = pictureID;
    }


    @Override
    public String toString() {
        return "Interest{" +
                "name='" + name + '\'' +
                ", pictureID=" + pictureID +
                '}';
    }
}
