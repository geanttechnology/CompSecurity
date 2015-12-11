// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.haarman.listviewanimations.itemmanipulation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.haarman.listviewanimations.itemmanipulation:
//            OnDismissCallback

public class SwipeDismissListViewTouchListener
    implements android.view.View.OnTouchListener
{
    class PendingDismissData
        implements Comparable
    {

        public int position;
        final SwipeDismissListViewTouchListener this$0;
        public View view;

        public int compareTo(PendingDismissData pendingdismissdata)
        {
            return pendingdismissdata.position - position;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((PendingDismissData)obj);
        }

        public PendingDismissData(int i, View view1)
        {
            this$0 = SwipeDismissListViewTouchListener.this;
            super();
            position = i;
            view = view1;
        }
    }


    private long mAnimationTime;
    private OnDismissCallback mCallback;
    private int mDismissAnimationRefCount;
    private int mDownPosition;
    private View mDownView;
    private float mDownX;
    private float mDownY;
    private ListView mListView;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private boolean mPaused;
    private List mPendingDismisses;
    private int mSlop;
    private boolean mSwiping;
    private VelocityTracker mVelocityTracker;
    private int mViewWidth;

    public SwipeDismissListViewTouchListener(ListView listview, OnDismissCallback ondismisscallback)
    {
        mViewWidth = 1;
        mPendingDismisses = new ArrayList();
        mDismissAnimationRefCount = 0;
        ViewConfiguration viewconfiguration = ViewConfiguration.get(listview.getContext());
        mSlop = viewconfiguration.getScaledTouchSlop();
        mMinFlingVelocity = viewconfiguration.getScaledMinimumFlingVelocity();
        mMaxFlingVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
        mAnimationTime = listview.getContext().getResources().getInteger(0x10e0000);
        mListView = listview;
        mCallback = ondismisscallback;
    }

    private void performDismiss(final View dismissView, int i)
    {
        final android.view.ViewGroup.LayoutParams lp = dismissView.getLayoutParams();
        ValueAnimator valueanimator = ValueAnimator.ofInt(new int[] {
            dismissView.getHeight(), 1
        }).setDuration(mAnimationTime);
        valueanimator.addListener(new AnimatorListenerAdapter() {

            final SwipeDismissListViewTouchListener this$0;

            public void onAnimationEnd(Animator animator)
            {
                animator = SwipeDismissListViewTouchListener.this;
                animator.mDismissAnimationRefCount = ((SwipeDismissListViewTouchListener) (animator)).mDismissAnimationRefCount - 1;
                if (mDismissAnimationRefCount != 0) goto _L2; else goto _L1
_L1:
                int j;
                Collections.sort(mPendingDismisses);
                animator = new int[mPendingDismisses.size()];
                j = mPendingDismisses.size() - 1;
_L5:
                if (j >= 0) goto _L4; else goto _L3
_L3:
                mCallback.onDismiss(mListView, animator);
                animator = mPendingDismisses.iterator();
_L6:
                if (animator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_159;
                }
                mPendingDismisses.clear();
_L2:
                return;
_L4:
                animator[j] = ((PendingDismissData)mPendingDismisses.get(j)).position;
                j--;
                  goto _L5
                PendingDismissData pendingdismissdata = (PendingDismissData)animator.next();
                ViewHelper.setAlpha(pendingdismissdata.view, 1.0F);
                ViewHelper.setTranslationX(pendingdismissdata.view, 0.0F);
                android.view.ViewGroup.LayoutParams layoutparams = pendingdismissdata.view.getLayoutParams();
                layoutparams.height = 0;
                pendingdismissdata.view.setLayoutParams(layoutparams);
                  goto _L6
            }

            
            {
                this$0 = SwipeDismissListViewTouchListener.this;
                super();
            }
        });
        valueanimator.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {

            final SwipeDismissListViewTouchListener this$0;
            private final View val$dismissView;
            private final android.view.ViewGroup.LayoutParams val$lp;

            public void onAnimationUpdate(ValueAnimator valueanimator1)
            {
                lp.height = ((Integer)valueanimator1.getAnimatedValue()).intValue();
                dismissView.setLayoutParams(lp);
            }

            
            {
                this$0 = SwipeDismissListViewTouchListener.this;
                lp = layoutparams;
                dismissView = view;
                super();
            }
        });
        mPendingDismisses.add(new PendingDismissData(i, dismissView));
        valueanimator.start();
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
    //                   1 242
    //                   2 567;
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
            mDownY = motionevent.getRawY();
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
        float f4;
        f = motionevent.getRawX() - mDownX;
        mVelocityTracker.addMovement(motionevent);
        mVelocityTracker.computeCurrentVelocity(1000);
        f2 = Math.abs(mVelocityTracker.getXVelocity());
        f4 = Math.abs(mVelocityTracker.getYVelocity());
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
            mDismissAnimationRefCount = mDismissAnimationRefCount + 1;
            motionevent = ViewPropertyAnimator.animate(mDownView);
            if (i != 0)
            {
                i = mViewWidth;
            } else
            {
                i = -mViewWidth;
            }
            motionevent.translationX(i).alpha(0.0F).setDuration(mAnimationTime).setListener(new AnimatorListenerAdapter() {

                final SwipeDismissListViewTouchListener this$0;
                private final int val$downPosition;
                private final View val$downView;

                public void onAnimationEnd(Animator animator)
                {
                    performDismiss(downView, downPosition);
                }

            
            {
                this$0 = SwipeDismissListViewTouchListener.this;
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
                if (f4 < f2)
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
            float f3 = motionevent.getRawY();
            float f5 = mDownY;
            if (Math.abs(f1) > (float)mSlop && Math.abs(f1) > Math.abs(f3 - f5))
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






}
