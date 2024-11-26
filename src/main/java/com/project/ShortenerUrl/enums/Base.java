package com.project.ShortenerUrl.enums;

public enum Base {
    BASE58(58, "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"),
    BASE62(62,"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");

    public final int NUM_BASE;
    public final String BASE;


    Base(int number, String base){
        this.NUM_BASE = number;
        this.BASE = base;
    }

}
