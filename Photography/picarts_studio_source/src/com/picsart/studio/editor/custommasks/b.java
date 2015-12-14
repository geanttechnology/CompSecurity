// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

public final class b extends LinearLayoutManager
{

    private int a[];

    public b(Context context, int i)
    {
        super(context, i, false);
        a = new int[2];
    }

    public final void onMeasure(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state, int i, int j)
    {
        int l;
        int i1;
        int i2;
        int j2;
        j2 = android.view.View.MeasureSpec.getMode(i);
        i2 = android.view.View.MeasureSpec.getMode(j);
        i1 = android.view.View.MeasureSpec.getSize(i);
        l = android.view.View.MeasureSpec.getSize(j);
        j = 0;
        i = 0;
        int k = 0;
        while (k < getItemCount()) 
        {
            int j1 = android.view.View.MeasureSpec.makeMeasureSpec(k, 0);
            int k2 = android.view.View.MeasureSpec.makeMeasureSpec(k, 0);
            state = a;
            View view = recycler.getViewForPosition(k);
            if (view != null)
            {
                android.support.v7.widget.RecyclerView.LayoutParams layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)view.getLayoutParams();
                view.measure(ViewGroup.getChildMeasureSpec(j1, getPaddingLeft() + getPaddingRight(), layoutparams.width), ViewGroup.getChildMeasureSpec(k2, getPaddingTop() + getPaddingBottom(), layoutparams.height));
                state[0] = view.getMeasuredWidth() + layoutparams.leftMargin + layoutparams.rightMargin;
                j1 = view.getMeasuredHeight();
                k2 = layoutparams.bottomMargin;
                state[1] = layoutparams.topMargin + (j1 + k2);
                recycler.recycleView(view);
            }
            if (getOrientation() == 0)
            {
                int k1 = j + a[0];
                j = k1;
                if (k == 0)
                {
                    i = a[1];
                    j = k1;
                }
            } else
            {
                int l1 = i + a[1];
                i = l1;
                if (k == 0)
                {
                    j = a[0];
                    i = l1;
                }
            }
            k++;
        }
        j2;
        JVM INSTR tableswitch 1073741824 1073741824: default 284
    //                   1073741824 312;
           goto _L1 _L2
_L1:
        i2;
        JVM INSTR tableswitch 1073741824 1073741824: default 304
    //                   1073741824 319;
           goto _L3 _L4
_L3:
        setMeasuredDimension(j, i);
        return;
_L2:
        j = i1;
          goto _L1
_L4:
        i = l;
          goto _L3
    }
}
