/*
 * Copyright (C) 2016 The Android Open Source Project
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
 * limitations under the License.
 */

package com.example.android.databoundrecyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

import com.example.android.databoundrecyclerview.databinding.ActivityMainBinding;
import com.example.android.databoundrecyclerview.databinding.CityItemBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        CityAdapter adapter = new CityAdapter(new City("Istanbul"),
                new City("Barcelona"),
                new City("London"),
                new City("San Francisco"));
        binding.recyclerView.setAdapter(adapter);
    }

    private static class CityAdapter extends DataBoundAdapter<CityItemBinding> implements
            ActionCallback {
        List<City> mCityList = new ArrayList<>();

        public CityAdapter(City... cities) {
            super(R.layout.city_item);
            Collections.addAll(mCityList, cities);
        }

        @Override
        protected void bindItem(DataBoundViewHolder<CityItemBinding> holder, int position,
                List<Object> payloads) {
            holder.binding.setCity(mCityList.get(position));
            holder.binding.setCallback(this);
        }

        @Override
        public int getItemCount() {
            return mCityList.size();
        }

        @Override
        public void onClick(City city) {
            city.setFavorite(!city.isFavorite());
        }
    }
}
