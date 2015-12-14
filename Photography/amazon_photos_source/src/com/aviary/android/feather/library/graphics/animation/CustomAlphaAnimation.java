// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics.animation;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class CustomAlphaAnimation extends Animation
{

    private float mCurrentAlpha;
    private float mFromAlpha;
    private float mToAlpha;

    public CustomAlphaAnimation(float f, float f1)
    {
        mFromAlpha = f;
        mToAlpha = f1;
        mCurrentAlpha = f;
    }

    protected void applyTransformation(float f, Transformation transformation)
    {
        float f1 = mFromAlpha;
        mCurrentAlpha = (mToAlpha - f1) * f + f1;
        transformation.setAlpha(mCurrentAlpha);
    }

    public float getAlpha()
    {
        return mCurrentAlpha;
    }

    public boolean willChangeBounds()
    {
        return false;
    }

    public boolean willChangeTransformationMatrix()
    {
        return false;
    }
}
