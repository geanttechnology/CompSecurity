// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class AdjustingHeightImageView extends ImageView
{

    public void onMeasure(int i, int j)
    {
        Drawable drawable = getDrawable();
        if (drawable != null)
        {
            j = drawable.getIntrinsicWidth();
            j = (i * drawable.getIntrinsicHeight()) / j;
            setMeasuredDimension(android.view.View.MeasureSpec.getSize(i), j);
            return;
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }
}
