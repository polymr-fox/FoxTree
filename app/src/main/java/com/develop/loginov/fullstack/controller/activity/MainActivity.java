package com.develop.loginov.fullstack.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.develop.loginov.fullstack.R;
import com.develop.loginov.fullstack.controller.fragment.ArticleFragment;
import com.develop.loginov.fullstack.controller.fragment.CourseFragment;
import com.develop.loginov.fullstack.controller.fragment.EventFragment;
import com.develop.loginov.fullstack.controller.fragment.HomeFragment;
import com.develop.loginov.fullstack.model.Course;

import static com.develop.loginov.fullstack.model.helper.FragmentHelper.*;

public class MainActivity extends AppCompatActivity implements CourseFragment.OnCourseClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final BottomNavigationView navView = findViewById(R.id.activity_main__nav_view);
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        changeFragment(new CourseFragment(), getSupportFragmentManager(), R.id.activity_main__container);
        navView.setSelectedItemId(R.id.navigation_courses);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    changeFragment(HomeFragment.newInstance(), getSupportFragmentManager(), R.id.activity_main__container);
                    return true;
                case R.id.navigation_events:
                    changeFragment(new EventFragment(), getSupportFragmentManager(), R.id.activity_main__container);
                    return true;
                case R.id.navigation_courses:
                    changeFragment(new CourseFragment(), getSupportFragmentManager(), R.id.activity_main__container);
                    return true;
                case R.id.navigation_articles:
                    changeFragment(new ArticleFragment(), getSupportFragmentManager(), R.id.activity_main__container);
                    return true;
            }
            return false;
        }
    };


    @Override
    public void onCourseClick(final Course course) {
        final Intent intent = new Intent(MainActivity.this, CourseActivity.class);
        //TODO put records from course // put id course
        startActivity(intent);
    }
}
