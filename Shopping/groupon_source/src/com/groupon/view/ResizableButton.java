// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.Button;

public class ResizableButton extends Button
{

    private float mTextSize;

    public ResizableButton(Context context)
    {
        super(context, null);
    }

    public ResizableButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset, 0x1010048);
        float f = context.getResources().getDisplayMetrics().density;
        mTextSize = getTextSize() / f;
    }

    public ResizableButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        i = getMeasuredWidth();
        j = getMeasuredHeight();
        float f = mTextSize;
        do
        {
            setTextSize(f);
            measure(0, 0);
            if (getMeasuredWidth() <= i)
            {
                setMeasuredDimension(i, j);
                return;
            }
            f--;
        } while (true);
    }
}
