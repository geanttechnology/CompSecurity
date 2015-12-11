// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class k extends android.support.v7.widget.RecyclerView.f
{

    private static final int ATTRS[] = {
        0x1010214
    };
    public static final int HORIZONTAL_LIST = 0;
    public static final int VERTICAL_LIST = 1;
    private Drawable mDivider;
    private int mEndOffset;
    private int mOrientation;
    private int mStartOffset;

    public k(Context context, int i)
    {
        a(context, i, 0, 0);
    }

    public k(Context context, int i, int j, int l)
    {
        a(context, i, j, l);
    }

    private void a(Context context, int i, int j, int l)
    {
        context = context.obtainStyledAttributes(ATTRS);
        mDivider = context.getDrawable(0);
        context.recycle();
        a(i);
        mStartOffset = j;
        mEndOffset = l;
    }

    public void a(int i)
    {
        if (i != 0 && i != 1)
        {
            throw new IllegalArgumentException("invalid orientation");
        } else
        {
            mOrientation = i;
            return;
        }
    }

    protected boolean a(View view, RecyclerView recyclerview)
    {
        return true;
    }

    public void b(Canvas canvas, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.q q)
    {
        if (mOrientation == 1)
        {
            c(canvas, recyclerview);
            return;
        } else
        {
            d(canvas, recyclerview);
            return;
        }
    }

    public void c(Canvas canvas, RecyclerView recyclerview)
    {
        int l = recyclerview.getPaddingLeft();
        int i1 = recyclerview.getWidth();
        int j1 = recyclerview.getPaddingRight();
        int k1 = recyclerview.getChildCount();
        for (int j = 0; j < k1; j++)
        {
            View view = recyclerview.getChildAt(j);
            if (a(view, recyclerview))
            {
                android.support.v7.widget.RecyclerView.i i = (android.support.v7.widget.RecyclerView.i)view.getLayoutParams();
                int l1 = view.getBottom();
                l1 = i.bottomMargin + l1;
                int i2 = mDivider.getIntrinsicHeight();
                mDivider.setBounds(mStartOffset + l, l1, i1 - j1 - mEndOffset, i2 + l1);
                mDivider.draw(canvas);
            }
        }

    }

    public void d(Canvas canvas, RecyclerView recyclerview)
    {
        int l = recyclerview.getPaddingTop();
        int i1 = recyclerview.getHeight();
        int j1 = recyclerview.getPaddingBottom();
        int k1 = recyclerview.getChildCount();
        for (int j = 0; j < k1; j++)
        {
            View view = recyclerview.getChildAt(j);
            if (a(view, recyclerview))
            {
                android.support.v7.widget.RecyclerView.i i = (android.support.v7.widget.RecyclerView.i)view.getLayoutParams();
                int l1 = view.getRight();
                l1 = i.rightMargin + l1;
                int i2 = mDivider.getIntrinsicHeight();
                mDivider.setBounds(l1, mStartOffset + l, i2 + l1, i1 - j1 - mEndOffset);
                mDivider.draw(canvas);
            }
        }

    }

}
