// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;
import com.groupon.util.SwipeRefreshManager;

public class GrouponSwipeRefreshLayout extends SwipeRefreshLayout
{

    private View list;
    private SwipeRefreshManager swipeRefreshManager;

    public GrouponSwipeRefreshLayout(Context context)
    {
        this(context, null);
    }

    public GrouponSwipeRefreshLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public boolean canChildScrollUp()
    {
        if (list != null)
        {
            return list.canScrollVertically(-1);
        } else
        {
            return false;
        }
    }

    public boolean isEnabled()
    {
        return super.isEnabled() && (swipeRefreshManager == null || swipeRefreshManager.canSwipeRefresh());
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        list = findViewById(0x102000a);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        setColorSchemeResources(new int[] {
            0x7f0e0157, 0x7f0e0158, 0x7f0e0159, 0x7f0e015a
        });
    }

    public void setSwipeRefreshManager(SwipeRefreshManager swiperefreshmanager)
    {
        swipeRefreshManager = swiperefreshmanager;
    }
}
