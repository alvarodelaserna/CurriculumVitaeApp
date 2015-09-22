package com.asm.curriculumvitaeapp.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageButton;

import com.asm.curriculumvitaeapp.R;
import com.asm.curriculumvitaeapp.core.CurriculumVitaeAppUtils;
import com.asm.curriculumvitaeapp.fragments.ExperienceFragment;
import com.asm.curriculumvitaeapp.fragments.JobFragment;
import com.asm.curriculumvitaeapp.fragments.MainFragment;


public class MainActivity extends FragmentActivity implements MainFragment.OnFragmentInteractionListener,
        ExperienceFragment.OnFragmentInteractionListener, JobFragment.OnFragmentInteractionListener {

    private final String TAG = MainActivity.class.getCanonicalName();
    private Context mContext;
    private ImageButton ic_action_call, ic_action_email, ic_action_linkedin;
    private ImageButton buttonPersonalInfo, buttonExperience, buttonEducation, buttonSkills;
    private static final String TAG_MAIN = "main";
    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        new CurriculumVitaeAppUtils(this);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            mainFragment = new MainFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, mainFragment, TAG_MAIN);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed(){
        CurriculumVitaeAppUtils.askUserToExit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
