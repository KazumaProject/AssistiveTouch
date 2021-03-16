package com.pythontaro.assistivetouchpro.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceViewHolder;

import com.pythontaro.assistivetouchpro.R;

public class CategoryRed extends PreferenceCategory {

    private Context context;

    public CategoryRed(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        TextView title = (TextView) holder.findViewById(android.R.id.title);
        title.setTextColor(ContextCompat.getColor(context, R.color.red));
    }
}
