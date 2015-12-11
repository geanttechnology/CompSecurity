// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class DropDownAnimation extends Animation
{

    private int initialHeight;
    private int targetHeight;
    private View view;

    public DropDownAnimation(View view1, int i, int j)
    {
        view = view1;
        initialHeight = view1.getLayoutParams().height;
        targetHeight = i;
        setDuration(j);
    }

    protected void applyTransformation(float f, Transformation transformation)
    {
        view.getLayoutParams().height = initialHeight + (int)((float)(targetHeight - initialHeight) * f);
        view.requestLayout();
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
