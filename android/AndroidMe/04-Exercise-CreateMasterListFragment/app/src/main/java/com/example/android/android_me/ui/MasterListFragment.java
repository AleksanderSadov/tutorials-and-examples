package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class MasterListFragment extends Fragment {

    public MasterListFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_master_list, container, false);
        initMasterList(fragmentView);
        return fragmentView;
    }

    public void initMasterList(@NonNull View fragmentView) {
        GridView gridView = fragmentView.findViewById(R.id.grid_view_master_list);
        List<Integer> allBodyPartsImagesIds = AndroidImageAssets.getAll();
        MasterListAdapter masterListAdapter = new MasterListAdapter(fragmentView.getContext(), allBodyPartsImagesIds);
        gridView.setNumColumns(3);
        gridView.setAdapter(masterListAdapter);
    }
}
