// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class VerticalDividerItemDecoration extends android.support.v7.widget.RecyclerView.ItemDecoration
{

    private Drawable divider;
    private int numSpans;
    private int padding;

    public VerticalDividerItemDecoration(Context context, int i)
    {
        divider = context.getResources().getDrawable(0x7f02018b);
        padding = context.getResources().getDimensionPixelSize(0x7f09007c);
        numSpans = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        rect.right = padding;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        int j = recyclerview.getPaddingTop();
        int k = recyclerview.getHeight();
        int l = recyclerview.getPaddingBottom();
        int i1 = recyclerview.getChildCount();
        for (int i = 0; i < i1; i++)
        {
            if (i % numSpans != numSpans - 1)
            {
                state = recyclerview.getChildAt(i);
                android.support.v7.widget.RecyclerView.LayoutParams layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)state.getLayoutParams();
                int j1 = state.getRight() + layoutparams.rightMargin;
                divider.setBounds(j1, j, j1 + 2, k - l);
                divider.draw(canvas);
            }
        }

    }
}
