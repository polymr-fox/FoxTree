package com.develop.loginov.fullstack.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.develop.loginov.fullstack.R;
import com.develop.loginov.fullstack.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private final List<Course> courses;

    public CourseAdapter(final List<Course> items) {
        courses = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.bind(courses.get(position));
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final Context context;
        final TextView nameCourseView;
        final TextView authorView;
        final TextView amountMembersView;
        final ImageView closeView;

        ViewHolder(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            nameCourseView = (TextView) itemView.findViewById(R.id.item_course__name);
            authorView = (TextView) itemView.findViewById(R.id.item_course__author);
            amountMembersView = (TextView) itemView.findViewById(R.id.item_course__members);
            closeView = (ImageView) itemView.findViewById(R.id.item_course__close);
        }

        void bind(final Course course) {
            assert course != null;
            nameCourseView.setText(course.getAuthorName());
            authorView.setText(course.getAuthorName());
            amountMembersView.setText(context.getString(R.string.members, course.getCurrentMembersCount(), course.getMaxMemberCount()));
//            closeView.setImageResource(course.isClose() ? );
        }
    }
}
