package com.asm.curriculumvitaeapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
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

    // TODO: Rename and change types of parameters
    private String companyName, jobDuration, jobDescription;

    private OnFragmentInteractionListener mListener;

    public static JobFragment newInstance(String companyName, String jobDuration, String jobDescription) {
        JobFragment fragment = new JobFragment();
        Bundle args = new Bundle();
        args.putString(COMPANY_NAME, companyName);
        args.putString(JOB_DURATION, jobDuration);
        args.putString(JOB_DESCRIPTION, jobDescription);
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job, container, false);
        ImageView company_logo = (ImageView)view.findViewById(R.id.company_logo);
        TextView working_period = (TextView)view.findViewById(R.id.working_period);
        TextView job_description = (TextView)view.findViewById(R.id.job_description);
        working_period.setText(jobDuration);
        job_description.setText(jobDescription);
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
