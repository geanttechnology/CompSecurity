// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class a extends android.support.v7.widget.RecyclerView.ItemDecoration
{

    private static final int a[] = {
        0x1010214
    };
    private Drawable b;

    public a(Context context)
    {
        context = context.obtainStyledAttributes(a);
        b = context.getDrawable(0);
        context.recycle();
    }

    public void a(Canvas canvas, RecyclerView recyclerview)
    {
        int j = recyclerview.getChildCount();
        for (int i = 0; i < j; i++)
        {
            View view = recyclerview.getChildAt(i);
            if (a(view, recyclerview))
            {
                android.support.v7.widget.RecyclerView.LayoutParams layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)view.getLayoutParams();
                int k = view.getLeft() - layoutparams.leftMargin;
                int l = view.getRight() + layoutparams.rightMargin;
                int i1 = view.getTop() - layoutparams.topMargin;
                int j1 = view.getBottom();
                j1 = layoutparams.bottomMargin + j1;
                b.setBounds(k, i1, b.getIntrinsicHeight() + k, j1);
                b.draw(canvas);
                b.setBounds(l - b.getIntrinsicHeight(), i1, l, j1);
                b.draw(canvas);
                b.setBounds(k, i1, l, b.getIntrinsicHeight() + i1);
                b.draw(canvas);
                b.setBounds(k, j1 - b.getIntrinsicHeight(), l, j1);
                b.draw(canvas);
                b.draw(canvas);
            }
        }

    }

    public boolean a(View view, RecyclerView recyclerview)
    {
        view = recyclerview.getChildViewHolder(view);
        return (view instanceof android.support.v7.hx.a) || (view instanceof android.support.v7.ho.a);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        if (a(view, recyclerview))
        {
            rect.set(0, 0, 0, 0);
            return;
        } else
        {
            super.getItemOffsets(rect, view, recyclerview, state);
            return;
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        a(canvas, recyclerview);
    }

}
