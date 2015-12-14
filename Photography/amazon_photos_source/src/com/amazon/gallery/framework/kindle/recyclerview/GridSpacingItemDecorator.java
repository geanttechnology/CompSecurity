// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.recyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridSpacingItemDecorator extends android.support.v7.widget.RecyclerView.ItemDecoration
{

    private final int insetHorizontal;
    private final int insetVertical;
    private final int spanCount;

    public GridSpacingItemDecorator(Context context, int i)
    {
        insetHorizontal = context.getResources().getDimensionPixelSize(0x7f0a003c);
        insetVertical = context.getResources().getDimensionPixelSize(0x7f0a003f);
        spanCount = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        boolean flag = false;
        view = (android.support.v7.widget.GridLayoutManager.LayoutParams)view.getLayoutParams();
        int j = view.getSpanIndex();
        if (view.getSpanSize() == spanCount)
        {
            rect.left = 0;
            rect.right = 0;
            rect.top = 0;
            rect.bottom = insetVertical;
            return;
        }
        int i;
        if (j == 0)
        {
            i = 0;
        } else
        {
            i = insetHorizontal;
        }
        rect.left = i;
        if (j == spanCount - 1)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = insetHorizontal;
        }
        rect.right = i;
        rect.top = insetVertical;
        rect.bottom = insetVertical;
    }
}
