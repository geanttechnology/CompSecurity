// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// Referenced classes of package com.squareup.timessquare:
//            MonthCellDescriptor, Logr

public class CalendarRowView extends ViewGroup
    implements android.view.View.OnClickListener
{

    private boolean isHeaderRow;
    private MonthView.Listener listener;

    public CalendarRowView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        view.setOnClickListener(this);
        super.addView(view, i, layoutparams);
    }

    public void onClick(View view)
    {
        if (listener != null)
        {
            listener.handleClick((MonthCellDescriptor)view.getTag());
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        long l1 = System.currentTimeMillis();
        k -= i;
        i = 0;
        for (int i1 = getChildCount(); i < i1; i++)
        {
            getChildAt(i).layout(((i + 0) * k) / 7, 0, ((i + 1) * k) / 7, l - j);
        }

        Logr.d("Row.onLayout %d ms", new Object[] {
            Long.valueOf(System.currentTimeMillis() - l1)
        });
    }

    protected void onMeasure(int i, int j)
    {
        long l1 = System.currentTimeMillis();
        int i1 = android.view.View.MeasureSpec.getSize(i);
        j = 0;
        i = 0;
        int j1 = getChildCount();
        while (i < j1) 
        {
            View view = getChildAt(i);
            int k = ((i + 0) * i1) / 7;
            k = ((i + 1) * i1) / 7 - k;
            int l = android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000);
            if (isHeaderRow)
            {
                k = android.view.View.MeasureSpec.makeMeasureSpec(k, 0x80000000);
            } else
            {
                k = l;
            }
            view.measure(l, k);
            k = j;
            if (view.getMeasuredHeight() > j)
            {
                k = view.getMeasuredHeight();
            }
            i++;
            j = k;
        }
        setMeasuredDimension(getPaddingLeft() + i1 + getPaddingRight(), getPaddingTop() + j + getPaddingBottom());
        Logr.d("Row.onMeasure %d ms", new Object[] {
            Long.valueOf(System.currentTimeMillis() - l1)
        });
    }

    public void setCellBackground(int i)
    {
        for (int j = 0; j < getChildCount(); j++)
        {
            getChildAt(j).setBackgroundResource(i);
        }

    }

    public void setCellTextColor(int i)
    {
        for (int j = 0; j < getChildCount(); j++)
        {
            ((TextView)getChildAt(j)).setTextColor(i);
        }

    }

    public void setCellTextColor(ColorStateList colorstatelist)
    {
        for (int i = 0; i < getChildCount(); i++)
        {
            ((TextView)getChildAt(i)).setTextColor(colorstatelist);
        }

    }

    public void setIsHeaderRow(boolean flag)
    {
        isHeaderRow = flag;
    }

    public void setListener(MonthView.Listener listener1)
    {
        listener = listener1;
    }

    public void setTypeface(Typeface typeface)
    {
        for (int i = 0; i < getChildCount(); i++)
        {
            ((TextView)getChildAt(i)).setTypeface(typeface);
        }

    }
}
