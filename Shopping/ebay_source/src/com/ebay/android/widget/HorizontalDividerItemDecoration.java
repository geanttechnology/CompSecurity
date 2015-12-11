// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class HorizontalDividerItemDecoration extends android.support.v7.widget.RecyclerView.ItemDecoration
{

    private Drawable divider;
    private int rowLength;

    public HorizontalDividerItemDecoration(Context context)
    {
        rowLength = 1;
        divider = context.getResources().getDrawable(0x7f020003);
    }

    public HorizontalDividerItemDecoration(Context context, int i)
    {
        this(context);
        rowLength = i;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        int j = recyclerview.getPaddingLeft();
        int k = recyclerview.getWidth();
        int l = recyclerview.getPaddingRight();
        int i1 = recyclerview.getChildCount();
        int j1 = rowLength;
        for (int i = 0; i < i1 - j1; i++)
        {
            state = recyclerview.getChildAt(i);
            android.support.v7.widget.RecyclerView.LayoutParams layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)state.getLayoutParams();
            int k1 = state.getBottom() + layoutparams.bottomMargin;
            int l1 = divider.getIntrinsicHeight();
            divider.setBounds(j, k1, k - l, k1 + l1);
            divider.draw(canvas);
        }

    }
}
