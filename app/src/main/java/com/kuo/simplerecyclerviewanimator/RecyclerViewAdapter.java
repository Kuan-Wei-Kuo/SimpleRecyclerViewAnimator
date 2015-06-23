package com.kuo.simplerecyclerviewanimator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2015/6/17.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context context;
    private List<Integer> colors = new ArrayList<Integer>();

    private int lastPosition;

    public RecyclerViewAdapter(Context context, List<Integer> colors){

        this.context = context;
        this.colors = colors;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.text.setText("" + position);
        holder.container.setBackgroundResource(colors.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Click" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public void addColor(int color, int position){
        colors.add(position, color);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, getItemCount());
    }

    public void deleteColor(int position){
        colors.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }
}
