// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ae;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.wishabi.flipp.b;

public class ViewPagerIndicator extends View
{

    private ViewPager a;
    private final Paint b;
    private final Paint c;
    private int d;

    public ViewPagerIndicator(Context context)
    {
        this(context, null);
    }

    public ViewPagerIndicator(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ViewPagerIndicator(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b = new Paint(1);
        c = new Paint(1);
        Resources resources = getResources();
        android.util.DisplayMetrics displaymetrics;
        if (resources != null)
        {
            if ((displaymetrics = resources.getDisplayMetrics()) != null && (context = context.obtainStyledAttributes(attributeset, b.ViewPagerIndicator, i, 0)) != null)
            {
                i = (int)context.getDimension(2, (int)TypedValue.applyDimension(1, 5F, displaymetrics));
                d = (int)context.getDimension(3, (int)TypedValue.applyDimension(1, 3F, displaymetrics));
                b.setColor(context.getColor(0, resources.getColor(0x7f090063)));
                b.setStrokeWidth(i);
                c.setColor(context.getColor(1, resources.getColor(0x7f090064)));
                c.setStrokeWidth(i);
                context.recycle();
                return;
            }
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (!isInEditMode()) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = 5;
        j = 3;
_L6:
        float f2 = getPaddingTop();
        float f = getPaddingLeft();
        float f1 = getPaddingRight();
        f1 = Math.max(((float)getWidth() - f - f1 - (float)(d * (i - 1))) / (float)i, 1.0F);
        f2 += ((float)getHeight() - f2 - (float)getPaddingBottom()) / 2.0F;
        int k = 0;
        while (k < i) 
        {
            float f3 = f + (float)k * ((float)d + f1);
            Object obj;
            if (k == j)
            {
                obj = c;
            } else
            {
                obj = b;
            }
            canvas.drawLine(f3, f2, f3 + f1, f2, ((Paint) (obj)));
            k++;
        }
          goto _L3
_L2:
        if (a != null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        if ((obj = a.getAdapter()) == null) goto _L3; else goto _L5
_L5:
        i = ((ae) (obj)).c();
        j = a.getCurrentItem();
        if (i == 0) goto _L3; else goto _L6
    }

    public void setViewPager(ViewPager viewpager)
    {
        if (a == viewpager)
        {
            return;
        }
        if (a != null)
        {
            a.setOnPageChangeListener(null);
        }
        a = viewpager;
        invalidate();
    }
}
