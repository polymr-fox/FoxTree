package com.develop.loginov.fullstack.controller.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.develop.loginov.fullstack.R;
import com.develop.loginov.fullstack.adapter.RecordAdapter;
import com.develop.loginov.fullstack.model.Record;

import java.util.Arrays;
import java.util.List;

public class CourseActivity extends AppCompatActivity {

    private List<Record> records;
    private RecyclerView.Adapter adapter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        setCustomActionBar();
        final RecyclerView recyclerView = findViewById(R.id.activity_course__recycler);
        records = getRecords();
        adapter = new RecordAdapter(records);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    void setCustomActionBar() {
        final Toolbar toolbar = findViewById(R.id.activity_course__toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }
        if (toolbar.getOverflowIcon() != null) {
            toolbar.getOverflowIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        }

        if (toolbar.getNavigationIcon() != null) {
            toolbar.getNavigationIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        }
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.course_setting_edit:
                Toast.makeText(CourseActivity.this, R.string.edit, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.course_setting_description:
                Toast.makeText(CourseActivity.this, R.string.description, Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
                finish();
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.course_settings_menu, menu);
        return true;
    }

    private List<Record> getRecords() {
        return Arrays.asList(Record.of("IOS Разработка", "cl;msalmcl;samc;lamlcewfjfjefiwefjiwefjwe"), Record.of("IOS Разработка", "cl;msalmcl;samc;lamlcewfjfjefiwefjiwefjwe"), Record.of("IOS Разработка", "clmkekcmekmkekmceklamlcewfjfjefiwjiwefjwe"), Record.of("IOS Разработка", "cl;msalmcl;samc;lamlcewfjfjefiwefjiwefjwe"), Record.of("IOS Разработка", "cl;msalmcl;samc;lamlcewfjfjefiwefjiwefjwe"), Record.of("IOS Разработка", "cl;msalmcl;samc;lamlcewfjfjefiwefjiwefjwe"));
    }
}
