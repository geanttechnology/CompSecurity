// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter.widget;

import android.widget.Adapter;
import com.groupon.util.MergeAdapter;

// Referenced classes of package com.groupon.adapter.widget:
//            DealListHeaderAdapter, FilterableWidgetListAdapter

public class FeaturedWidgetMergeAdapter extends MergeAdapter
{

    public static final int DEALS_ADAPTER_POSITION = 2;
    public static final int DEALS_HEADER_POSITION = 1;
    public static final int WIDGET_ADAPTER_POSITION = 0;
    private boolean isMegamindEnabledCountry;
    private FilterableWidgetListAdapter widgetListAdapter;

    public FeaturedWidgetMergeAdapter(boolean flag, boolean flag1, Adapter aadapter[], FilterableWidgetListAdapter filterablewidgetlistadapter)
    {
        super(aadapter);
        isMegamindEnabledCountry = flag;
        widgetListAdapter = filterablewidgetlistadapter;
    }

    public boolean areAllItemsEnabled()
    {
        return false;
    }

    protected int chooseAdapter(int i)
    {
        Adapter adapter = adapters[0];
        DealListHeaderAdapter deallistheaderadapter = (DealListHeaderAdapter)adapters[1];
        if (isMegamindEnabledCountry)
        {
            if (i < adapter.getCount())
            {
                return 0;
            }
            if (i == adapter.getCount() && deallistheaderadapter.enabled)
            {
                return 1;
            }
        }
        return 2;
    }

    public int getFeaturedEndlessDealsDisplayPositionOffset()
    {
        return widgetListAdapter.getNumDealSummariesDisplayed();
    }

    public void init()
    {
        this;
        JVM INSTR monitorenter ;
        DealListHeaderAdapter deallistheaderadapter;
        Adapter adapter = adapters[2];
        Adapter adapter1 = adapters[0];
        deallistheaderadapter = (DealListHeaderAdapter)adapters[1];
        if (adapter1.getCount() <= 0 || adapter.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        deallistheaderadapter.setHeaderEnabled(true);
_L1:
        super.init();
        this;
        JVM INSTR monitorexit ;
        return;
        deallistheaderadapter.setHeaderEnabled(false);
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isEnabled(int i)
    {
        return getDelegateAdapter(i) != adapters[1];
    }
}
