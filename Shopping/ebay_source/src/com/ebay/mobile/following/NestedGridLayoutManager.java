// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

public class NestedGridLayoutManager extends GridLayoutManager
{

    private int mMeasuredDimension[];

    public NestedGridLayoutManager(Context context, int i, int j, boolean flag)
    {
        super(context, i, j, flag);
        mMeasuredDimension = new int[2];
    }

    private void measureScrapChild(android.support.v7.widget.RecyclerView.Recycler recycler, int i, int j, int k, int ai[])
    {
        View view = recycler.getViewForPosition(i);
        if (view != null)
        {
            android.support.v7.widget.RecyclerView.LayoutParams layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)view.getLayoutParams();
            view.measure(ViewGroup.getChildMeasureSpec(j, getPaddingLeft() + getPaddingRight(), layoutparams.width), ViewGroup.getChildMeasureSpec(k, getPaddingTop() + getPaddingBottom(), layoutparams.height));
            ai[0] = view.getMeasuredWidth() + layoutparams.leftMargin + layoutparams.rightMargin;
            ai[1] = view.getMeasuredHeight() + layoutparams.bottomMargin + layoutparams.topMargin;
            recycler.recycleView(view);
        }
    }

    public void onMeasure(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state, int i, int j)
    {
        int k;
        int l;
        int i1;
        int l1;
        int i2;
        i2 = android.view.View.MeasureSpec.getMode(i);
        l1 = android.view.View.MeasureSpec.getMode(j);
        i1 = android.view.View.MeasureSpec.getSize(i);
        l = android.view.View.MeasureSpec.getSize(j);
        j = 0;
        i = 0;
        int j2 = getItemCount();
        int k2 = getSpanCount();
        k = 0;
        while (k < j2) 
        {
            measureScrapChild(recycler, k, android.view.View.MeasureSpec.makeMeasureSpec(k, 0), android.view.View.MeasureSpec.makeMeasureSpec(k, 0), mMeasuredDimension);
            if (getOrientation() == 0)
            {
                int j1 = j + mMeasuredDimension[0];
                j = j1;
                if (k == 0)
                {
                    i = k2 * mMeasuredDimension[1];
                    j = j1;
                }
            } else
            {
                int k1 = i + mMeasuredDimension[1];
                i = k1;
                if (k == 0)
                {
                    j = k2 * mMeasuredDimension[0];
                    i = k1;
                }
            }
            k += k2;
        }
        k = j;
        i2;
        JVM INSTR lookupswitch 2: default 196
    //                   -2147483648: 200
    //                   1073741824: 244;
           goto _L1 _L2 _L3
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        k = j;
_L4:
        j = i;
        switch (l1)
        {
        default:
            j = i;
            break;

        case -2147483648: 
            break;

        case 1073741824: 
            break MISSING_BLOCK_LABEL_251;
        }
_L5:
        setMeasuredDimension(k, j);
        return;
_L3:
        k = i1;
          goto _L4
        j = l;
          goto _L5
    }
}
