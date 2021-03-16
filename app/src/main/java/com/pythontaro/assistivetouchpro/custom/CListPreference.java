package com.pythontaro.assistivetouchpro.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceViewHolder;

import com.pythontaro.assistivetouchpro.R;

public class CListPreference extends ListPreference {

    private Context context;

    public CListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        TextView title = (TextView) holder.findViewById(android.R.id.title);
        TextView summary = (TextView) holder.findViewById(android.R.id.summary);
        title.setTextColor(ContextCompat.getColor(context, R.color.white));
        summary.setTextColor(ContextCompat.getColor(context, R.color.dark_silver));
    }
}
