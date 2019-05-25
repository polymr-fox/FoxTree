package com.develop.loginov.fullstack.controller.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.develop.loginov.fullstack.R;


public class HomeFragment extends Fragment {

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setItemMenu(view, R.id.fragment_home__courses, R.string.title_courses, R.mipmap.ic_course);
        setItemMenu(view, R.id.fragment_home__articles, R.string.title_articles, R.mipmap.ic_article);
        setItemMenu(view, R.id.fragment_home__events, R.string.title_events, R.mipmap.ic_event);
        setItemMenu(view, R.id.fragment_home__like, R.string.title_like, R.mipmap.ic_like);
        setItemMenu(view, R.id.fragment_home__knowing, R.string.title_knowing, R.mipmap.ic_know);
        setItemMenu(view, R.id.fragment_home__vk, R.string.vk_sample, R.mipmap.ic_vk);
        setItemMenu(view, R.id.fragment_home__tg, R.string.tg_sample, R.mipmap.ic_telegram_4);
        setItemMenu(view, R.id.fragment_home__email, R.string.email_sample, R.mipmap.ic_mail);
    }

    private void setItemMenu(final View parent,
                             final int id,
                             final int textId,
                             final int drawableId) {
        final View itemView = parent.findViewById(id);
        final ImageView imageView = itemView.findViewById(R.id.menu_layout__image);
        final TextView textView = itemView.findViewById(R.id.menu_layout__text);
        imageView.setImageResource(drawableId);
        textView.setText(textId);
    }
}
