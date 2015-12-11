// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class FinalMarginItemDecoration extends android.support.v7.widget.RecyclerView.ItemDecoration
{

    private final int extraBottomMargin;

    public FinalMarginItemDecoration(Context context)
    {
        extraBottomMargin = context.getResources().getDimensionPixelOffset(0x7f090074);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        boolean flag;
        int i;
        if (recyclerview.getChildPosition(view) == recyclerview.getAdapter().getItemCount() - 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = 0;
        if (flag)
        {
            i = extraBottomMargin;
        }
        rect.set(0, 0, 0, i);
    }
}
