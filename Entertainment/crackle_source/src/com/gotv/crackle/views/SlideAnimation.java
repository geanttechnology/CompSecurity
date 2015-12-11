// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class SlideAnimation extends Animation
{

    private final float fromX;
    private final float fromY;
    private View mView;
    private final float toX;
    private final float toY;

    public SlideAnimation(View view, float f, float f1, float f2, float f3)
    {
        mView = view;
        fromX = f;
        toX = f1;
        fromY = f2;
        toY = f3;
        setDuration(400L);
    }

    protected void applyTransformation(float f, Transformation transformation)
    {
        float f1 = toX;
        float f2 = fromX;
        float f3 = fromX;
        float f4 = toY;
        float f5 = fromY;
        float f6 = fromY;
        ((android.widget.RelativeLayout.LayoutParams)mView.getLayoutParams()).setMargins((int)((f1 - f2) * f + f3), (int)((f4 - f5) * f + f6), 0, 0);
        mView.requestLayout();
    }
}
