// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GoodsCategoryDecoration extends android.support.v7.widget.RecyclerView.ItemDecoration
{

    private final int height;
    private final int padding;
    private final int paddingBottom;
    private final int paddingEdge;
    private final int paddingTop;

    public GoodsCategoryDecoration(Context context)
    {
        paddingEdge = context.getResources().getDimensionPixelSize(0x7f0b014e);
        padding = context.getResources().getDimensionPixelSize(0x7f0b014f);
        paddingTop = context.getResources().getDimensionPixelSize(0x7f0b0150);
        paddingBottom = context.getResources().getDimensionPixelSize(0x7f0b014d);
        height = context.getResources().getDimensionPixelSize(0x7f0b0148);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        super.getItemOffsets(rect, view, recyclerview, state);
        int j = recyclerview.getChildPosition(view);
        int k = recyclerview.getAdapter().getItemCount();
        int i;
        if (j == 0)
        {
            i = paddingEdge;
        } else
        {
            i = 0;
        }
        if (j == k - 1)
        {
            j = paddingEdge;
        } else
        {
            j = padding;
        }
        rect.set(i, paddingTop, j, paddingBottom);
        recyclerview.setMinimumHeight(height);
    }
}
