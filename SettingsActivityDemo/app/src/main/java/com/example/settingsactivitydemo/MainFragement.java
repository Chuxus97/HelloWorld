package com.example.settingsactivitydemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class MainFragement extends PreferenceFragmentCompat {
    private static final String TAG = "Rose-Fragment";
    private Context mContext;
    private Preference mPreference;
    @Override
    public void onAttach(@NonNull Context context) {
        Log.i(TAG,"Now Fragment is onAttach");
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG,"Now Fragment is onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.root_preferences);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        Log.i(TAG,"Now Fragment is onCreateView");
        mPreference = getPreferenceScreen().findPreference("display_settings");
        Intent intent = new Intent(getActivity(), SecondActivity.class);
        mPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(intent);
                return false;
            }
        });
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable  Bundle savedInstanceState) {
        Log.i(TAG,"Now Fragment is onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i(TAG,"Now Fragment is onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG,"Now Fragment is onResume");
        super.onResume();
    }


    @Override
    public void onPause() {
        Log.i(TAG,"Now Fragment is onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG,"Now Fragment is onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG,"Now Fragment is onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.i(TAG,"Now Fragment is onDetach");
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"Now Fragment is onDestroy");
        super.onDestroy();
    }
}
