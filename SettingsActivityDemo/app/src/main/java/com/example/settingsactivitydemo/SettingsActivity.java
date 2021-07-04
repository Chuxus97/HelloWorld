package com.example.settingsactivitydemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {
    private static final String TAG = "Rose-Activity";
    private Fragment mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Now Activity is onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        Intent intent = new Intent(this, SecondActivity.class);
        if (mFragment == null) {
            mFragment  = new MainFragement();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.miui_settings, mFragment);
            fragmentTransaction.commit();
        }

    }

    @Override
    protected void onStart() {
        Log.i(TAG, "Now Activity is onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "Now Activity is onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "Now Acitivity is onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "Now Acitivity is onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "Now Activity is onDestroy");
        super.onDestroy();
    }
}