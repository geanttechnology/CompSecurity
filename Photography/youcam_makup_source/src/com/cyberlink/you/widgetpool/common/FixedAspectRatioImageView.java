// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class FixedAspectRatioImageView extends ImageView
{

    public FixedAspectRatioImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onMeasure(int i, int j)
    {
        Drawable drawable = getDrawable();
        float f;
        if (drawable == null)
        {
            int k;
            try
            {
                setMeasuredDimension(0, 0);
                return;
            }
            catch (Exception exception)
            {
                super.onMeasure(i, j);
            }
            break MISSING_BLOCK_LABEL_75;
        }
        f = (float)drawable.getIntrinsicWidth() / (float)drawable.getIntrinsicHeight();
        if (f >= (float)android.view.View.MeasureSpec.getSize(i) / (float)android.view.View.MeasureSpec.getSize(j))
        {
            k = android.view.View.MeasureSpec.getSize(i);
            setMeasuredDimension(k, (int)((float)k / f));
            return;
        }
        break MISSING_BLOCK_LABEL_76;
        return;
        int l = android.view.View.MeasureSpec.getSize(j);
        setMeasuredDimension((int)(f * (float)l), l);
        return;
    }
}
