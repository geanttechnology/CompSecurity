// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;

// Referenced classes of package com.ebay.mobile.common:
//            PhotoGalleryWidget

private class mDeceleration
{

    private int mCurrX;
    private final float mDeceleration;
    private int mDuration;
    private int mFinalX;
    private boolean mFinished;
    private float mSignX;
    private long mStartTime;
    private int mStartX;
    private float mVelocity;
    final PhotoGalleryWidget this$0;

    public final boolean computeScrollOffset()
    {
        if (mFinished)
        {
            return false;
        }
        int i = (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
        if (i < mDuration)
        {
            float f = (float)i / 1000F;
            float f1 = mVelocity;
            float f2 = (mDeceleration * f * f) / 2.0F;
            mCurrX = mStartX + Math.round(mSignX * (f1 * f - f2));
            mCurrX = Math.max(mCurrX, 0);
            if (mCurrX == mFinalX)
            {
                mFinished = true;
            }
        } else
        {
            mCurrX = mFinalX;
            mFinished = true;
        }
        return true;
    }

    public final void fling(int i, int j)
    {
        mFinished = false;
        float f = Math.abs(j);
        mVelocity = f;
        mDuration = (int)((1000F * f) / mDeceleration);
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mStartX = i;
        mSignX = Math.signum(j);
        mFinalX = Math.round(getSignedDistance(j)) + i;
        mFinalX = Math.max(mFinalX, 0);
    }

    public final void forceFinished(boolean flag)
    {
        mFinished = flag;
    }

    public final int getCurrX()
    {
        return mCurrX;
    }

    public int getSignedDistance(int i)
    {
        return (int)((float)(i * i) / (2.0F * mDeceleration)) * (int)Math.signum(i);
    }

    public final int getStartVelocity(int i)
    {
        int j = Math.abs(i);
        int k;
        if (j < 50)
        {
            j = 0;
        } else
        {
            j = (int)Math.sqrt((float)(j * 2) * mDeceleration);
        }
        k = j;
        if (i < 0)
        {
            k = -j;
        }
        return k;
    }

    public (Context context)
    {
        this$0 = PhotoGalleryWidget.this;
        super();
        mSignX = 0.0F;
        mFinished = true;
        mDeceleration = 385.826F * (context.getResources().getDisplayMetrics().density * 160F) * ViewConfiguration.getScrollFriction();
    }
}
