package com.kuo.animator;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by User on 2015/6/21.
 */
public class SlideInRightAnimator extends BaseItemAnimator {

    @Override
    protected void setAnimateRemove(final RecyclerView.ViewHolder holder) {

        final View view = holder.itemView;
        final ViewPropertyAnimatorCompat animation = ViewCompat.animate(view);

        animation
                .setDuration(getRemoveDuration())
                .translationX(view.getWidth())
                .alpha(0)
                .setListener(new RemoveListenerAdapter(holder) {
                    @Override
                    protected void removeListener() {
                        animation.setListener(null);
                    }
                }).start();
    }

    @Override
    protected void prepareAnimateRemove(RecyclerView.ViewHolder holder) {
        ViewCompat.setTranslationX(holder.itemView, 0);
    }

    @Override
    protected void prepareAnimateAdd(RecyclerView.ViewHolder holder) {
        ViewCompat.setTranslationX(holder.itemView, holder.itemView.getWidth());
    }

    @Override
    protected void setAnimateAdd(final RecyclerView.ViewHolder holder) {

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
