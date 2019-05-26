package com.develop.loginov.fullstack.controller.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.develop.loginov.fullstack.R;

import static com.develop.loginov.fullstack.model.helper.HardCodeHelper.getTextId;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        final TextView textView = findViewById(R.id.activity_article__text_content);
        textView.setText(getString(getTextId()));
    }

}
