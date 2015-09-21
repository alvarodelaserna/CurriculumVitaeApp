package com.asm.curriculumvitaeapp.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.asm.curriculumvitaeapp.R;
import com.asm.curriculumvitaeapp.core.CurriculumVitaeAppUtils;


public class MainActivity extends Activity {

    private final String TAG = MainActivity.class.getCanonicalName();
    private Context mContext;
    private ImageView ic_action_call, ic_action_email;
    private TextView buttonPersonalInfo, buttonExperience, buttonEducation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        new CurriculumVitaeAppUtils(this);

        initElements();

        setListenersToButtons();
    }

    private void setListenersToButtons() {
        buttonPersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPersonalInformationActivity();
            }
        });
        buttonExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startExperienceActivity();
            }
        });
        buttonEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startEducationActivity();
            }
        });
        ic_action_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurriculumVitaeAppUtils.askUserToCall();
            }
        });
        ic_action_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurriculumVitaeAppUtils.askUserToSendEmail();
            }
        });
    }

    private void initElements() {
        ic_action_call = (ImageView) findViewById(R.id.ic_action_call);
        ic_action_email = (ImageView) findViewById(R.id.ic_action_email);
        buttonPersonalInfo = (TextView) findViewById(R.id.button_show_personal_info);
        buttonExperience = (TextView) findViewById(R.id.button_show_professional_experience);
        buttonEducation = (TextView) findViewById(R.id.button_show_education);
    }

    @Override
    public void onBackPressed(){
        CurriculumVitaeAppUtils.askUserToExit();
    }

    private void startEducationActivity() {
        Intent intent = new Intent(mContext, EducationActivity.class);
        startActivity(intent);
    }

    private void startExperienceActivity() {
        Intent intent = new Intent(mContext, ExperienceActivity.class);
        startActivity(intent);
    }

    private void startPersonalInformationActivity() {
        Intent intent = new Intent(mContext, PersonalInformationActivity.class);
        startActivity(intent);
    }
}
