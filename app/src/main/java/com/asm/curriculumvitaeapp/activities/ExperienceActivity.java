package com.asm.curriculumvitaeapp.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.asm.curriculumvitaeapp.R;
import com.asm.curriculumvitaeapp.fragments.ExperienceFragment;
import com.asm.curriculumvitaeapp.fragments.JobFragment;


public class ExperienceActivity extends FragmentActivity implements ExperienceFragment.OnFragmentInteractionListener, JobFragment.OnFragmentInteractionListener {

    private final String TAG = ExperienceActivity.class.getCanonicalName();
    private final String TAG_EXPERIENCE = "experience";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            ExperienceFragment experienceFragment = new ExperienceFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, experienceFragment, TAG_EXPERIENCE);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
