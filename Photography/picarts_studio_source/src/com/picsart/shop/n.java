// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

final class n extends android.support.v7.widget.RecyclerView.ItemDecoration
{

    int a;
    int b;

    public n()
    {
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        super.getItemOffsets(rect, view, recyclerview, state);
        int i = recyclerview.getChildPosition(view);
        recyclerview.getLayoutManager();
        if (i < b)
        {
            rect.set(0, a + 0, 0, 0);
            return;
        } else
        {
            rect.set(0, 0, 0, 0);
            return;
        }
    }
}
