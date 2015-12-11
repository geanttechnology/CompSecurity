// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ResizeAnimation extends Animation
{

    private float fromHeight;
    private float fromWidth;
    private float toHeight;
    private float toWidth;
    private View view;

    public ResizeAnimation(View view1, float f, float f1, float f2, float f3)
    {
        toHeight = f3;
        toWidth = f2;
        fromHeight = f1;
        fromWidth = f;
        view = view1;
    }

    protected void applyTransformation(float f, Transformation transformation)
    {
        float f1 = toHeight;
        float f2 = fromHeight;
        float f3 = fromHeight;
        float f4 = toWidth;
        float f5 = fromWidth;
        float f6 = fromWidth;
        transformation = view.getLayoutParams();
        transformation.height = (int)((f1 - f2) * f + f3);
        transformation.width = (int)((f4 - f5) * f + f6);
        view.requestLayout();
    }
}
