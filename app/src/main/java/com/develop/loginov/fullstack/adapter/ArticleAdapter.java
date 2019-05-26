package com.develop.loginov.fullstack.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.develop.loginov.fullstack.R;
import com.develop.loginov.fullstack.listeners.OnItemClickListener;
import com.develop.loginov.fullstack.model.Article;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private final List<Article> articles;
    private final OnItemClickListener onArticleClickListener;
    private int maxRateLength;
    private int maxMessageLength;

    public ArticleAdapter(final List<Article> articles,
                          final OnItemClickListener onArticleClickListener) {
        this.articles = articles;
        this.onArticleClickListener = onArticleClickListener;
        maxRateLength = Collections.max(articles,
                                        Comparator.comparingInt(article -> Integer.toString(article.getRate()).length())).getRate();
        maxRateLength = Integer.toString(maxRateLength).length();
        maxMessageLength = Collections.max(articles,
                                           Comparator.comparingInt(article -> Integer.toString(
                                                   article.getCountMessage()).length())).getCountMessage();
        maxMessageLength = Integer.toString(maxMessageLength).length();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article,
                                                                     parent,
                                                                     false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.bind(articles.get(position));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameView;
        private final TextView authorView;
        private final TextView messageTextView;
        private final TextView rateTextView;
        private final TextView dateTextView;
        private final ImageView rateImageView;


        ViewHolder(final View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.item_article__name);
            authorView = itemView.findViewById(R.id.item_article__author);
            messageTextView = itemView.findViewById(R.id.item_article__message_count);
            dateTextView = itemView.findViewById(R.id.item_article__date);
            rateTextView = itemView.findViewById(R.id.item_article__rate_text);
            rateImageView = itemView.findViewById(R.id.item_article__rate_image);
        }

        @SuppressLint("SetTextI18n")
        void bind(final Article article) {
            assert article != null;
            nameView.setText(article.getName());
            authorView.setText(article.getAuthorName());
            messageTextView.setText(refactor(article.getCountMessage(), maxMessageLength));
            dateTextView.setText(article.getDate());

            final int rate = article.getRate();
            rateTextView.setText(refactor(rate, maxRateLength));
            if (rate < -2) {
                rateImageView.setImageResource(R.drawable.ic_red_top);
            } else if (rate <= 2) {
                rateImageView.setImageResource(R.drawable.ic_grey_top);
            } else {
                rateImageView.setImageResource(R.drawable.ic_green_top);
            }

            itemView.setOnClickListener(v -> onArticleClickListener.onClick(article));
        }

        private String refactor(final int value, final int maxLength) {
            StringBuilder result = new StringBuilder(Integer.toString(value));
            while (result.length() < maxLength) {
                result.insert(0, " ");
            }

            return result.toString();
        }
    }
}
