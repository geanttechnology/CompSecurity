// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.libraries.youtube.common.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import bhu;

public class FixedAspectRatioRelativeLayout extends RelativeLayout
{

    private float a;

    public FixedAspectRatioRelativeLayout(Context context)
    {
        super(context);
        a = 1.0F;
    }

    public FixedAspectRatioRelativeLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = context.obtainStyledAttributes(attributeset, bhu.a);
        a = context.getFraction(0, 1, 1, 1.0F);
        context.recycle();
    }

    protected void onMeasure(int i, int j)
    {
        if (android.view.View.MeasureSpec.getMode(i) == 0x40000000)
        {
            super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec((int)((float)android.view.View.MeasureSpec.getSize(i) / a), 0x40000000));
            return;
        }
        if (android.view.View.MeasureSpec.getMode(j) == 0x40000000)
        {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec((int)((float)android.view.View.MeasureSpec.getSize(j) * a), 0x40000000), j);
            return;
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }
}
