// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

final class e extends android.support.v7.widget.RecyclerView.ItemDecoration
{

    private int a;
    private int b;

    public e(int i, int j)
    {
        a = i;
        b = j;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        super.getItemOffsets(rect, view, recyclerview, state);
        if (recyclerview.getChildPosition(view) == 0)
        {
            rect.set(b, a, a, a);
            return;
        } else
        {
            rect.set(a, a, a, a);
            return;
        }
    }
}
