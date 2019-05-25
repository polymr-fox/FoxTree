package com.develop.loginov.fullstack.controller.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.develop.loginov.fullstack.R;
import com.develop.loginov.fullstack.adapter.RecordAdapter;
import com.develop.loginov.fullstack.model.Record;

import java.util.Arrays;
import java.util.List;

public class CourseActivity extends AppCompatActivity {

    private List<Record> records;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        final RecyclerView recyclerView = findViewById(R.id.activity_course__recycler);

        records = getRecords();
        adapter = new RecordAdapter(records);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private List<Record> getRecords() {
        return Arrays.asList(Record.of("IOS Разработка", "cl;msalmcl;samc;lamlcewfjfjefiwefjiwefjwe"), Record.of("IOS Разработка", "cl;msalmcl;samc;lamlcewfjfjefiwefjiwefjwe"), Record.of("IOS Разработка", "clmkekcmekmkekmceklamlcewfjfjefiwjiwefjwe"), Record.of("IOS Разработка", "cl;msalmcl;samc;lamlcewfjfjefiwefjiwefjwe"), Record.of("IOS Разработка", "cl;msalmcl;samc;lamlcewfjfjefiwefjiwefjwe"), Record.of("IOS Разработка", "cl;msalmcl;samc;lamlcewfjfjefiwefjiwefjwe"));
    }
}
