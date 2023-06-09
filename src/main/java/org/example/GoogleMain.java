package org.example;

import java.io.IOException;

public class GoogleMain {
    public static void main(String[] args) throws IOException {
        googleMethods Google = new googleMethods();
        Google.setUp();
        Google.login();
        Google.search();



    }
}