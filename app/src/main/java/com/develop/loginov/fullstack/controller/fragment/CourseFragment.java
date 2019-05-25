package com.develop.loginov.fullstack.controller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.develop.loginov.fullstack.R;
import com.develop.loginov.fullstack.adapter.CourseAdapter;
import com.develop.loginov.fullstack.model.Course;

import java.util.Arrays;
import java.util.List;

public class CourseFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    private List<Course> list;
    private RecyclerView.Adapter adapter;

    public CourseFragment() {
    }

    public static CourseFragment newInstance(final int columnCount) {
        CourseFragment fragment = new CourseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_course_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            list = getCourses();
            adapter = new CourseAdapter(list);

            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    private List<Course> getCourses() {
        return Arrays.asList(Course.of("Spring", "Пётр Иванов", R.drawable.sample_image, 30, 12), Course.of(getString(R.string.name_sample), "Пётр Иванов", R.drawable.sample_image, 30, 12), Course.of("Spring", "Пётр Иванов", R.drawable.sample_image, 30, 12), Course.of(getString(R.string.name_sample), "Пётр Иванов", R.drawable.sample_image, 30, 12), Course.of("Android", "Пётр Иванов", R.drawable.sample_image, 25, 18));
    }


}
