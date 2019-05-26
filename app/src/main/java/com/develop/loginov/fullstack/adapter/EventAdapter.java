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
import com.develop.loginov.fullstack.model.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private final List<Event> events;
    private final OnItemClickListener onEventClickListener;

    public EventAdapter(List<Event> events, OnItemClickListener onEventClickListener) {
        this.events = events;
        this.onEventClickListener = onEventClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.bind(events.get(position));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameView;
        private final TextView authorView;
        private final TextView membersView;
        private final TextView placeView;
        private final TextView dateView;
        private final ImageView imageView;


        ViewHolder(final View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.item_event__name);
            authorView = itemView.findViewById(R.id.item_event__author);
            membersView = itemView.findViewById(R.id.item_event__count_members);
            placeView = itemView.findViewById(R.id.item_event__place);
            dateView = itemView.findViewById(R.id.item_event__date);
            imageView = itemView.findViewById(R.id.item_event__image);
        }

        @SuppressLint("SetTextI18n")
        void bind(final Event event) {
            assert event != null;
            nameView.setText(event.getName());
            authorView.setText(event.getAuthorName());
            membersView.setText(Integer.toString(event.getCountMembers()));
            placeView.setText(event.getPlace());
            dateView.setText(event.getDate());
            imageView.setImageResource(event.getPictureId());
            if(onEventClickListener != null){
                itemView.setOnClickListener(v -> onEventClickListener.onClick(event));
            }
        }
    }
}
