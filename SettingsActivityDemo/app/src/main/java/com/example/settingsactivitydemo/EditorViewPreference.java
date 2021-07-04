package com.example.settingsactivitydemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

public class EditorViewPreference extends Preference {

    private boolean mIsUse;
    private String mDefaultValue;
    private EditText mEditText;

    public EditorViewPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.editor_view_preference);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EditorViewPreference);
        mDefaultValue = typedArray.getString(R.styleable.EditorViewPreference_defaulttext);
        mIsUse = typedArray.getBoolean(R.styleable.EditorViewPreference_shoulduse, false);
        typedArray.recycle();
    }

    public EditorViewPreference(Context context) {
        super(context);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        //这里可以获取layout中的控件，进行设置onClickListener等操作
        mEditText = (EditText) holder.findViewById(R.id.edit);
        if (mEditText != null) {
            mEditText.setText(mDefaultValue);
            mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    mEditText.setText("");
                }
            });
        }
        super.onBindViewHolder(holder);
    }

    public void setDefaultValue (String value) {
        mDefaultValue = value;
        notifyChanged();
    }
}
