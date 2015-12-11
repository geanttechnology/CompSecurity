// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter.widget;

import android.widget.Adapter;
import com.groupon.util.MergeAdapter;

// Referenced classes of package com.groupon.adapter.widget:
//            DealListHeaderAdapter

public class GoodsWidgetMergeAdapter extends MergeAdapter
{

    private static int DEALS_ADAPTER_POSITION = 2;
    private static int DEALS_HEADER_POSITION = 1;
    private static int WIDGET_ADAPTER_POSITION = 0;

    public GoodsWidgetMergeAdapter(Adapter aadapter[])
    {
        super(aadapter);
    }

    protected int chooseAdapter(int i)
    {
        Adapter adapter = adapters[WIDGET_ADAPTER_POSITION];
        DealListHeaderAdapter deallistheaderadapter = (DealListHeaderAdapter)adapters[DEALS_HEADER_POSITION];
        if (i < adapter.getCount())
        {
            return WIDGET_ADAPTER_POSITION;
        }
        if (i == adapter.getCount() && deallistheaderadapter.enabled)
        {
            return DEALS_HEADER_POSITION;
        } else
        {
            return DEALS_ADAPTER_POSITION;
        }
    }

    public void init()
    {
        this;
        JVM INSTR monitorenter ;
        Adapter adapter;
        Adapter adapter1;
        DealListHeaderAdapter deallistheaderadapter;
        adapter = adapters[WIDGET_ADAPTER_POSITION];
        adapter1 = adapters[DEALS_ADAPTER_POSITION];
        deallistheaderadapter = (DealListHeaderAdapter)adapters[DEALS_HEADER_POSITION];
        boolean flag;
        if (adapter.getCount() > 0 && adapter1.getCount() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        deallistheaderadapter.setHeaderEnabled(flag);
        super.init();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
