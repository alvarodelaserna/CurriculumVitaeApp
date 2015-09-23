package com.asm.curriculumvitaeapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.asm.curriculumvitaeapp.R;
import com.asm.curriculumvitaeapp.adapters.ExpandableListAdapter;
import com.asm.curriculumvitaeapp.core.CurriculumVitaeApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by alvaro on 22/09/15.
 */
public class EducationFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ExpandableListAdapter expandableListAdapter;
    private ExpandableListView expandableListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    public EducationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_education, container, false);
        TextView master_url = (TextView) view.findViewById(R.id.master_url);
        master_url.setMovementMethod(LinkMovementMethod.getInstance());
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

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        listDataHeader.add("Master's Degree in Multimedia and Communications");
        listDataHeader.add("Bachelor's Degree in Audiovisual Systems Engineering");
        listDataHeader.add("Skills");
        listDataHeader.add("Languages");

        List<String> masters = new ArrayList<>();
        masters.add("2014 - 2015");
        masters.add("Data Science");
        masters.add("Machine learning");
        masters.add("Python");
        masters.add("SciKit learn");
        masters.add("Matlab");

        List<String> bachelors = new ArrayList<>();
        bachelors.add("2010 - 2014");
        bachelors.add("Telecommunications");
        bachelors.add("Java");
        bachelors.add("Matlab");
        bachelors.add("Android Development");
        bachelors.add("HTML");
        bachelors.add("CSS");

        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Matlab");
        skills.add("Android Development");
        skills.add("Android Studio");
        skills.add("Eclipse");
        skills.add("Machine learning");
        skills.add("Python");
        skills.add("SciKit learn");
        skills.add("JavaScript");
        skills.add("LaTeX");
        skills.add("Shell scripting");
        skills.add("NodeJS");

        List<String> languages = new ArrayList<>();
        languages.add("Spanish - Mother tongue");
        languages.add("English - Full professional competences. Certificate in Advanced English");
        languages.add("French - Basic competences");

        listDataChild.put(listDataHeader.get(0), masters); // Header, Child data
        listDataChild.put(listDataHeader.get(1), bachelors);
        listDataChild.put(listDataHeader.get(2), skills);
        listDataChild.put(listDataHeader.get(3), languages);
    }
}
