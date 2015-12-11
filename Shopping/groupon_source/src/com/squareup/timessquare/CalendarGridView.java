// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.squareup.timessquare:
//            CalendarRowView, Logr

public class CalendarGridView extends ViewGroup
{

    private final Paint dividerPaint = new Paint();
    private int oldNumRows;
    private int oldWidthMeasureSize;

    public CalendarGridView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        dividerPaint.setColor(getResources().getColor(R.color.calendar_divider));
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (getChildCount() == 0)
        {
            ((CalendarRowView)view).setIsHeaderRow(true);
        }
        super.addView(view, i, layoutparams);
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        ViewGroup viewgroup = (ViewGroup)getChildAt(1);
        int j = viewgroup.getTop();
        int k = getBottom();
        int l = viewgroup.getChildAt(0).getLeft() + getLeft();
        canvas.drawLine((float)l + 0.5F, j, (float)l + 0.5F, k, dividerPaint);
        for (int i = 0; i < 7; i++)
        {
            float f = (float)(viewgroup.getChildAt(i).getRight() + l) - 0.5F;
            canvas.drawLine(f, j, f, k, dividerPaint);
        }

    }

    protected boolean drawChild(Canvas canvas, View view, long l)
    {
        boolean flag = super.drawChild(canvas, view, l);
        int i = view.getBottom() - 1;
        canvas.drawLine(view.getLeft(), i, view.getRight() - 2, i, dividerPaint);
        return flag;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        long l1 = System.currentTimeMillis();
        l = 0;
        j = 0;
        for (int i1 = getChildCount(); j < i1; j++)
        {
            View view = getChildAt(j);
            int j1 = view.getMeasuredHeight();
            view.layout(i, l, k, l + j1);
            l += j1;
        }

        Logr.d("Grid.onLayout %d ms", new Object[] {
            Long.valueOf(System.currentTimeMillis() - l1)
        });
    }

    protected void onMeasure(int i, int j)
    {
        Logr.d("Grid.onMeasure w=%s h=%s", new Object[] {
            android.view.View.MeasureSpec.toString(i), android.view.View.MeasureSpec.toString(j)
        });
        i = android.view.View.MeasureSpec.getSize(i);
        if (oldWidthMeasureSize == i)
        {
            Logr.d("SKIP Grid.onMeasure");
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        long l2 = System.currentTimeMillis();
        oldWidthMeasureSize = i;
        int l = i / 7;
        int i1 = l * 7;
        j = 0;
        int j1 = android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000);
        int k1 = android.view.View.MeasureSpec.makeMeasureSpec(l, 0x40000000);
        i = 0;
        int l1 = getChildCount();
        while (i < l1) 
        {
            View view = getChildAt(i);
            int k = j;
            if (view.getVisibility() == 0)
            {
                if (i == 0)
                {
                    measureChild(view, j1, android.view.View.MeasureSpec.makeMeasureSpec(l, 0x80000000));
                } else
                {
                    measureChild(view, j1, k1);
                }
                k = j + view.getMeasuredHeight();
            }
            i++;
            j = k;
        }
        setMeasuredDimension(i1 + 2, j);
        Logr.d("Grid.onMeasure %d ms", new Object[] {
            Long.valueOf(System.currentTimeMillis() - l2)
        });
    }

    public void setDayBackground(int i)
    {
        for (int j = 1; j < getChildCount(); j++)
        {
            ((CalendarRowView)getChildAt(j)).setCellBackground(i);
        }

    }

    public void setDayTextColor(int i)
    {
        for (int j = 0; j < getChildCount(); j++)
        {
            android.content.res.ColorStateList colorstatelist = getResources().getColorStateList(i);
            ((CalendarRowView)getChildAt(j)).setCellTextColor(colorstatelist);
        }

    }

    public void setDisplayHeader(boolean flag)
    {
        int i = 0;
        View view = getChildAt(0);
        if (!flag)
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void setDividerColor(int i)
    {
        dividerPaint.setColor(i);
    }

    public void setHeaderTextColor(int i)
    {
        ((CalendarRowView)getChildAt(0)).setCellTextColor(i);
    }

    public void setNumRows(int i)
    {
        if (oldNumRows != i)
        {
            oldWidthMeasureSize = 0;
        }
        oldNumRows = i;
    }

    public void setTypeface(Typeface typeface)
    {
        for (int i = 0; i < getChildCount(); i++)
        {
            ((CalendarRowView)getChildAt(i)).setTypeface(typeface);
        }

    }
}
