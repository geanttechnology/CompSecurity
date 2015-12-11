// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import com.groupon.util.SwipeRefreshManager;

public class GrouponSwipeRefreshLayoutV3 extends SwipeRefreshLayout
{

    protected SwipeRefreshManager swipeRefreshManager;

    public GrouponSwipeRefreshLayoutV3(Context context)
    {
        this(context, null);
    }

    public GrouponSwipeRefreshLayoutV3(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public boolean canChildScrollUp()
    {
        android.view.View view = findViewById(0x7f1000dc);
        if (view != null)
        {
            return ViewCompat.canScrollVertically(view, -1);
        } else
        {
            return false;
        }
    }

    public boolean isEnabled()
    {
        return super.isEnabled() && (swipeRefreshManager == null || swipeRefreshManager.canSwipeRefresh());
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        setColorScheme(new int[] {
            0x7f0e0157, 0x7f0e0158, 0x7f0e0159, 0x7f0e015a
        });
    }

    public void setSwipeRefreshManager(SwipeRefreshManager swiperefreshmanager)
    {
        swipeRefreshManager = swiperefreshmanager;
    }
}
