// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

// Referenced classes of package com.groupon.getaways.carousel:
//            GetawaysRecyclerViewAdapter

class t> extends android.support.v7.widget.r._cls1
{

    final GetawaysRecyclerViewAdapter this$0;

    public void onScrollStateChanged(RecyclerView recyclerview, int i)
    {
        if (GetawaysRecyclerViewAdapter.access$200(GetawaysRecyclerViewAdapter.this) != null && !GetawaysRecyclerViewAdapter.access$200(GetawaysRecyclerViewAdapter.this).isRefreshing())
        {
            SwipeRefreshLayout swiperefreshlayout = GetawaysRecyclerViewAdapter.access$200(GetawaysRecyclerViewAdapter.this);
            boolean flag;
            if (i == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            swiperefreshlayout.setEnabled(flag);
        }
        super.onScrollStateChanged(recyclerview, i);
    }

    A()
    {
        this$0 = GetawaysRecyclerViewAdapter.this;
        super();
    }
}
