package com.asm.curriculumvitaeapp;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.asm.curriculumvitaeapp.activities.MainActivity;

/**
 * Created by alvaro on 21/09/15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;
    private TextView my_name;
    private ImageButton button_show_personal_info, button_show_professional_experience, button_show_education, button_show_skills;
    private ImageView my_picture;
    private ImageButton ic_action_call, ic_action_email;
    private String MY_NAME;

    public MainActivityTest(Class<MainActivity> activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();
        MY_NAME = mainActivity.getResources().getString(R.string.my_name);
        my_name = (TextView) mainActivity.findViewById(R.id.name);
        my_picture = (ImageView) mainActivity.findViewById(R.id.picture_of_me);
        ic_action_call = (ImageButton) mainActivity.findViewById(R.id.ic_action_call);
        ic_action_email = (ImageButton) mainActivity.findViewById(R.id.ic_action_email);
        button_show_personal_info = (ImageButton) mainActivity.findViewById(R.id.button_show_personal_info);
        button_show_professional_experience = (ImageButton) mainActivity.findViewById(R.id.button_show_professional_experience);
        button_show_education = (ImageButton) mainActivity.findViewById(R.id.button_show_education);
        button_show_skills = (ImageButton) mainActivity.findViewById(R.id.button_show_skills);

    }

    public void testPreconditions() {
        assertNotNull("mainActivity is null", mainActivity);
        assertNotNull("my_name is null", my_name);
        assertNotNull("button_show_personal_info is null", button_show_personal_info);
        assertNotNull("button_show_professional_experience is null", button_show_professional_experience);
        assertNotNull("button_show_education is null", button_show_education);
        assertNotNull("my_picture is null", my_picture);
        assertNotNull("ic_action_call is null", ic_action_call);
        assertNotNull("ic_action_email is null", ic_action_email);
    }

    public void testText() {
        assertEquals(MY_NAME, (String) my_name.getText());
    }
}
