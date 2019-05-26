package com.develop.loginov.fullstack.controller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.develop.loginov.fullstack.R;
import com.develop.loginov.fullstack.adapter.EventAdapter;
import com.develop.loginov.fullstack.listeners.OnItemClickListener;
import com.develop.loginov.fullstack.model.Event;

import java.util.ArrayList;
import java.util.List;

import static com.develop.loginov.fullstack.model.helper.HardCodeHelper.getAuthorName;
import static com.develop.loginov.fullstack.model.helper.HardCodeHelper.getDate;
import static com.develop.loginov.fullstack.model.helper.HardCodeHelper.getDrawable;
import static com.develop.loginov.fullstack.model.helper.HardCodeHelper.getMembers;
import static com.develop.loginov.fullstack.model.helper.HardCodeHelper.getName;
import static com.develop.loginov.fullstack.model.helper.HardCodeHelper.getPlace;

public class EventFragment extends Fragment {
    private static final String ARG_COLUMN_COUNT = "column-count";

    private List<Event> list;
    private RecyclerView.Adapter adapter;
    private OnItemClickListener onEventClickListener;

    public EventFragment() {
    }

    public static EventFragment newInstance(final int columnCount) {
        EventFragment fragment = new EventFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            final Context context = view.getContext();
            final RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            list = new ArrayList<>();
            adapter = new EventAdapter(list, onEventClickListener);
            recyclerView.setAdapter(adapter);
            getEvents(list, adapter);
        }
        return view;
    }

    private List<Event> getEvents() {
        List<Event> events = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            events.add(Event.of(getName(),
                                getAuthorName(),
                                getDrawable(),
                                getDate(),
                                getPlace(),
                                getMembers()));
        }

        return events;
    }

    private void getEvents(final List<Event> events, final RecyclerView.Adapter adapter) {
        new Thread(() -> {
            events.addAll(getEvents());
            adapter.notifyDataSetChanged();
        }).start();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemClickListener) {
            onEventClickListener = (OnItemClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onEventClickListener = null;
    }
}
