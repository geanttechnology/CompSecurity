// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import org.apache.commons.lang3.StringUtils;

public class MaxSizeTextView extends TextView
{

    private float a;
    private float b;
    private float c;

    public MaxSizeTextView(Context context)
    {
        super(context);
        a = 0.0F;
        b = 0.0F;
        c = 1.0F;
    }

    public MaxSizeTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 0.0F;
        b = 0.0F;
        c = 1.0F;
        context = context.obtainStyledAttributes(attributeset, com.offerup.R.styleable.offerup, 0, 0);
        a = context.getDimensionPixelSize(0, 0);
        b = context.getDimensionPixelSize(1, 0);
        context.recycle();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    public float getMaxTextHeightInPx()
    {
        return b;
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        float f;
        float f1;
        if (StringUtils.isNotEmpty(getText()))
        {
            f = getPaint().measureText(getText().toString());
        } else
        {
            f = 0.0F;
        }
        f1 = 3.402823E+38F;
        if (f != 0.0F)
        {
            f1 = a / f;
        }
        f = getTextSize();
        f = Math.min(f1, b / f);
        if (Math.abs(c - f) > 0.1F)
        {
            c = f;
            setTextSize(0, c * getTextSize());
            requestLayout();
        }
    }

    public void setMaxTextHeightInPx(float f)
    {
        b = f;
    }
}
