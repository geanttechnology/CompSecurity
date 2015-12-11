// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.haarman.listviewanimations.itemmanipulation.contextualundo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ListView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class ContextualUndoListViewTouchListener
    implements android.view.View.OnTouchListener
{
    public static interface Callback
    {

        public abstract void onListScrolled();

        public abstract void onViewSwiped(View view, int i);
    }


    private long mAnimationTime;
    private Callback mCallback;
    private int mDownPosition;
    private View mDownView;
    private float mDownX;
    private ListView mListView;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private boolean mPaused;
    private int mSlop;
    private boolean mSwiping;
    private VelocityTracker mVelocityTracker;
    private int mViewWidth;

    public ContextualUndoListViewTouchListener(ListView listview, Callback callback)
    {
        mViewWidth = 1;
        ViewConfiguration viewconfiguration = ViewConfiguration.get(listview.getContext());
        mSlop = viewconfiguration.getScaledTouchSlop();
        mMinFlingVelocity = viewconfiguration.getScaledMinimumFlingVelocity();
        mMaxFlingVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
        mAnimationTime = listview.getContext().getResources().getInteger(0x10e0000);
        mListView = listview;
        mCallback = callback;
    }

    public android.widget.AbsListView.OnScrollListener makeScrollListener()
    {
        return new android.widget.AbsListView.OnScrollListener() {

            final ContextualUndoListViewTouchListener this$0;

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
                boolean flag = true;
                abslistview = ContextualUndoListViewTouchListener.this;
                if (i == 1)
                {
                    flag = false;
                }
                abslistview.setEnabled(flag);
                if (mPaused)
                {
                    mCallback.onListScrolled();
                }
            }

            
            {
                this$0 = ContextualUndoListViewTouchListener.this;
                super();
            }
        };
    }

    public boolean onTouch(final View downView, MotionEvent motionevent)
    {
        if (mViewWidth < 2)
        {
            mViewWidth = mListView.getWidth();
        }
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 2: default 48
    //                   0 50
    //                   1 234
    //                   2 549;
           goto _L1 _L2 _L3 _L4
_L1:
        return false;
_L2:
        Rect rect;
        int i;
        final int downPosition;
        int j;
        int k;
        int l;
        int i1;
        if (mPaused)
        {
            return false;
        }
        rect = new Rect();
        downPosition = mListView.getChildCount();
        int ai[] = new int[2];
        mListView.getLocationOnScreen(ai);
        j = (int)motionevent.getRawX();
        k = ai[0];
        l = (int)motionevent.getRawY();
        i1 = ai[1];
        i = 0;
_L8:
        if (i < downPosition) goto _L6; else goto _L5
_L5:
        if (mDownView != null)
        {
            mDownX = motionevent.getRawX();
            mDownPosition = mListView.getPositionForView(mDownView);
            mVelocityTracker = VelocityTracker.obtain();
            mVelocityTracker.addMovement(motionevent);
        }
        downView.onTouchEvent(motionevent);
        return true;
_L6:
        View view = mListView.getChildAt(i);
        view.getHitRect(rect);
        if (!rect.contains(j - k, l - i1))
        {
            break; /* Loop/switch isn't completed */
        }
        mDownView = view;
        if (true) goto _L5; else goto _L7
_L7:
        i++;
          goto _L8
_L3:
        if (mVelocityTracker == null) goto _L10; else goto _L9
_L9:
        float f;
        float f2;
        float f3;
        f = motionevent.getRawX() - mDownX;
        mVelocityTracker.addMovement(motionevent);
        mVelocityTracker.computeCurrentVelocity(1000);
        f2 = Math.abs(mVelocityTracker.getXVelocity());
        f3 = Math.abs(mVelocityTracker.getYVelocity());
        j = 0;
        k = 0;
        if (Math.abs(f) <= (float)(mViewWidth / 2)) goto _L12; else goto _L11
_L11:
        downPosition = 1;
        if (f > 0.0F)
        {
            i = 1;
        } else
        {
            i = 0;
        }
_L14:
        if (downPosition != 0)
        {
            downView = mDownView;
            downPosition = mDownPosition;
            motionevent = ViewPropertyAnimator.animate(mDownView);
            if (i != 0)
            {
                i = mViewWidth;
            } else
            {
                i = -mViewWidth;
            }
            motionevent.translationX(i).alpha(0.0F).setDuration(mAnimationTime).setListener(new AnimatorListenerAdapter() {

                final ContextualUndoListViewTouchListener this$0;
                private final int val$downPosition;
                private final View val$downView;

                public void onAnimationEnd(Animator animator)
                {
                    mCallback.onViewSwiped(downView, downPosition);
                }

            
            {
                this$0 = ContextualUndoListViewTouchListener.this;
                downView = view;
                downPosition = i;
                super();
            }
            });
        } else
        {
            ViewPropertyAnimator.animate(mDownView).translationX(0.0F).alpha(1.0F).setDuration(mAnimationTime).setListener(null);
        }
        mVelocityTracker = null;
        mDownX = 0.0F;
        mDownView = null;
        mDownPosition = -1;
        mSwiping = false;
_L10:
        if (true) goto _L13; else goto _L12
_L13:
        continue; /* Loop/switch isn't completed */
_L12:
        downPosition = j;
        i = k;
        if ((float)mMinFlingVelocity <= f2)
        {
            downPosition = j;
            i = k;
            if (f2 <= (float)mMaxFlingVelocity)
            {
                downPosition = j;
                i = k;
                if (f3 < f2)
                {
                    downPosition = 1;
                    if (mVelocityTracker.getXVelocity() > 0.0F)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                }
            }
        }
          goto _L14
_L4:
        if (mVelocityTracker != null && !mPaused)
        {
            mVelocityTracker.addMovement(motionevent);
            float f1 = motionevent.getRawX() - mDownX;
            if (Math.abs(f1) > (float)mSlop)
            {
                mSwiping = true;
                mListView.requestDisallowInterceptTouchEvent(true);
                downView = MotionEvent.obtain(motionevent);
                downView.setAction(motionevent.getActionIndex() << 8 | 3);
                mListView.onTouchEvent(downView);
            }
            if (mSwiping)
            {
                ViewHelper.setTranslationX(mDownView, f1);
                ViewHelper.setAlpha(mDownView, Math.max(0.0F, Math.min(1.0F, 1.0F - (2.0F * Math.abs(f1)) / (float)mViewWidth)));
                return true;
            }
        }
        if (true) goto _L1; else goto _L15
_L15:
    }

    public void setEnabled(boolean flag)
    {
        if (flag)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        mPaused = flag;
    }


}
