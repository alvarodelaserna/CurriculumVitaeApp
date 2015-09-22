package com.asm.curriculumvitaeapp.core;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.asm.curriculumvitaeapp.R;

/**
 * Created by alvaro on 16/09/15.
 */
public class CurriculumVitaeAppUtils {

    private static Context context;

    public CurriculumVitaeAppUtils(Context context){
        CurriculumVitaeAppUtils.context = context;
    }

    public static void askUserToExit(){
        AlertDialog dialog = CurriculumVitaeAppUtils.alertDialog(context, true, context.getString(R.string.question_exit), "", context.getString(R.string.exit), context.getString(R.string.cancel),
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

    private static void goToHomePage() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(startMain);
        ((Activity)context).finish();
    }

    public static void askUserToCall(){
        AlertDialog dialog = CurriculumVitaeAppUtils.alertDialog(context, true, context.getString(R.string.question_call), "", context.getString(R.string.yes), context.getString(R.string.cancel),
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

    public static void askUserToSendEmail(){
        AlertDialog dialog = CurriculumVitaeAppUtils.alertDialog(context, true, context.getString(R.string.question_send_email), "", context.getString(R.string.yes), context.getString(R.string.cancel),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        CurriculumVitaeAppUtils.showAlertDialogForContactDetails(context);
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        dialog.show();
    }

    private static void callMe(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:0034670998593"));
        context.startActivity(intent);
    }


    private static AlertDialog alertDialog(Context context, boolean cancelable, String title, String msg, String positive, String negative,
                                           DialogInterface.OnClickListener positiveOnClickListener, DialogInterface.OnClickListener negativeOnClickListener, ViewGroup layout) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder
                .setTitle(title)
                .setMessage(msg)
                .setCancelable(cancelable);
        if(layout!= null) {
            alertDialogBuilder.setView(layout);
        }
        if(positive != null){
            alertDialogBuilder.setPositiveButton(positive, positiveOnClickListener); //listener can be null
        }
        if(negative != null){
            alertDialogBuilder.setNegativeButton(negative, negativeOnClickListener); //listener can be null
        }
        return alertDialogBuilder.create();
    }

    private static AlertDialog alertDialog(Context context, boolean cancelable, String title, String msg, String positive, String negative,
                                           DialogInterface.OnClickListener positiveOnClickListener, DialogInterface.OnClickListener negativeOnClickListener) {
        return CurriculumVitaeAppUtils.alertDialog(context, cancelable, title, msg, positive, negative, positiveOnClickListener, negativeOnClickListener, null);
    }

    private static void showAlertDialogForContactDetails(final Context context) {

        final LinearLayout layout = new LinearLayout(context);
        final EditText editName = new EditText(context);
        final EditText editCompany = new EditText(context);

        editName.setHint("Full name");
        editCompany.setHint("Company name");
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(editName);
        layout.addView(editCompany);

        final AlertDialog dialog = CurriculumVitaeAppUtils.alertDialog(context, false, context.getString(R.string.great), context.getString(R.string.enter_contact_details), context.getString(R.string.OK), context.getString(R.string.cancel), null, null, layout);
        dialog.show();
        // Override positive listener after showing (otherwise we cant obtain positive button)
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String company = editCompany.getText().toString();
                if (!name.isEmpty() && !company.isEmpty()) {
                    dialog.dismiss();
                    sendEmail(name, company);
                } else {
                    Toast.makeText(context, context.getString(R.string.empty_fields), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private static void sendEmail(String name, String company) {
        String text = "Hello, my name is " + name + " from: " + company + ".\nI found your CV very interesting. Please contact me ASAP.\nBest regards, \n" + name;
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "alvaro.delaserna@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, name + " from " + company);
        emailIntent.putExtra(Intent.EXTRA_TEXT, text);
        context.startActivity(Intent.createChooser(emailIntent, "Send mail using..."));
    }

}
