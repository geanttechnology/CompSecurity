// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

final class i extends android.support.v7.widget.RecyclerView.ItemDecoration
{

    private int a;

    public i(int j)
    {
        a = j;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
    {
        super.getItemOffsets(rect, view, recyclerview, state);
        rect.set(0, 0, a, a);
    }
}
