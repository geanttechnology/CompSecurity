// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.recyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ListDividerItemDecoration extends android.support.v7.widget.RecyclerView.ItemDecoration
{

    private final Drawable divider;

    public ListDividerItemDecoration(Context context)
    {
        divider = context.getResources().getDrawable(0x7f0201cc);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        rect.set(0, 0, 0, divider.getIntrinsicHeight());
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        int j = recyclerview.getPaddingLeft();
        int k = recyclerview.getWidth();
        int l = recyclerview.getPaddingRight();
        int i1 = recyclerview.getChildCount();
        for (int i = 0; i < i1; i++)
        {
            state = recyclerview.getChildAt(i);
            android.support.v7.widget.RecyclerView.LayoutParams layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)state.getLayoutParams();
            int j1 = state.getBottom() + layoutparams.bottomMargin;
            int k1 = divider.getIntrinsicHeight();
            divider.setBounds(j, j1, k - l, j1 + k1);
            divider.draw(canvas);
        }

    }
}
