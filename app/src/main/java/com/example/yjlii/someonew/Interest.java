package com.example.yjlii.someonew;

/**
 * Created by Lii2 on 7/18/2016.
 */
public class Interest {

    private String name;
    private int pictureID;

    public Interest() {
    }

    public Interest(int pictureID, String name) {
        this.pictureID = pictureID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPictureID() {
        return pictureID;
    }

    public void setPictureID(int pictureID) {
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
