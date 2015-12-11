// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.e;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;

public class g
    implements android.view.View.OnTouchListener
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(View view, Object obj);

        public abstract boolean a(Object obj);
    }


    private static final int SWIPE_COMPLETE_DELAY_MSEC = 50;
    private long mAnimationTime;
    private boolean mDisabled;
    private float mDownX;
    private float mDownY;
    private a mListener;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private int mSlop;
    private boolean mSwiping;
    private Object mToken;
    private float mTranslationX;
    private VelocityTracker mVelocityTracker;
    private View mView;
    private int mViewWidth;

    public g(View view, Object obj, a a1)
    {
        mViewWidth = 1;
        ViewConfiguration viewconfiguration = ViewConfiguration.get(view.getContext());
        mSlop = viewconfiguration.getScaledTouchSlop();
        mMinFlingVelocity = viewconfiguration.getScaledMinimumFlingVelocity() * 16;
        mMaxFlingVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
        mAnimationTime = view.getContext().getResources().getInteger(0x10e0000);
        mView = view;
        mToken = obj;
        mListener = a1;
        mView.setAlpha(1.0F);
        mView.setTranslationX(0.0F);
    }

    static boolean a(g g1, boolean flag)
    {
        g1.mSwiping = flag;
        return flag;
    }

    private void b()
    {
        mListener.a(mView, mToken);
    }

    private void c()
    {
        (new Handler()).postDelayed(new Runnable() {

            final g this$0;

            public void run()
            {
                g.a(g.this, false);
            }

            
            {
                this$0 = g.this;
                super();
            }
        }, 50L);
    }

    public boolean a()
    {
        return mSwiping;
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag;
        flag = true;
        break MISSING_BLOCK_LABEL_3;
label0:
        while (true) 
        {
            do
            {
                do
                {
                    return false;
                } while (mDisabled || !mListener.a(mToken));
                motionevent.offsetLocation(mTranslationX, 0.0F);
                if (mViewWidth < 2)
                {
                    mViewWidth = mView.getWidth();
                }
                switch (motionevent.getActionMasked())
                {
                default:
                    return false;

                case 2: // '\002'
                    continue;

                case 0: // '\0'
                    mDownX = motionevent.getRawX();
                    mDownY = motionevent.getRawY();
                    mVelocityTracker = VelocityTracker.obtain();
                    mVelocityTracker.addMovement(motionevent);
                    return false;

                case 1: // '\001'
                    if (mVelocityTracker != null)
                    {
                        float f = motionevent.getRawX() - mDownX;
                        mVelocityTracker.addMovement(motionevent);
                        mVelocityTracker.computeCurrentVelocity(1000);
                        float f1 = mVelocityTracker.getXVelocity();
                        float f2 = Math.abs(f1);
                        float f3 = Math.abs(mVelocityTracker.getYVelocity());
                        if (-f <= (float)(mViewWidth / 2) || !mSwiping)
                        {
                            if ((float)mMinFlingVelocity <= f2 && f2 <= (float)mMaxFlingVelocity && f3 < f2 && f3 < f2 && mSwiping)
                            {
                                boolean flag1;
                                boolean flag2;
                                if (f1 < 0.0F)
                                {
                                    flag1 = true;
                                } else
                                {
                                    flag1 = false;
                                }
                                if (f < 0.0F)
                                {
                                    flag2 = true;
                                } else
                                {
                                    flag2 = false;
                                }
                                if (flag1 != flag2)
                                {
                                    flag = false;
                                }
                            } else
                            {
                                flag = false;
                            }
                        }
                        if (flag)
                        {
                            b();
                        } else
                        if (mSwiping)
                        {
                            mView.animate().translationX(0.0F).alpha(1.0F).setDuration(mAnimationTime).setListener(null);
                        }
                        mVelocityTracker.recycle();
                        mVelocityTracker = null;
                        c();
                        return false;
                    }
                    break;

                case 3: // '\003'
                    if (mVelocityTracker != null)
                    {
                        mView.animate().translationX(0.0F).alpha(1.0F).setDuration(mAnimationTime).setListener(null);
                        mVelocityTracker.recycle();
                        mVelocityTracker = null;
                        mTranslationX = 0.0F;
                        mDownX = 0.0F;
                        mDownY = 0.0F;
                        c();
                        return false;
                    }
                    break;
                }
                continue label0;
            } while (mVelocityTracker == null);
            mVelocityTracker.addMovement(motionevent);
            f = motionevent.getRawX() - mDownX;
            f1 = motionevent.getRawY();
            f2 = mDownY;
            if (Math.abs(f) > (float)mSlop && Math.abs(f1 - f2) < Math.abs(f) / 2.0F)
            {
                if (!mSwiping)
                {
                    mListener.a();
                }
                mSwiping = true;
            }
            if (mSwiping)
            {
                mView.getParent().requestDisallowInterceptTouchEvent(true);
                view = MotionEvent.obtain(motionevent);
                view.setAction(motionevent.getActionIndex() << 8 | 3);
                mView.onTouchEvent(view);
                view.recycle();
                mTranslationX = f;
                mView.setTranslationX((float)mSlop + f);
                mView.setAlpha(Math.max(0.0F, Math.min(1.0F, 1.0F - (Math.abs(f) * 2.0F) / (float)mViewWidth)));
                return true;
            }
        }
    }
}
