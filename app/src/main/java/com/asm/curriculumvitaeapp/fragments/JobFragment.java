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

    // TODO: Rename and change types of parameters
    private String companyName;

    private OnFragmentInteractionListener mListener;

    public static JobFragment newInstance(String companyName) {
        JobFragment fragment = new JobFragment();
        Bundle args = new Bundle();
        args.putString(COMPANY_NAME, companyName);
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        if(companyName.equals("Tapap")){
            view = inflater.inflate(R.layout.fragment_tapap, container, false);
        }else if (companyName.equals("Progressive Blue Technology")){
            view = inflater.inflate(R.layout.fragment_progressive_blue, container, false);
        }else if (companyName.equals("Fundosa Technosite")){
            view = inflater.inflate(R.layout.fragment_technosite, container, false);
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
