// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.wishabi.flipp.b;

public class RatingView extends View
{

    private Drawable a;
    private Drawable b;
    private Drawable c;
    private int d;
    private int e;
    private int f;

    public RatingView(Context context)
    {
        this(context, null, 0);
    }

    public RatingView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RatingView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        Resources resources = getResources();
        if (resources != null)
        {
            a = resources.getDrawable(0x7f0200c1);
            b = resources.getDrawable(0x7f0200c2);
            c = resources.getDrawable(0x7f0200c3);
            d = (int)TypedValue.applyDimension(1, 12F, getResources().getDisplayMetrics());
            e = (int)TypedValue.applyDimension(1, 2.0F, getResources().getDisplayMetrics());
            if (isInEditMode())
            {
                f = 7;
            }
            context = context.obtainStyledAttributes(attributeset, b.RatingView, i, 0);
            if (context != null)
            {
                f = context.getInt(0, 0);
                return;
            }
        }
    }

    public int getRating()
    {
        return f;
    }

    protected void onDraw(Canvas canvas)
    {
        int l = (getHeight() - d) / 2;
        int i1 = f;
        int k = 0;
        int i;
        int j1;
        int k1;
        for (i = 0; k < i1 >> 1; i = j1 + k1 + i)
        {
            a.setBounds(i, l, d + i, d + l);
            a.draw(canvas);
            j1 = d;
            k1 = e;
            k++;
        }

        k = i;
        if ((f & 1) != 0)
        {
            b.setBounds(i, l, d + i, d + l);
            b.draw(canvas);
            k = i + (d + e);
        }
        i1 = f;
        for (int j = 0; j < 10 - i1 >> 1; j++)
        {
            c.setBounds(k, l, d + k, d + l);
            c.draw(canvas);
            k += d + e;
        }

    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(d * 5 + e * 4, 0x40000000), j);
    }

    public void setRating(int i)
    {
        f = i;
    }
}
