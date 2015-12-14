// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AspectRatioImageView extends ImageView
{

    public AspectRatioImageView(Context context)
    {
        super(context);
    }

    public AspectRatioImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public AspectRatioImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onMeasure(int i, int j)
    {
        Drawable drawable = getDrawable();
        if (drawable != null)
        {
            int k = android.view.View.MeasureSpec.getSize(i);
            int l = drawable.getIntrinsicWidth();
            if (l > 0)
            {
                setMeasuredDimension(k, (drawable.getIntrinsicHeight() * k) / l);
                return;
            } else
            {
                super.onMeasure(i, j);
                return;
            }
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }
}
