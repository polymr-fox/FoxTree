package com.develop.loginov.fullstack.controller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.develop.loginov.fullstack.R;
import com.develop.loginov.fullstack.adapter.ArticleAdapter;
import com.develop.loginov.fullstack.listeners.OnItemClickListener;
import com.develop.loginov.fullstack.model.Article;
import com.develop.loginov.fullstack.model.helper.HardCodeHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.develop.loginov.fullstack.model.helper.HardCodeHelper.*;

public class ArticleFragment extends Fragment {

    private List<Article> list;
    private RecyclerView.Adapter adapter;
    private OnItemClickListener onArticleClickListener;

    public ArticleFragment() {
    }

    public static ArticleFragment newInstance() {
        ArticleFragment fragment = new ArticleFragment();
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
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_article_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (view instanceof RecyclerView) {
            final Context context = view.getContext();
            final RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            list = getArticles();
            adapter = new ArticleAdapter(list, onArticleClickListener);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemClickListener) {
            onArticleClickListener = (OnItemClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onArticleClickListener = null;
    }

    private List<Article> getArticles() {
        final List<Article> articles = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            articles.add(Article.of(getName(), "vdvd", getAuthorName(), getRate(), getDate()));
        }
        return articles;
//
//        return Arrays.asList(Article.of(getString(R.string.sample_course_name),
//                                        getString(R.string.big_text),
//                                        getString(R.string.sample_person_name),
//                                        random.nextInt(50) - 25,
//                                        "12/10/2019"),
//                             Article.of(getString(R.string.sample_course_name),
//                                        getString(R.string.big_text),
//                                        getString(R.string.sample_person_name),
//                                        random.nextInt(50) - 25,
//                                        "12/10/2019"),
//                             Article.of(getString(R.string.sample_course_name),
//                                        getString(R.string.big_text),
//                                        getString(R.string.sample_person_name),
//                                        random.nextInt(50) - 25,
//                                        "12/10/2019"),
//                             Article.of(getString(R.string.sample_course_name),
//                                        getString(R.string.big_text),
//                                        getString(R.string.sample_person_name),
//                                        random.nextInt(50) - 25,
//                                        "12/10/2019"),
//                             Article.of(getString(R.string.sample_course_name),
//                                        getString(R.string.big_text),
//                                        getString(R.string.sample_person_name),
//                                        random.nextInt(50) - 25,
//                                        "12/10/2019"),
//                             Article.of(getString(R.string.sample_course_name),
//                                        getString(R.string.big_text),
//                                        getString(R.string.sample_person_name),
//                                        random.nextInt(50) - 25,
//                                        "12/10/2019"));
    }

    private void getArticles(final List<Article> articles, final RecyclerView.Adapter adapter) {
        new Thread(() -> {
            articles.addAll(getArticles());
            adapter.notifyDataSetChanged();
        }).start();
    }

}
