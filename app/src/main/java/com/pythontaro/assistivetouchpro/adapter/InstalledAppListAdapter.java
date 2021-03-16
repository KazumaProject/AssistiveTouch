package com.pythontaro.assistivetouchpro.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pythontaro.assistivetouchpro.R;
import com.pythontaro.assistivetouchpro.model.AppDetails;

import java.util.ArrayList;
import java.util.List;

public class InstalledAppListAdapter extends RecyclerView.Adapter<InstalledAppListAdapter.ViewHolder> implements Filterable {

    private static RecyclerOnClickListener recyclerOnClickListener;

    static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView appLabel;
        private final ImageView appIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            appLabel = itemView.findViewById(R.id.installedAppList_Label);
            appIcon = itemView.findViewById(R.id.installedAppList_Icon);
        }
    }

    private final Context mContext;
    private final LayoutInflater layoutInflater;
    private final List<AppDetails> apps;
    private final List<AppDetails> apps_full;

    public InstalledAppListAdapter(Context context, List<AppDetails> apps){
        this.mContext = context;
        this.layoutInflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.apps = apps;
        apps_full = new ArrayList<>(apps);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = layoutInflater.inflate(R.layout.grid_items,parent,false);
        return new ViewHolder(root);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation);
        animation.setStartOffset(position * 2);
        holder.itemView.startAnimation(animation);
        holder.appIcon.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_scale));

        holder.appIcon.setImageDrawable(apps.get(position).appIcon);
        holder.appLabel.setText(apps.get(position).appLabel);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerOnClickListener.onItemClick(position,v,apps.get(position).appLabel,apps.get(position).packageName);
            }
        });
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    public void setOnItemClickListener(RecyclerOnClickListener recyclerOnClickListener){
        InstalledAppListAdapter.recyclerOnClickListener = recyclerOnClickListener;
    }

    @Override
    public Filter getFilter() {
        return setFilter;
    }

    private final Filter setFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<AppDetails> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(apps_full);
            }else {
                String filterPattern = constraint.toString().toUpperCase().trim();

                for (AppDetails appDetails : apps_full){
                    if (appDetails.appLabel.toUpperCase().startsWith(filterPattern)){
                        filteredList.add(appDetails);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            apps.clear();
            apps.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };

    public interface RecyclerOnClickListener {
        void onItemClick(int position, View view, String label, String packageName);
        void onItemLongClick(int position, View view, String label, String packageName);
    }
}
