// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view;

import android.support.v4.view.cx;
import android.support.v4.view.dk;
import android.support.v4.view.dl;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewPropertyAnimatorCompatSet
{

    private final ArrayList mAnimators = new ArrayList();
    private long mDuration;
    private Interpolator mInterpolator;
    private boolean mIsStarted;
    private dk mListener;
    private final dl mProxyListener = new _cls1();

    public ViewPropertyAnimatorCompatSet()
    {
        mDuration = -1L;
    }

    private void onAnimationsEnded()
    {
        mIsStarted = false;
    }

    public void cancel()
    {
        if (!mIsStarted)
        {
            return;
        }
        for (Iterator iterator = mAnimators.iterator(); iterator.hasNext(); ((cx)iterator.next()).b()) { }
        mIsStarted = false;
    }

    public ViewPropertyAnimatorCompatSet play(cx cx1)
    {
        if (!mIsStarted)
        {
            mAnimators.add(cx1);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(cx cx1, cx cx2)
    {
        mAnimators.add(cx1);
        cx2.b(cx1.a());
        mAnimators.add(cx2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long l)
    {
        if (!mIsStarted)
        {
            mDuration = l;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator)
    {
        if (!mIsStarted)
        {
            mInterpolator = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(dk dk)
    {
        if (!mIsStarted)
        {
            mListener = dk;
        }
        return this;
    }

    public void start()
    {
        if (mIsStarted)
        {
            return;
        }
        cx cx1;
        for (Iterator iterator = mAnimators.iterator(); iterator.hasNext(); cx1.c())
        {
            cx1 = (cx)iterator.next();
            if (mDuration >= 0L)
            {
                cx1.a(mDuration);
            }
            if (mInterpolator != null)
            {
                cx1.a(mInterpolator);
            }
            if (mListener != null)
            {
                cx1.a(mProxyListener);
            }
        }

        mIsStarted = true;
    }




    private class _cls1 extends dl
    {

        private int mProxyEndCount;
        private boolean mProxyStarted;
        final ViewPropertyAnimatorCompatSet this$0;

        public void onAnimationEnd(View view)
        {
            int i = mProxyEndCount + 1;
            mProxyEndCount = i;
            if (i == mAnimators.size())
            {
                if (mListener != null)
                {
                    mListener.onAnimationEnd(null);
                }
                onEnd();
            }
        }

        public void onAnimationStart(View view)
        {
            if (!mProxyStarted)
            {
                mProxyStarted = true;
                if (mListener != null)
                {
                    mListener.onAnimationStart(null);
                    return;
                }
            }
        }

        void onEnd()
        {
            mProxyEndCount = 0;
            mProxyStarted = false;
            onAnimationsEnded();
        }

        _cls1()
        {
            this$0 = ViewPropertyAnimatorCompatSet.this;
            super();
            mProxyStarted = false;
            mProxyEndCount = 0;
        }
    }

}
