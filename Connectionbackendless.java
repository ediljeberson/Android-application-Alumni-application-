package com.jeberson.affinity_allumni;

import android.app.Application;

import com.backendless.Backendless;


public class Connectionbackendless extends Application {

    public static  final String APPLICATION_ID = "276CAC70-A789-4715-8D95-CAA3215CFF28";
    public static  final String API_KEY ="03449C7A-6023-492D-81BF-AA8BC29B3115";
    public static  final String SERVER_URL = "https://api.backendless.com";


    @Override
    public void onCreate() {
        super.onCreate();

        Backendless.setUrl(SERVER_URL);
        Backendless.initApp(getApplicationContext(), APPLICATION_ID, API_KEY);
    }

}
