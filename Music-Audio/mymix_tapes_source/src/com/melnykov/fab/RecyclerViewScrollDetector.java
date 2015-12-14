// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.melnykov.fab;

import android.support.v7.widget.RecyclerView;

abstract class RecyclerViewScrollDetector extends android.support.v7.widget.RecyclerView.OnScrollListener
{

    private int mScrollThreshold;

    RecyclerViewScrollDetector()
    {
    }

    abstract void onScrollDown();

    abstract void onScrollUp();

    public void onScrolled(RecyclerView recyclerview, int i, int j)
    {
label0:
        {
            if (Math.abs(j) > mScrollThreshold)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                if (j <= 0)
                {
                    break label0;
                }
                onScrollUp();
            }
            return;
        }
        onScrollDown();
    }

    public void setScrollThreshold(int i)
    {
        mScrollThreshold = i;
    }
}
