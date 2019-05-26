package com.develop.loginov.fullstack.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.develop.loginov.fullstack.R;

public class CourseDescriptionDialog extends BottomSheetDialogFragment {
    public CourseDescriptionDialog() {
    }

    public static CourseDescriptionDialog newInstance() {
        final Bundle args = new Bundle();
        final CourseDescriptionDialog fragment = new CourseDescriptionDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.course_description_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getContext() == null) {
            return;
        }
        final ListView listView = view.findViewById(R.id.course_description_dialog__contact_content);
        final String[] links = getLinks();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.simple_text_item, links);
        listView.setAdapter(arrayAdapter);
    }

    private String[] getLinks() {
        return new String[]{"Петр Иванов", "вк: @petrIvan", "telegram: @petrIvan"};
    }
}
