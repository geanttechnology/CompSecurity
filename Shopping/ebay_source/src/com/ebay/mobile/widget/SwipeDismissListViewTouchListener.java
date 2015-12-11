// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.widget.AbsListView;
import android.widget.ListView;

public class SwipeDismissListViewTouchListener
    implements android.view.View.OnTouchListener
{
    public static interface DismissCallbacks
    {

        public abstract boolean canDismiss(int i);

        public abstract void onDismiss(ListView listview, int i);

        public abstract void onUndismiss(ListView listview, int i);
    }


    private final long mAnimationTime;
    private final DismissCallbacks mCallbacks;
    private int mDownPosition;
    private View mDownView;
    private float mDownX;
    private final ListView mListView;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private boolean mPaused;
    private final int mSlop;
    private View mSwipeableView;
    private Integer mSwipeableViewId;
    private boolean mSwiping;
    private VelocityTracker mVelocityTracker;
    private int mViewWidth;

    public SwipeDismissListViewTouchListener(ListView listview, DismissCallbacks dismisscallbacks)
    {
        mViewWidth = 1;
        mSwipeableViewId = null;
        ViewConfiguration viewconfiguration = ViewConfiguration.get(listview.getContext());
        mSlop = viewconfiguration.getScaledTouchSlop();
        mMinFlingVelocity = viewconfiguration.getScaledMinimumFlingVelocity() * 16;
        mMaxFlingVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
        mAnimationTime = listview.getContext().getResources().getInteger(0x10e0000);
        mListView = listview;
        mCallbacks = dismisscallbacks;
    }

    private void cancel(final View view, final int position)
    {
        view.animate().translationX(0.0F).alpha(1.0F).setDuration(mAnimationTime).setListener(new AnimatorListenerAdapter() {

            final SwipeDismissListViewTouchListener this$0;
            final int val$position;
            final View val$view;

            public void onAnimationEnd(Animator animator)
            {
                view.animate().setListener(null);
                mCallbacks.onUndismiss(mListView, position);
            }

            
            {
                this$0 = SwipeDismissListViewTouchListener.this;
                view = view1;
                position = i;
                super();
            }
        });
    }

    private void dismiss(final View swipeableView, final int position, boolean flag)
    {
        swipeableView = getSwipableViewFromListItem(swipeableView);
        if (swipeableView == null)
        {
            mCallbacks.onDismiss(mListView, position);
            return;
        }
        ViewPropertyAnimator viewpropertyanimator = swipeableView.animate();
        float f;
        if (flag)
        {
            f = mViewWidth;
        } else
        {
            f = -mViewWidth;
        }
        viewpropertyanimator.translationX(f).alpha(0.0F).setDuration(mAnimationTime).setListener(new AnimatorListenerAdapter() {

            final SwipeDismissListViewTouchListener this$0;
            final int val$position;
            final View val$swipeableView;

            public void onAnimationEnd(Animator animator)
            {
                swipeableView.animate().setListener(null);
                mCallbacks.onDismiss(mListView, position);
            }

            
            {
                this$0 = SwipeDismissListViewTouchListener.this;
                swipeableView = view;
                position = i;
                super();
            }
        });
    }

    private View getSwipableViewFromListItem(View view)
    {
        if (mSwipeableViewId == null)
        {
            return view;
        } else
        {
            return mDownView.findViewById(mSwipeableViewId.intValue());
        }
    }

    private View getViewForPosition(int i)
    {
        i -= mListView.getFirstVisiblePosition() - mListView.getHeaderViewsCount();
        if (i >= 0 && i < mListView.getChildCount())
        {
            return mListView.getChildAt(i);
        } else
        {
            return null;
        }
    }

    public void dismiss(int i)
    {
        mDownView = getViewForPosition(i);
        dismiss(mDownView, i, true);
        mDownView = null;
    }

    public android.widget.AbsListView.OnScrollListener makeScrollListener()
    {
        return new android.widget.AbsListView.OnScrollListener() {

            final SwipeDismissListViewTouchListener this$0;

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
                boolean flag = true;
                abslistview = SwipeDismissListViewTouchListener.this;
                if (i == 1)
                {
                    flag = false;
                }
                abslistview.setEnabled(flag);
            }

            
            {
                this$0 = SwipeDismissListViewTouchListener.this;
                super();
            }
        };
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (mViewWidth < 2)
        {
            mViewWidth = mListView.getWidth();
        }
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 3: default 52
    //                   0 54
    //                   1 276
    //                   2 643
    //                   3 577;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return false;
_L2:
        if (mPaused)
        {
            return false;
        }
        Rect rect = new Rect();
        int j = mListView.getChildCount();
        int ai[] = new int[2];
        mListView.getLocationOnScreen(ai);
        int k = (int)motionevent.getRawX();
        int l = ai[0];
        int i1 = (int)motionevent.getRawY();
        int j1 = ai[1];
        int i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    View view1 = mListView.getChildAt(i);
                    view1.getHitRect(rect);
                    if (!rect.contains(k - l, i1 - j1))
                    {
                        break label0;
                    }
                    mDownView = view1;
                    mSwipeableView = getSwipableViewFromListItem(mDownView);
                }
                if (mDownView != null)
                {
                    mDownX = motionevent.getRawX();
                    mDownPosition = mListView.getPositionForView(mDownView);
                    if (mCallbacks.canDismiss(mDownPosition))
                    {
                        mVelocityTracker = VelocityTracker.obtain();
                        mVelocityTracker.addMovement(motionevent);
                    } else
                    {
                        mDownView = null;
                        mSwipeableView = null;
                    }
                }
                view.onTouchEvent(motionevent);
                return true;
            }
            i++;
        } while (true);
