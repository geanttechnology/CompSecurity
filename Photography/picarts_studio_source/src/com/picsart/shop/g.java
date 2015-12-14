// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

final class g extends android.support.v7.widget.RecyclerView.ItemDecoration
{

    int a;
    private Drawable b;

    public g()
    {
        a = 500;
        b = new ColorDrawable(Color.parseColor("#e3e3e3"));
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        super.getItemOffsets(rect, view, recyclerview, state);
        int i = recyclerview.getChildPosition(view);
        recyclerview.getLayoutManager();
        if (i <= 0)
        {
            rect.set(0, a, 0, 0);
            return;
        } else
        {
            rect.set(0, 0, 0, 0);
            return;
        }
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        int j = recyclerview.getPaddingLeft();
        int k = recyclerview.getWidth();
        int l = recyclerview.getPaddingRight();
        int i1 = recyclerview.getChildCount();
        for (int i = 0; i < i1; i++)
        {
            state = recyclerview.getChildAt(i);
            android.support.v7.widget.RecyclerView.LayoutParams layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)state.getLayoutParams();
            int j1 = state.getBottom();
            j1 = layoutparams.bottomMargin + j1;
            b.setBounds(j, j1, k - l, j1 + 1);
            b.draw(canvas);
        }

    }
}
