// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.appearance;

import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.widget.GridView;
import com.nhaarman.listviewanimations.util.ListViewWrapper;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.view.ViewHelper;

public class ViewAnimator
{

    private int mAnimationDelayMillis;
    private int mAnimationDurationMillis;
    private long mAnimationStartMillis;
    private final SparseArray mAnimators = new SparseArray();
    private int mFirstAnimatedPosition;
    private int mInitialDelayMillis;
    private int mLastAnimatedPosition;
    private final ListViewWrapper mListViewWrapper;
    private boolean mShouldAnimate;

    public ViewAnimator(ListViewWrapper listviewwrapper)
    {
        mInitialDelayMillis = 150;
        mAnimationDelayMillis = 100;
        mAnimationDurationMillis = 300;
        mShouldAnimate = true;
        mListViewWrapper = listviewwrapper;
        mAnimationStartMillis = -1L;
        mFirstAnimatedPosition = -1;
        mLastAnimatedPosition = -1;
    }

    private void animateView(int i, View view, Animator aanimator[])
    {
        if (mAnimationStartMillis == -1L)
        {
            mAnimationStartMillis = SystemClock.uptimeMillis();
        }
        ViewHelper.setAlpha(view, 0.0F);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(aanimator);
        animatorset.setStartDelay(calculateAnimationDelay(i));
        animatorset.setDuration(mAnimationDurationMillis);
        animatorset.start();
        mAnimators.put(view.hashCode(), animatorset);
    }

    private int calculateAnimationDelay(int i)
    {
        if ((mListViewWrapper.getLastVisiblePosition() - mListViewWrapper.getFirstVisiblePosition()) + 1 < i - 1 - mFirstAnimatedPosition)
        {
            int l = mAnimationDelayMillis;
            int j = l;
            if (mListViewWrapper.getListView() instanceof GridView)
            {
                j = l;
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    j = ((GridView)mListViewWrapper.getListView()).getNumColumns();
                    j = l + mAnimationDelayMillis * (i % j);
                }
            }
            return j;
        } else
        {
            int k = mFirstAnimatedPosition;
            int i1 = mAnimationDelayMillis;
            return Math.max(0, (int)(-SystemClock.uptimeMillis() + mAnimationStartMillis + (long)mInitialDelayMillis + (long)((i - k) * i1)));
        }
    }

    public void animateViewIfNecessary(int i, View view, Animator aanimator[])
    {
        if (mShouldAnimate && i > mLastAnimatedPosition)
        {
            if (mFirstAnimatedPosition == -1)
            {
                mFirstAnimatedPosition = i;
            }
            animateView(i, view, aanimator);
            mLastAnimatedPosition = i;
        }
    }

    void cancelExistingAnimation(View view)
    {
        int i = view.hashCode();
        view = (Animator)mAnimators.get(i);
        if (view != null)
        {
            view.end();
            mAnimators.remove(i);
        }
    }

    void setLastAnimatedPosition(int i)
    {
        mLastAnimatedPosition = i;
    }
}
