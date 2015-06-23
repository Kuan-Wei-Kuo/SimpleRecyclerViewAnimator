package com.kuo.animator;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by User on 2015/6/22.
 */
public class ScaleInAnimator extends BaseItemAnimator {

    @Override
    protected void prepareAnimateRemove(RecyclerView.ViewHolder holder) {
        ViewCompat.setTranslationX(holder.itemView, 0);
        ViewCompat.setTranslationY(holder.itemView, 0);
        ViewCompat.setAlpha(holder.itemView, 1);
    }

    @Override
    protected void setAnimateRemove(RecyclerView.ViewHolder holder) {

        final View view = holder.itemView;
        final ViewPropertyAnimatorCompat animation = ViewCompat.animate(view);

        animation
                .scaleX(0).scaleY(0).alpha(1)
                .setDuration(getRemoveDuration())
                .setListener(new RemoveListenerAdapter(holder) {
                    @Override
                    protected void removeListener() {
                        animation.setListener(null);
                    }
                }).start();

    }

    @Override
    protected void prepareAnimateAdd(RecyclerView.ViewHolder holder) {
        ViewCompat.setTranslationX(holder.itemView, 0);
        ViewCompat.setTranslationY(holder.itemView, 0);
        ViewCompat.setScaleX(holder.itemView, 0);
        ViewCompat.setScaleY(holder.itemView, 0);
    }

    @Override
    protected void setAnimateAdd(RecyclerView.ViewHolder holder) {

        final View view = holder.itemView;
        final ViewPropertyAnimatorCompat animation = ViewCompat.animate(view);

        animation
                .scaleX(1).scaleY(1)
                .setDuration(getAddDuration())
                .setListener(new AddListenerAdapter(holder) {
                    @Override
                    protected void removeListener() {
                        animation.setListener(null);
                    }
                }).start();
    }

}
