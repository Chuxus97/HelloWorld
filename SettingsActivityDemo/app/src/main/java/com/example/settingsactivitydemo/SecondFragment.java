package com.example.settingsactivitydemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

public class SecondFragment extends PreferenceFragmentCompat {
    private Context mContext;

    private static final String COTEGORY_DARK_MODE = "dark_mode";
    private static final String PREFERENCE_TIMED = "timed_on_off";
    private static final String PREFERENCE_MORE_SETTINGS = "more_darkmode_settings";
    private static final String COTEGORY_SYSTEM = "system";
    private static final String PREFERENCE_VRMODE = "vr_mode";
    private static final String PREFERENCE_ROTATION = "rotation_device";

    private PreferenceCategory mDarkModeCategory;
    private Preference mTimedOnOffPreference;
    private Preference mMoreSettingsPreference;

    private PreferenceCategory mSystemCategory;
    private Preference mVrModePreference;
    private Preference mRotationPreference;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获取控件
        mDarkModeCategory = findPreference(COTEGORY_DARK_MODE);
        mTimedOnOffPreference = findPreference(PREFERENCE_TIMED);
        mMoreSettingsPreference = findPreference(PREFERENCE_MORE_SETTINGS);
        mSystemCategory = findPreference(COTEGORY_SYSTEM);
        mVrModePreference = findPreference(PREFERENCE_VRMODE);
        mRotationPreference = findPreference(PREFERENCE_ROTATION);
        initPreferenceOnClickListener();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.second_preferences);
    }

    //初始化控件点击操作
    private void initPreferenceOnClickListener() {
        mRotationPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Log.i("Rose-Preference","onPreferenceClick");
                return false;
            }
        });

        mRotationPreference.getPreferenceManager().setOnPreferenceTreeClickListener(new PreferenceManager.OnPreferenceTreeClickListener() {
            @Override
            public boolean onPreferenceTreeClick(Preference preference) {
                Log.i("Rose-Preference","onPreferenceTreeClick");
                return false;
            }
        });

        mRotationPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Log.i("Rose-Preference","onPreferenceChange");
                //Context.MODE_PRIVATE  默认模式，如果有，会替换
                //Context.MODE_APPEND  如果已经存在key，则对value进行追加
                //Context.MODE_WORLD_READABLE  非app是否可以读
                //Context.MODE_WORLD_WRITEABLE  非app是否可以写
                preference.getPreferenceManager().setSharedPreferencesMode(Context.MODE_PRIVATE);
                SharedPreferences sharedPreferences = preference.getSharedPreferences();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("demo_name", "Rose");
                edit.putInt("demo_age", 29);
                edit.apply();
                String name = sharedPreferences.getString("demo_name","defaultValue");
                int age = sharedPreferences.getInt("demo_age",-1);
                return false;
            }
        });
    }
}
