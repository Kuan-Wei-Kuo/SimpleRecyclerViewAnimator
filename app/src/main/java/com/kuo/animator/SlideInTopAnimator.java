package com.kuo.animator;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kuo.animator.BaseItemAnimator;

/**
 * Created by User on 2015/6/22.
 */
public class SlideInTopAnimator extends BaseItemAnimator {
    @Override
    protected void prepareAnimateRemove(RecyclerView.ViewHolder holder) {

    }

    @Override
    protected void setAnimateRemove(RecyclerView.ViewHolder holder) {

        final View view = holder.itemView;
        final ViewPropertyAnimatorCompat animation = ViewCompat.animate(view);

        animation
                .translationY(-holder.itemView.getHeight())
                .alpha(0)
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
        ViewCompat.setTranslationY(holder.itemView, -holder.itemView.getHeight());
        ViewCompat.setAlpha(holder.itemView, 0);
    }

    @Override
    protected void setAnimateAdd(RecyclerView.ViewHolder holder) {

        final View view = holder.itemView;
        final ViewPropertyAnimatorCompat animation = ViewCompat.animate(view);

        animation
                .translationY(0)
                .alpha(1)
                .setDuration(getAddDuration())
                .setListener(new AddListenerAdapter(holder) {
                    @Override
                    protected void removeListener() {
                        animation.setListener(null);
                    }
                }).start();
    }
}
