package com.asm.curriculumvitaeapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asm.curriculumvitaeapp.R;

public class JobFragment extends Fragment {

    private static final String COMPANY_NAME = "name";
    private static final String JOB_DURATION = "duration";
    private static final String JOB_DESCRIPTION = "description";
    private static final String JOB_SKILLS = "skills";

    // TODO: Rename and change types of parameters
    private String companyName, jobDuration, jobDescription, jobSkills;

    private OnFragmentInteractionListener mListener;

    public static JobFragment newInstance(String companyName, String jobDuration,
                                          String jobDescription, String jobSkills) {
        JobFragment fragment = new JobFragment();
        Bundle args = new Bundle();
        args.putString(COMPANY_NAME, companyName);
        args.putString(JOB_DURATION, jobDuration);
        args.putString(JOB_DESCRIPTION, jobDescription);
        args.putString(JOB_SKILLS, jobSkills);
        fragment.setArguments(args);
        return fragment;
    }

    public JobFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            companyName = getArguments().getString(COMPANY_NAME);
            jobDuration = getArguments().getString(JOB_DURATION);
            jobDescription = getArguments().getString(JOB_DESCRIPTION);
            jobSkills = getArguments().getString(JOB_SKILLS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job, container, false);
        ImageView company_logo = (ImageView)view.findViewById(R.id.company_logo);
        TextView working_period = (TextView)view.findViewById(R.id.working_period);
        TextView job_description = (TextView)view.findViewById(R.id.job_description);
        TextView job_skills = (TextView)view.findViewById(R.id.job_skills);
        working_period.setText(jobDuration);
        job_description.setText(jobDescription);
        job_skills.setText(jobSkills);
        if(companyName.equals("Tapap")) {
            company_logo.setImageResource(R.drawable.logo_tapap);
        }else if(companyName.equals("Progressive Blue Technology")) {
            company_logo.setImageResource(R.drawable.logo_progressive_blue);
        }else if(companyName.equals("Fundosa Technosite")) {
                company_logo.setImageResource(R.drawable.logo_technosite);
        }
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

}
