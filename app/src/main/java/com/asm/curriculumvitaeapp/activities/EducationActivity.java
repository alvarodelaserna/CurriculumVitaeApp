package com.asm.curriculumvitaeapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.asm.curriculumvitaeapp.R;
import com.asm.curriculumvitaeapp.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EducationActivity extends Activity {

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        expandableListView = (ExpandableListView) findViewById(R.id.expandable_list_view);
        prepareListData();

        expandableListAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expandableListView.setAdapter(expandableListAdapter);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        listDataHeader.add("Master's Degree in Multimedia and Communications");
        listDataHeader.add("Bachelor's Degree in Audiovisual Systems Engineering");
        listDataHeader.add("Skills");

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


        listDataChild.put(listDataHeader.get(0), masters); // Header, Child data
        listDataChild.put(listDataHeader.get(1), bachelors);
        listDataChild.put(listDataHeader.get(2), skills);
    }

}
