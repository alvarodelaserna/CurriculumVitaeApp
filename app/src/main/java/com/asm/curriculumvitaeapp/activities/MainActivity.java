package com.asm.curriculumvitaeapp.activities;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.asm.curriculumvitaeapp.R;
import com.asm.curriculumvitaeapp.core.CurriculumVitaeAppUtils;
import com.asm.curriculumvitaeapp.core.CustomGestureDetector;
import com.asm.curriculumvitaeapp.fragments.EducationFragment;
import com.asm.curriculumvitaeapp.fragments.ExperienceFragment;
import com.asm.curriculumvitaeapp.fragments.JobFragment;
import com.asm.curriculumvitaeapp.fragments.MainFragment;
import com.asm.curriculumvitaeapp.fragments.PersonalInformationFragment;
import com.asm.curriculumvitaeapp.fragments.SkillsFragment;


public class MainActivity extends FragmentActivity implements MainFragment.OnFragmentInteractionListener,
        ExperienceFragment.OnFragmentInteractionListener, JobFragment.OnFragmentInteractionListener,
        PersonalInformationFragment.OnFragmentInteractionListener, EducationFragment.OnFragmentInteractionListener,
        SkillsFragment.OnFragmentInteractionListener {

    private final String TAG = MainActivity.class.getCanonicalName();
    private Context mContext;
    private static final String TAG_MAIN = "main", TAG_EXPERIENCE = "experience", TAG_SKILLS = "skills",
            TAG_PERSONAL_INFORMATION = "personal", TAG_EDUCATION = "education", TAG_TAPAP = "tapap",
            TAG_PROGRESSIVE_BLUE = "progressive", TAG_TECHNOSITE = "technosite";
    private MainFragment mainFragment;
    private EducationFragment educationFragment;
    private ExperienceFragment experienceFragment;
    private JobFragment tapapFragment, progressiveBlueFragment, technositeFragment;
    private PersonalInformationFragment personalInformationFragment;
    private SkillsFragment skillsFragment;

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        new CurriculumVitaeAppUtils(this);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            mainFragment = new MainFragment();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, mainFragment, TAG_MAIN);
            fragmentTransaction.commit();
        }

        CustomGestureDetector customGestureDetector = new CustomGestureDetector(this);
        gestureDetector = new GestureDetector(this, customGestureDetector);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);

        return super.onTouchEvent(event);
    }

}
