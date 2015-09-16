package com.asm.curriculumvitaeapp.core;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by alvaro on 16/09/15.
 */
public class CurriculumVitaeApp extends Application {
    private String TAG = CurriculumVitaeApp.class.getCanonicalName();
    private static Context context;
    private static CurriculumVitaeApp application;

    public void onCreate(){
        super.onCreate();
        CurriculumVitaeApp.context = getApplicationContext();
        CurriculumVitaeApp.application = this;
        Log.v(TAG, "Application initiated");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static CurriculumVitaeApp getApplication(){ return CurriculumVitaeApp.application; }

    public static Context getContext(){
        return CurriculumVitaeApp.context;
    }

}