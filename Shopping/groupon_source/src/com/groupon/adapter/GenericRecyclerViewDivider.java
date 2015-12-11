// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GenericRecyclerViewDivider extends android.support.v7.widget.RecyclerView.ItemDecoration
{

    private static final int ATTRS[] = {
        0x1010214
    };
    public static final int HORIZONTAL_LIST = 0;
    public static final int VERTICAL_LIST = 1;
    private Drawable mDivider;
    private int mOrientation;

    public GenericRecyclerViewDivider(Context context, int i)
    {
        context = context.obtainStyledAttributes(ATTRS);
        mDivider = context.getDrawable(0);
        context.recycle();
        setOrientation(i);
    }

    public void drawHorizontal(Canvas canvas, RecyclerView recyclerview)
    {
        int j = recyclerview.getPaddingTop();
        int k = recyclerview.getHeight();
        int l = recyclerview.getPaddingBottom();
        int i1 = recyclerview.getChildCount();
        for (int i = 0; i < i1; i++)
        {
            View view = recyclerview.getChildAt(i);
            android.support.v7.widget.RecyclerView.LayoutParams layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)view.getLayoutParams();
            int j1 = view.getRight() + layoutparams.rightMargin;
            int k1 = mDivider.getIntrinsicHeight();
            mDivider.setBounds(j1, j, j1 + k1, k - l);
            mDivider.draw(canvas);
        }

    }

    public void drawVertical(Canvas canvas, RecyclerView recyclerview)
    {
        int j = recyclerview.getPaddingLeft();
        int k = recyclerview.getWidth();
        int l = recyclerview.getPaddingRight();
        int i1 = recyclerview.getChildCount();
        for (int i = 0; i < i1; i++)
        {
            View view = recyclerview.getChildAt(i);
            android.support.v7.widget.RecyclerView.LayoutParams layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)view.getLayoutParams();
            int j1 = view.getBottom() + layoutparams.bottomMargin;
            int k1 = mDivider.getIntrinsicHeight();
            mDivider.setBounds(j, j1, k - l, j1 + k1);
            mDivider.draw(canvas);
        }

    }

    public void getItemOffsets(Rect rect, int i, RecyclerView recyclerview)
    {
        if (mOrientation == 1)
        {
            rect.set(0, 0, 0, mDivider.getIntrinsicHeight());
            return;
        } else
        {
            rect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
            return;
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerview)
    {
        if (mOrientation == 1)
        {
            drawVertical(canvas, recyclerview);
            return;
        } else
        {
            drawHorizontal(canvas, recyclerview);
            return;
        }
    }

    public void setOrientation(int i)
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

}
