// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.cyberlink.youcammakeup.j;

public class FixedAspectRatioFrameLayout extends FrameLayout
{

    private int a;
    private int b;
    private boolean c;

    public FixedAspectRatioFrameLayout(Context context)
    {
        super(context);
        a = -1;
        b = -1;
        c = false;
    }

    public FixedAspectRatioFrameLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = -1;
        b = -1;
        c = false;
        context = context.obtainStyledAttributes(attributeset, j.FixedAspectRatioLayoutArgs);
        a = context.getInteger(0, 1);
        b = context.getInteger(1, 1);
        context.recycle();
    }

    public FixedAspectRatioFrameLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = -1;
        b = -1;
        c = false;
        context = context.obtainStyledAttributes(attributeset, j.FixedAspectRatioLayoutArgs);
        a = context.getInteger(0, 1);
        b = context.getInteger(1, 1);
        context.recycle();
    }

    public void a(int i, int k)
    {
        a = i;
        b = k;
        requestLayout();
        invalidate();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return c;
    }

    protected void onMeasure(int i, int k)
    {
        super.onMeasure(i, k);
        if (a != 0 && b != 0)
        {
            int l = getMeasuredWidth();
            int i1 = getMeasuredHeight();
            if (i1 == 0 && l != 0)
            {
                k = (int)Math.round(((double)b / (double)a) * (double)l);
                setMeasuredDimension(l, k);
                measureChildren(i, android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000));
            } else
            if (l == 0 && i1 != 0)
            {
                i = (int)Math.round(((double)a / (double)b) * (double)i1);
                setMeasuredDimension(i, i1);
                measureChildren(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000), k);
                return;
            }
        }
    }

    public void setInterceptTouchEvent(boolean flag)
    {
        c = flag;
        if (flag)
        {
            setOnTouchListener(new android.view.View.OnTouchListener() {

                final FixedAspectRatioFrameLayout a;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    return true;
                }

            
            {
                a = FixedAspectRatioFrameLayout.this;
                super();
            }
            });
            return;
        } else
        {
            setOnTouchListener(null);
            return;
        }
    }
}
