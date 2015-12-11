// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.widget.RelativeLayout;

public class AspectRatioRelativeLayout extends RelativeLayout
{

    private Float aspectRatio;

    public void onMeasure(int i, int j)
    {
        if (aspectRatio == null || aspectRatio.floatValue() <= 0.0F)
        {
            super.onMeasure(i, j);
            return;
        } else
        {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i), 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec((int)((float)android.view.View.MeasureSpec.getSize(i) / aspectRatio.floatValue()), 0x80000000));
            return;
        }
    }
}
