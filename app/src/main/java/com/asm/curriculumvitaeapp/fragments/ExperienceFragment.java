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

public class ExperienceFragment extends Fragment {

    private static final String TAG_TAPAP = "tapap";
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
        ImageButton tapap = (ImageButton) view.findViewById(R.id.logo_tapap);
        ImageButton progressive = (ImageButton) view.findViewById(R.id.logo_progressive);
        ImageButton technosite = (ImageButton) view.findViewById(R.id.logo_technosite);
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
        void onFragmentInteraction(Uri uri);
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
        String TAG_PROGRESSIVE_BLUE = "progressive";
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
        String TAG_TECHNOSITE = "technosite";
        fragmentTransaction.replace(R.id.fragment_container, jfTechnosite, TAG_TECHNOSITE);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
