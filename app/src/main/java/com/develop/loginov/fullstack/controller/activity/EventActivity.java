package com.develop.loginov.fullstack.controller.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.develop.loginov.fullstack.R;
import com.develop.loginov.fullstack.dialog.CourseDescriptionDialog;

public class EventActivity extends CourseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ImageView lockView = findViewById(R.id.activity_course__lock);
        lockView.setVisibility(View.GONE);
        final TextView textMembers = findViewById(R.id.activity_course__members);
        textMembers.setText(R.string.sample_members_count_event);
    }
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.course_setting_edit:
                return true;
            case R.id.course_setting_description:
                final CourseDescriptionDialog dialog = CourseDescriptionDialog.newInstance();
                dialog.show(getSupportFragmentManager(), "Course description");
                return true;
            case android.R.id.home:
                finish();
                return true;
        }
        return false;
    }
}
