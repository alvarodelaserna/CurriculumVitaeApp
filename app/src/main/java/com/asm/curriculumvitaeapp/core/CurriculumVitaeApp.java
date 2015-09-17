package com.asm.curriculumvitaeapp.core;

import android.app.Application;
import android.content.Context;

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
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static CurriculumVitaeApp getApplication(){ return CurriculumVitaeApp.application; }

}
