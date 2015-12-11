// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class b extends Animation
{

    private static final int DEFAULT_DURATION_MS = 300;
    private int mStartWidth;
    private int mTargetWidth;
    private View mView;

    public b(View view, int i, int j)
    {
        mView = view;
        mStartWidth = i;
        mTargetWidth = j;
        setDuration(300L);
    }

    protected void applyTransformation(float f, Transformation transformation)
    {
        int j = mTargetWidth;
        int k = mStartWidth;
        int i = mStartWidth;
        j = (int)((float)(j - k) * f);
        mView.getLayoutParams().width = j + i;
        mView.requestLayout();
    }

    public void initialize(int i, int j, int k, int l)
    {
        super.initialize(i, j, k, l);
    }

    public boolean willChangeBounds()
    {
        return true;
    }
}
