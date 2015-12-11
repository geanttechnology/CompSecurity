// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.layout_manager;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;

public class EagerLinearLayoutManager extends LinearLayoutManager
{

    private static final int DEFAULT_SCREENS_TO_EAGER_LOAD = 2;
    private static final String INVALID_SCREENS = "The number of screens to eagerly load must be greater than or equal to 0.";
    private int mScreenHeight;
    private int mScreenWidth;
    private int mScreensToEagerLoad;

    public EagerLinearLayoutManager(Context context)
    {
        this(context, 0, false, 2);
    }

    public EagerLinearLayoutManager(Context context, int i, boolean flag, int j)
    {
        super(context, i, flag);
        mScreensToEagerLoad = 2;
        a(context, j);
    }

    private void a(Context context, int i)
    {
        context = context.getResources().getDisplayMetrics();
        mScreenHeight = ((DisplayMetrics) (context)).heightPixels;
        mScreenWidth = ((DisplayMetrics) (context)).widthPixels;
        a(i);
    }

    protected int a(android.support.v7.widget.RecyclerView.q q)
    {
        if (f() == 1)
        {
            return mScreensToEagerLoad * mScreenHeight;
        } else
        {
            return mScreensToEagerLoad * mScreenWidth;
        }
    }

    public void a(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("The number of screens to eagerly load must be greater than or equal to 0.");
        } else
        {
            mScreensToEagerLoad = i;
            return;
        }
    }
}
