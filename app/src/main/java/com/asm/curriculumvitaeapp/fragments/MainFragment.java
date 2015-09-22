package com.asm.curriculumvitaeapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.asm.curriculumvitaeapp.R;
import com.asm.curriculumvitaeapp.core.CurriculumVitaeApp;
import com.asm.curriculumvitaeapp.core.CurriculumVitaeAppUtils;

/**
 * Created by alvaro on 22/09/15.
 */
public class MainFragment extends Fragment {

    private static final String TAG_EXPERIENCE = "experience",
            TAG_PROGRESSIVE_BLUE = "progressive", TAG_TECHNOSITE = "technosite", TAG_MAIN = "main",
            TAG_PERSONAL_INFORMATION = "personal", TAG_EDUCATION = "education";
    private OnFragmentInteractionListener mListener;
    private ImageButton ic_action_call, ic_action_email, ic_action_linkedin;
    private ImageButton buttonPersonalInfo, buttonExperience, buttonEducation, buttonSkills;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initElements(view);
        setListenersToButtons();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
        try {
            mListener = (OnFragmentInteractionListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void setListenersToButtons() {
        buttonPersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToPersonalInformationFragment();
            }
        });
        buttonExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToExperienceFragment();
            }
        });
        buttonEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToEducationFragment();
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
        ic_action_linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkedInProfile();
            }
        });
    }

    private void openLinkedInProfile() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getResources().getString(R.string.linkedin_url)));
        Intent chooser = Intent.createChooser(intent, getString(R.string.open_with));
        startActivity(chooser);
    }

    private void initElements(View view) {
        ic_action_call = (ImageButton) view.findViewById(R.id.ic_action_call);
        ic_action_email = (ImageButton) view.findViewById(R.id.ic_action_email);
        ic_action_linkedin = (ImageButton) view.findViewById(R.id.ic_action_linkedin);
        buttonPersonalInfo = (ImageButton) view.findViewById(R.id.button_show_personal_info);
        buttonExperience = (ImageButton) view.findViewById(R.id.button_show_professional_experience);
        buttonEducation = (ImageButton) view.findViewById(R.id.button_show_education);
        buttonSkills = (ImageButton) view.findViewById(R.id.button_show_skills);
    }

    private void switchToPersonalInformationFragment(){
        PersonalInformationFragment personalInformationFragment = new PersonalInformationFragment();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,
                R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.replace(R.id.fragment_container, personalInformationFragment, TAG_PERSONAL_INFORMATION);
        fragmentTransaction.addToBackStack(TAG_PERSONAL_INFORMATION);
        fragmentTransaction.commit();
    }

    private void switchToExperienceFragment(){
        ExperienceFragment experienceFragment = new ExperienceFragment();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,
                R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.replace(R.id.fragment_container, experienceFragment, TAG_EXPERIENCE);
        fragmentTransaction.addToBackStack(TAG_EXPERIENCE);
        fragmentTransaction.commit();
    }

    private void switchToEducationFragment(){
        EducationFragment educationFragment = new EducationFragment();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,
                R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.replace(R.id.fragment_container, educationFragment, TAG_EDUCATION);
        fragmentTransaction.addToBackStack(TAG_EDUCATION);
        fragmentTransaction.commit();
    }
}
