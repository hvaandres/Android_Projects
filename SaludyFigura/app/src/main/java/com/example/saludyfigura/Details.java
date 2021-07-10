package com.example.saludyfigura;

import androidx.annotation.NonNull;

public class Details {

    static String title;
    static String description;
    static String link;

    Details(String title, String description, String link ) {

        this.title = title;
        this.description = description;
        this.link = link;
    }

    // Create a method that already exists (To String)

    @NonNull
    @Override
    public String toString() {
        return Details.description;
    }
}
