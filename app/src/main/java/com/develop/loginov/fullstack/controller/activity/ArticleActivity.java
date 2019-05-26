package com.develop.loginov.fullstack.controller.activity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.develop.loginov.fullstack.R;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
//        setCustomActionBar();
    }
    private void setCustomActionBar() {
        final Toolbar toolbar = findViewById(R.id.activity_article__toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        if (toolbar.getOverflowIcon() != null) {
            toolbar.getOverflowIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        }

        if (toolbar.getNavigationIcon() != null) {
            toolbar.getNavigationIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        }
    }
}
