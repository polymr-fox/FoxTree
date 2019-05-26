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

import com.develop.loginov.fullstack.adapter.EventAdapter;
import com.develop.loginov.fullstack.R;
import com.develop.loginov.fullstack.listeners.OnItemClickListener;
import com.develop.loginov.fullstack.model.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            final Context context = view.getContext();
            final RecyclerView recyclerView = (RecyclerView) view;
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            list = getEvents();
            adapter = new EventAdapter(list, onEventClickListener);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    private List<Event> getEvents() {
        return Arrays.asList(Event.of("BDSMeetup", "Петр Иванов", R.mipmap.ic_launcher_round, "12/12/2019 10:00", "СПБПУ, ГЗ, 237", 10),
                             Event.of("PolyHack", "Аркадий Логинов", R.mipmap.ic_launcher_round, "10/09/2019 13:00", "СПБПУ, НИК, А 2.17.1", 50),
                             Event.of("PolyContest", "Петр Иванов", R.mipmap.ic_launcher_round, "12/12/2019 12:00", "СПБПУ, Гидрак, 237", 50),
                             Event.of("PolyContest", "Петр Иванов", R.mipmap.ic_launcher_round, "12/12/2019 12:00", "СПБПУ, Гидрак, 237", 50),
                             Event.of("PolyContest", "Петр Иванов", R.mipmap.ic_launcher_round, "12/12/2019 12:00", "СПБПУ, Гидрак, 237", 50),
                             Event.of("PolyContest", "Петр Иванов", R.mipmap.ic_launcher_round, "12/12/2019 12:00", "СПБПУ, Гидрак, 237", 50),
                             Event.of("PolyContest", "Петр Иванов", R.mipmap.ic_launcher_round, "12/12/2019 12:00", "СПБПУ, Гидрак, 237", 50),
                             Event.of("PolyHui", "Аркадий Логинов", R.mipmap.ic_launcher_round, "12/12/2019 11:00", "СПБПУ, 11к, 237", 20));
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
