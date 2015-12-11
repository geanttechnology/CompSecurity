// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ScalableImageView extends ImageView
{

    public boolean a;

    public ScalableImageView(Context context)
    {
        super(context);
        a = true;
    }

    public ScalableImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = true;
    }

    public ScalableImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = true;
    }

    protected void onMeasure(int i, int j)
    {
        Drawable drawable = getDrawable();
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
                a = false;
            }
            break MISSING_BLOCK_LABEL_47;
        }
        k = android.view.View.MeasureSpec.getSize(i);
        setMeasuredDimension(k, (drawable.getIntrinsicHeight() * k) / drawable.getIntrinsicWidth());
        return;
        super.onMeasure(i, j);
        return;
    }
}
