// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class PagerRecyclerView extends RecyclerView
{

    private int a;
    private int b;

    public PagerRecyclerView(Context context)
    {
        super(context);
    }

    public PagerRecyclerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PagerRecyclerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public final int a()
    {
        View view = findChildViewUnder(a - 15, 5F);
        if (view != null)
        {
            return view.getLeft() - b;
        } else
        {
            return 0;
        }
    }

    public boolean canScrollHorizontally(int i)
    {
        return true;
    }

    public boolean fling(int i, int j)
    {
        if (i > 0)
        {
            i = a();
        } else
        {
            a = getResources().getDisplayMetrics().widthPixels;
            View view = findChildViewUnder(15F, 5F);
            if (view != null)
            {
                i = -(a - view.getRight() - b);
            } else
            {
                i = 0;
            }
        }
        smoothScrollBy(i, 0);
        return true;
    }

    public void setProportion(int i)
    {
        b = i;
    }

    public void setScreenWidth(int i)
    {
        a = i;
    }
}
