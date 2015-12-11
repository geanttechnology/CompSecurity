// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.os.SystemClock;
import android.view.View;
import android.widget.ListAdapter;
import com.groupon.db.models.MarketRateResult;

// Referenced classes of package com.groupon.util:
//            MultiColumnListAdapter

public class HotelsMultiColumnListAdapter extends MultiColumnListAdapter
{

    private static final int CLICK_THRESHOLD_MILLIS = 1500;
    private ListAdapter adapter;
    private long lastClickMillis;

    public HotelsMultiColumnListAdapter(ListAdapter listadapter, int i)
    {
        super(listadapter, i);
        adapter = listadapter;
    }

    private void triggerOnClick(int i, View view)
    {
        Object obj = getWrappedAdapter().getItem(i);
        if (obj instanceof MarketRateResult)
        {
            onMarketRateDealCardClicked(i, view, (MarketRateResult)obj);
        }
    }

    public Object getItem(int i)
    {
        return adapter.getItem(i);
    }

    protected void onClick(int i, View view)
    {
        long l = SystemClock.elapsedRealtime();
        if (l - lastClickMillis > 1500L)
        {
            triggerOnClick(i, view);
        }
        lastClickMillis = l;
    }

    public void onMarketRateDealCardClicked(int i, View view, MarketRateResult marketrateresult)
    {
    }
}
