// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.effect;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

// Referenced classes of package com.amazon.androidmotion.effect:
//            Effect

public abstract class AnchoredEffect
    implements Effect
{

    private int mAnchorScreenX;
    private int mAnchorScreenY;
    private float mFarLimit;
    private float mNearLimit;

    public AnchoredEffect(int i, int j, float f, float f1)
    {
        setAnchor(i, j);
        setLimits(f, f1);
    }

    private void checkLimits(float f, float f1)
    {
        if (f > f1)
        {
            throw new IllegalArgumentException("the near limit must be <= the far limit");
        } else
        {
            return;
        }
    }

    public int getAnchorScreenX()
    {
        return mAnchorScreenX;
    }

    public int getAnchorScreenY()
    {
        return mAnchorScreenY;
    }

    protected abstract void getCurrentScreenPosition(int ai[]);

    public float getDistance()
    {
        int ai[] = new int[2];
        getCurrentScreenPosition(ai);
        return (float)Math.hypot(mAnchorScreenX - ai[0], mAnchorScreenY - ai[1]);
    }

    public float getFarLimit()
    {
        return mFarLimit;
    }

    public float getFraction()
    {
        float f = getDistance();
        if (f <= mNearLimit)
        {
            return 0.0F;
        }
        if (f >= mFarLimit)
        {
            return 1.0F;
        } else
        {
            return (f - mNearLimit) / (mFarLimit - mNearLimit);
        }
    }

    public float getFraction(ValueAnimator valueanimator)
    {
        return getFraction();
    }

    public abstract TimeInterpolator getInterpolator();

    public float getNearLimit()
    {
        return mNearLimit;
    }

    public void setAnchor(int i, int j)
    {
        mAnchorScreenX = i;
        mAnchorScreenY = j;
    }

    public void setFarLimit(float f)
    {
        checkLimits(mNearLimit, f);
        mFarLimit = f;
    }

    public void setLimits(float f, float f1)
    {
        checkLimits(f, f1);
        mNearLimit = f;
        mFarLimit = f1;
    }

    public void setNearLimit(float f)
    {
        checkLimits(f, mFarLimit);
        mNearLimit = f;
    }

    public abstract void update(float f);
}
