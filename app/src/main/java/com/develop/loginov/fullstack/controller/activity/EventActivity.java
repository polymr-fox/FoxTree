package com.develop.loginov.fullstack.controller.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.develop.loginov.fullstack.R;

public class EventActivity extends CourseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ImageView lockView = findViewById(R.id.activity_course__lock);
        lockView.setVisibility(View.GONE);
        final TextView textMembers = findViewById(R.id.activity_course__members);
        textMembers.setText(R.string.sample_members_count_event);
    }
}