_L3:
        if (mVelocityTracker != null)
        {
            float f = motionevent.getRawX() - mDownX;
            mVelocityTracker.addMovement(motionevent);
            mVelocityTracker.computeCurrentVelocity(1000);
            float f2 = mVelocityTracker.getXVelocity();
            float f3 = Math.abs(f2);
            float f4 = Math.abs(mVelocityTracker.getYVelocity());
            boolean flag2 = false;
            boolean flag5 = false;
            boolean flag;
            boolean flag4;
            if (Math.abs(f) > (float)(mViewWidth / 2))
            {
                flag = true;
                if (f > 0.0F)
                {
                    flag4 = true;
                } else
                {
                    flag4 = false;
                }
            } else
            {
                flag = flag2;
                flag4 = flag5;
                if ((float)mMinFlingVelocity <= f3)
                {
                    flag = flag2;
                    flag4 = flag5;
                    if (f3 <= (float)mMaxFlingVelocity)
                    {
                        flag = flag2;
                        flag4 = flag5;
                        if (f4 < f3)
                        {
                            boolean flag3;
                            if (f2 < 0.0F)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (f < 0.0F)
                            {
                                flag3 = true;
                            } else
                            {
                                flag3 = false;
                            }
                            if (flag == flag3)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (mVelocityTracker.getXVelocity() > 0.0F)
                            {
                                flag4 = true;
                            } else
                            {
                                flag4 = false;
                            }
                        }
                    }
                }
            }
            if (flag)
            {
                dismiss(mSwipeableView, mDownPosition, flag4);
            } else
            {
                cancel(mSwipeableView, mDownPosition);
            }
            mVelocityTracker.recycle();
            mVelocityTracker = null;
            mDownX = 0.0F;
            mDownView = null;
            mSwipeableView = null;
            mDownPosition = -1;
            mSwiping = false;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (mVelocityTracker != null)
        {
            if (mSwipeableView != null)
            {
                cancel(mSwipeableView, mDownPosition);
            }
            mVelocityTracker.recycle();
            mVelocityTracker = null;
            mDownX = 0.0F;
            mDownView = null;
            mSwipeableView = null;
            mDownPosition = -1;
            mSwiping = false;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (mVelocityTracker != null && !mPaused)
        {
            mVelocityTracker.addMovement(motionevent);
            float f1 = motionevent.getRawX() - mDownX;
            if (Math.abs(f1) > (float)mSlop)
            {
                boolean flag1;
                if (Math.abs(mSwipeableView.getTranslationX()) > (float)mSlop)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag1)
                {
                    mSwiping = true;
                }
                mListView.requestDisallowInterceptTouchEvent(true);
                view = MotionEvent.obtain(motionevent);
                view.setAction(motionevent.getActionIndex() << 8 | 3);
                mListView.onTouchEvent(view);
                view.recycle();
            }
            if (mSwiping)
            {
                mSwipeableView.setTranslationX(f1);
                mSwipeableView.setAlpha(Math.max(0.15F, Math.min(1.0F, 1.0F - (0.75F * Math.abs(f1)) / (float)mViewWidth)));
                return true;
            }
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void setEnabled(boolean flag)
    {
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mPaused = flag;
    }

    public void setSwipeableViewId(int i)
    {
        mSwipeableViewId = Integer.valueOf(i);
    }

    public void undismiss(int i)
    {
        cancel(getSwipableViewFromListItem(getViewForPosition(i)), i);
    }


}
