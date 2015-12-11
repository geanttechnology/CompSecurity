// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.views;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

public final class i extends LinearLayoutManager
{

    private int a[];

    public i(Context context)
    {
        super(context, 1, false);
        a = new int[2];
    }

    private void a(android.support.v7.widget.RecyclerView.Recycler recycler, int j, int k, int l, int ai[])
    {
        View view = recycler.getViewForPosition(j);
        recycler.bindViewToPosition(view, j);
        if (view != null)
        {
            android.support.v7.widget.RecyclerView.LayoutParams layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)view.getLayoutParams();
            view.measure(ViewGroup.getChildMeasureSpec(k, getPaddingLeft() + getPaddingRight(), layoutparams.width), ViewGroup.getChildMeasureSpec(l, getPaddingTop() + getPaddingBottom(), layoutparams.height));
            ai[0] = view.getMeasuredWidth() + layoutparams.leftMargin + layoutparams.rightMargin;
            j = view.getMeasuredHeight();
            k = layoutparams.bottomMargin;
            ai[1] = layoutparams.topMargin + (j + k);
            recycler.recycleView(view);
        }
    }

    public final void onMeasure(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state, int j, int k)
    {
        int l;
        int i1;
        int k1;
        int l1;
        int i2;
        int j2;
        j2 = android.view.View.MeasureSpec.getMode(j);
        i2 = android.view.View.MeasureSpec.getMode(k);
        l1 = android.view.View.MeasureSpec.getSize(j);
        k1 = android.view.View.MeasureSpec.getSize(k);
        int j1 = 0;
        l = 0;
        i1 = 0;
        while (j1 < getItemCount()) 
        {
            if (getOrientation() == 0)
            {
                a(recycler, j1, android.view.View.MeasureSpec.makeMeasureSpec(j1, 0), k, a);
                i1 += a[0];
                if (j1 == 0)
                {
                    l = a[1];
                }
            } else
            {
                a(recycler, j1, j, android.view.View.MeasureSpec.makeMeasureSpec(j1, 0), a);
                l = a[1] + l;
                if (j1 == 0)
                {
                    i1 = a[0];
                }
            }
            j1++;
        }
        j2;
        JVM INSTR tableswitch 1073741824 1073741824: default 168
    //                   1073741824 197;
           goto _L1 _L2
_L1:
        i2;
        JVM INSTR tableswitch 1073741824 1073741824: default 188
    //                   1073741824 204;
           goto _L3 _L4
_L3:
        setMeasuredDimension(i1, l);
        return;
_L2:
        i1 = l1;
          goto _L1
_L4:
        l = k1;
          goto _L3
    }
}
