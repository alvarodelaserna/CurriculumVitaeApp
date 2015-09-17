package com.asm.curriculumvitaeapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.asm.curriculumvitaeapp.R;
import com.asm.curriculumvitaeapp.activities.MainActivity;

public class ExperienceFragment extends Fragment {

    private ImageButton tapap, progressive, technosite;

    private static final String TAG_TAPAP = "tapap";
    private final String TAG_PROGRESSIVE_BLUE = "progressive";
    private final String TAG_TECHNOSITE = "technosite";
    private OnFragmentInteractionListener mListener;

    public ExperienceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_experience, container, false);
        tapap = (ImageButton)view.findViewById(R.id.logo_tapap);
        progressive = (ImageButton)view.findViewById(R.id.logo_progressive);
        technosite = (ImageButton)view.findViewById(R.id.logo_technosite);
        tapap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToTapapFragment();
            }
        });
        progressive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToProgressiveBlueFragment();
            }
        });
        technosite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToTechnositeFragment();
            }
        });
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
        public void onFragmentInteraction(Uri uri);
    }

    private static JobFragment createJobFragment(String companyName, String jobDuration,
                                                 String jobDescription, String jobSkills){
        return JobFragment.newInstance(companyName, jobDuration, jobDescription, jobSkills);
    }

    private void switchToTapapFragment(){
        JobFragment jfTapap = createJobFragment("Tapap", "February 2015 - present", "Lead Android " +
                "Developer. I am in charge of making ideas come to life and bridging the gap between" +
                " Production, Design and Programming departments.", "Tools:\n"+"- Android Studio\n" +
                "- Java\n- REST\n- JSON\n- SQLite");
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, jfTapap, TAG_TAPAP);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void switchToProgressiveBlueFragment(){
        JobFragment jfProgressiveBlue = createJobFragment("Progressive Blue Technology", "November " +
                "2014 - February 2015", "I was in charge of developing different types of Android" +
                " applications depending on our clients' needs, working with Eclipse.", "Tools:\n"+
                "- Eclipse\n- Java\n- REST\n- JSON\n- SQLite\n- PHP");
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, jfProgressiveBlue, TAG_PROGRESSIVE_BLUE);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void switchToTechnositeFragment(){
        JobFragment jfTechnosite = createJobFragment("Fundosa Technosite", "June 2014 - August 2014", "I participated in the design and development of a contextual" +
                " help system working with OpenCV on Google Glass, as wellas a Gateway for the management of safety devices and" +
                " environments for telecare using Raspberry Pi and NodeJS.", "Tools:\n "+"- Eclipse\n" +
                "- Java\n- REST\n- JSON\n- OpenCV\n- Google Glass\n- RaspberryPi\n- NodeJS\n- Matlab\n- Bluetooth LTE");
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, jfTechnosite, TAG_TECHNOSITE);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
