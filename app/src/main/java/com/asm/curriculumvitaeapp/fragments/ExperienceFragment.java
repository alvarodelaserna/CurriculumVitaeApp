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

    private static final String TAG_EXPERIENCE = "experience", TAG_TAPAP = "tapap",
            TAG_PROGRESSIVE_BLUE = "progressive", TAG_TECHNOSITE = "technosite";
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

    private static JobFragment createJobFragment(String companyName){
        return JobFragment.newInstance(companyName);
    }

    private void switchToTapapFragment(){
        JobFragment jfTapap = createJobFragment("Tapap");
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,
                R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.replace(R.id.fragment_container, jfTapap, TAG_TAPAP);
        fragmentTransaction.addToBackStack(TAG_EXPERIENCE);
        fragmentTransaction.commit();
    }

    private void switchToProgressiveBlueFragment(){
        JobFragment jfProgressiveBlue = createJobFragment("Progressive Blue Technology");
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,
                R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.replace(R.id.fragment_container, jfProgressiveBlue, TAG_PROGRESSIVE_BLUE);
        fragmentTransaction.addToBackStack(TAG_EXPERIENCE);
        fragmentTransaction.commit();
    }

    private void switchToTechnositeFragment(){
        JobFragment jfTechnosite = createJobFragment("Fundosa Technosite");
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,
                R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.replace(R.id.fragment_container, jfTechnosite, TAG_TECHNOSITE);
        fragmentTransaction.addToBackStack(TAG_EXPERIENCE);
        fragmentTransaction.commit();
    }

}
