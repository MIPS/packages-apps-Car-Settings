/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.android.car.settings.common;

import android.os.Bundle;
import android.support.car.ui.PagedListView;

import com.android.car.settings.R;

import java.util.ArrayList;

/**
 * Settings page that only contain a list of items.
 */
public abstract class ListSettingsActivity extends CarSettingActivity {

    private PagedListView mListView;
    protected TypedPagedListAdapter mPagedListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paged_list);

        mListView = (PagedListView) findViewById(R.id.list);
        mListView.setDefaultItemDecoration(new NoDividerItemDecoration(this));
        mListView.setDarkMode();
        mPagedListAdapter = new TypedPagedListAdapter(this /* context */, getLineItems());
        mListView.setAdapter(mPagedListAdapter);
    }

    /**
     * Gets a List of LineItems to show up in this activity.
     */
    public abstract ArrayList<TypedPagedListAdapter.LineItem> getLineItems();
}
