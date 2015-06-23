package com.kuo.simplerecyclerviewanimator;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by User on 2015/6/17.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView text;
    public CardView container;

    public ViewHolder(View itemView) {
        super(itemView);
        container = (CardView) itemView.findViewById(R.id.container);
        text = (TextView) itemView.findViewById(R.id.text);
    }
}
