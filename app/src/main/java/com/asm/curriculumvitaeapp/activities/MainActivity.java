package com.asm.curriculumvitaeapp.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.asm.curriculumvitaeapp.R;
import com.asm.curriculumvitaeapp.core.CurriculumVitaeApp;
import com.asm.curriculumvitaeapp.core.CurriculumVitaeAppUtils;


public class MainActivity extends Activity {

    private final String TAG = MainActivity.class.getCanonicalName();
    private ImageView ic_action_call, ic_action_email;
    private Button buttonPersonalInfo, buttonExperience, buttonEducation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ic_action_call = (ImageView)findViewById(R.id.ic_action_call);
        ic_action_email = (ImageView)findViewById(R.id.ic_action_email);
        buttonPersonalInfo = (Button)findViewById(R.id.button_show_personal_info);
        buttonExperience = (Button)findViewById(R.id.button_show_professional_experience);
        buttonEducation = (Button)findViewById(R.id.button_show_education);

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
                askUserToCall();
            }
        });
        ic_action_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askUserToSendEmail();
            }
        });
    }

    @Override
    public void onBackPressed(){
        askUserToExit();
    }

    private void startEducationActivity() {
        Intent intent = new Intent(CurriculumVitaeApp.getContext(), EducationActivity.class);
        startActivity(intent);
    }

    private void startExperienceActivity() {
        Intent intent = new Intent(CurriculumVitaeApp.getContext(), ExperienceActivity.class);
        startActivity(intent);
    }

    private void startPersonalInformationActivity() {
        Intent intent = new Intent(CurriculumVitaeApp.getContext(), PersonalInformationActivity.class);
        startActivity(intent);
    }

    private void askUserToExit(){
        AlertDialog dialog = CurriculumVitaeAppUtils.alertDialog(this, true, getString(R.string.question_exit), "", getString(R.string.exit), getString(R.string.cancel),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        goToHomePage();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        dialog.show();
    }

    private void goToHomePage() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(startMain);
        finish();
    }

    private void askUserToCall(){
        AlertDialog dialog = CurriculumVitaeAppUtils.alertDialog(this, true, getString(R.string.question_call), "", getString(R.string.yes), getString(R.string.cancel),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callMe();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        dialog.show();
    }

    private void askUserToSendEmail(){
        AlertDialog dialog = CurriculumVitaeAppUtils.alertDialog(this, true, getString(R.string.question_send_email), "", getString(R.string.yes), getString(R.string.cancel),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        CurriculumVitaeAppUtils.showAlertDialogForContactDetails(CurriculumVitaeApp.getContext());
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        dialog.show();
    }

    private void callMe(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:0034670998593"));
        startActivity(intent);
    }

}
