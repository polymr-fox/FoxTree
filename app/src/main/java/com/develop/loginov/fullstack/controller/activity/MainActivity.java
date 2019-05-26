package com.develop.loginov.fullstack.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.develop.loginov.fullstack.R;
import com.develop.loginov.fullstack.controller.fragment.ArticleFragment;
import com.develop.loginov.fullstack.controller.fragment.CourseFragment;
import com.develop.loginov.fullstack.controller.fragment.EventFragment;
import com.develop.loginov.fullstack.controller.fragment.HomeFragment;
import com.develop.loginov.fullstack.listeners.OnItemClickListener;
import com.develop.loginov.fullstack.model.Article;
import com.develop.loginov.fullstack.model.Course;
import com.develop.loginov.fullstack.model.Event;

import static com.develop.loginov.fullstack.model.helper.FragmentHelper.*;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    private View collapseLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final BottomNavigationView navView = findViewById(R.id.activity_main__nav_view);
        collapseLayout = findViewById(R.id.activity_main__collapse_layout);
        collapseLayout.setVisibility(View.GONE);
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        changeFragment(new CourseFragment(),
                       getSupportFragmentManager(),
                       R.id.activity_main__container);
        navView.setSelectedItemId(R.id.navigation_courses);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                changeFragment(HomeFragment.newInstance(),
                               getSupportFragmentManager(),
                               R.id.activity_main__container);
                collapseLayout.setVisibility(View.VISIBLE);
                return true;
            case R.id.navigation_events:
                changeFragment(new EventFragment(),
                               getSupportFragmentManager(),
                               R.id.activity_main__container);
                collapseLayout.setVisibility(View.GONE);
                return true;
            case R.id.navigation_courses:
                changeFragment(new CourseFragment(),
                               getSupportFragmentManager(),
                               R.id.activity_main__container);
                collapseLayout.setVisibility(View.GONE);
                return true;
            case R.id.navigation_articles:
                changeFragment(new ArticleFragment(),
                               getSupportFragmentManager(),
                               R.id.activity_main__container);
                collapseLayout.setVisibility(View.GONE);
                return true;
        }

        return false;
    };


    @Override
    public void onClick(final Object elem) {
        final Intent intent = new Intent();
        if (elem instanceof Event) {
            final Event event = (Event) elem;
            intent.setClass(MainActivity.this, EventActivity.class);
        } else if (elem instanceof Course) {
            final Course course = (Course) elem;
            intent.setClass(MainActivity.this, CourseActivity.class);
        } else if (elem instanceof Article) {
            final Article article = (Article) elem;
            intent.setClass(MainActivity.this, ArticleActivity.class);
        } else {
            return;
        }

        startActivity(intent);
    }
}
