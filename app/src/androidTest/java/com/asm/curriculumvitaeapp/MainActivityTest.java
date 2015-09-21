package com.asm.curriculumvitaeapp;

import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.asm.curriculumvitaeapp.activities.MainActivity;

import org.junit.runner.RunWith;

/**
 * Created by alvaro on 21/09/15.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;
    private TextView my_name, button_show_personal_info, button_show_professional_experience, button_show_education;
    private ImageView my_picture;
    private ImageButton ic_action_call, ic_action_email;
    private String MY_NAME, EDUCATION, EXPERIENCE, PERSONAL_INFO;

    public MainActivityTest(Class<MainActivity> activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();
        MY_NAME = mainActivity.getResources().getString(R.string.my_name);
        EDUCATION = mainActivity.getResources().getString(R.string.education);
        EXPERIENCE = mainActivity.getResources().getString(R.string.experience);
        PERSONAL_INFO = mainActivity.getResources().getString(R.string.personal_info);
        my_name = (TextView) mainActivity.findViewById(R.id.name);
        my_picture = (ImageView) mainActivity.findViewById(R.id.picture_of_me);
        ic_action_call = (ImageButton) mainActivity.findViewById(R.id.ic_action_call);
        ic_action_email = (ImageButton) mainActivity.findViewById(R.id.ic_action_email);
        button_show_personal_info = (TextView) mainActivity.findViewById(R.id.button_show_personal_info);
        button_show_professional_experience = (TextView) mainActivity.findViewById(R.id.button_show_professional_experience);
        button_show_education = (TextView) mainActivity.findViewById(R.id.button_show_education);

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
        assertEquals(EDUCATION, (String) button_show_education.getText());
        assertEquals(PERSONAL_INFO, (String) button_show_personal_info.getText());
        assertEquals(EXPERIENCE, (String) button_show_professional_experience.getText());
    }
}
