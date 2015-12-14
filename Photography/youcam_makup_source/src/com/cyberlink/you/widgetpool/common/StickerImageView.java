// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import com.cyberlink.you.g;

public class StickerImageView extends ImageView
{

    private static final int a = Math.round(TypedValue.applyDimension(1, 110F, g.I().getResources().getDisplayMetrics()));

    public StickerImageView(Context context)
    {
        super(context);
    }

    public StickerImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public StickerImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onMeasure(int i, int j)
    {
        Drawable drawable = getDrawable();
        if (drawable != null)
        {
            int k = drawable.getIntrinsicWidth();
            int l = drawable.getIntrinsicHeight();
            if (k > 0 && l > 0)
            {
                if (k < l)
                {
                    float f = (float)a / (float)k;
                    setMeasuredDimension(a, Math.round((float)l * f));
                    return;
                } else
                {
                    setMeasuredDimension(Math.round(((float)a / (float)l) * (float)k), a);
                    return;
                }
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
