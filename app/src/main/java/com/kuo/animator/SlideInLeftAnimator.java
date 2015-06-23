package com.kuo.animator;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by User on 2015/6/20.
 */
public class SlideInLeftAnimator extends BaseItemAnimator {

    @Override
    protected void prepareAnimateRemove(RecyclerView.ViewHolder holder) {

    }

    @Override
    protected void setAnimateRemove(RecyclerView.ViewHolder holder) {

        final View view = holder.itemView;
        final ViewPropertyAnimatorCompat animation = ViewCompat.animate(view);

        animation
                .translationX(-holder.itemView.getWidth())
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
        ViewCompat.setTranslationX(holder.itemView, -holder.itemView.getWidth());
    }

    @Override
    protected void setAnimateAdd(RecyclerView.ViewHolder holder) {

        final View view = holder.itemView;
        final ViewPropertyAnimatorCompat animation = ViewCompat.animate(view);

        animation
                .translationX(0)
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
