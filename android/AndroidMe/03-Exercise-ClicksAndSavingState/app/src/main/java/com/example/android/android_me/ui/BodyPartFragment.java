/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    // COMPLETED (3) Create final Strings to store state information about the list of images and list index
    public static final String BUNDLE_IMAGE_ID_LIST = "BUNDLE_IMAGE_ID_LIST";
    public static final String BUNDLE_LIST_INDEX = "BUNDLE_LIST_INDEX";

    // Tag for logging
    private static final String TAG = "BodyPartFragment";

    // Variables to store a list of image resources and the index of the image that this fragment displays
    private List<Integer> mImageIds;
    private int mListIndex;
    private ImageView bodyPartImageView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment
     */
    public BodyPartFragment() {
    }

    /**
     * Inflates the fragment layout file and sets the correct resource for the image to display
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the Android-Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        if (savedInstanceState != null) {
            if (savedInstanceState.getIntegerArrayList(BUNDLE_IMAGE_ID_LIST) != null) {
                mImageIds = savedInstanceState.getIntegerArrayList(BUNDLE_IMAGE_ID_LIST);
            }
            mListIndex = savedInstanceState.getInt(BUNDLE_LIST_INDEX);
        }

        // Get a reference to the ImageView in the fragment layout
        bodyPartImageView = rootView.findViewById(R.id.body_part_image_view);
        bodyPartImageView.setOnClickListener(onBodyPartClickListener);
        updateBodyPartImage(mListIndex);

        // Return the rootView
        return rootView;
    }

    // Setter methods for keeping track of the list images this fragment can display and which image
    // in the list is currently being displayed

    public void setImageIds(List<Integer> imageIds) {
        mImageIds = imageIds;
    }

    public void setListIndex(int index) {
        mListIndex = index;
    }

    private View.OnClickListener onBodyPartClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mImageIds != null && mImageIds.size() > mListIndex) {
                mListIndex++;
            } else {
                mListIndex = 0;
            }
            updateBodyPartImage(mListIndex);
        }
    };

    private void updateBodyPartImage(int bodyPartIndex) {
        if (
                bodyPartImageView != null
                && mImageIds != null
                && mImageIds.size() > bodyPartIndex
        ) {
            bodyPartImageView.setImageResource(mImageIds.get(bodyPartIndex));
        }
    }

    // COMPLETED (4) Override onSaveInstanceState and save the current state of this fragment

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(BUNDLE_IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        outState.putInt(BUNDLE_LIST_INDEX, mListIndex);
    }
}
