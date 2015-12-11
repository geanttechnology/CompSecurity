// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.LoaderManager;
import com.groupon.abtest.CabCavOnDealDetailsAbTestHelper;
import com.groupon.adapter.widget.FilterableWidgetListAdapter;
import com.groupon.callbacks.DefaultOnDealDetailsWidgetsEventListener;
import com.groupon.db.models.Deal;
import com.groupon.loader.WidgetsForDealLoaderCallbacks;
import com.groupon.manager.WidgetOnDealDetailsSyncManager;

// Referenced classes of package com.groupon.activity:
//            DealDetails

private class <init> extends DefaultOnDealDetailsWidgetsEventListener
{

    final DealDetails this$0;

    private void initWidgetSyncManager()
    {
        DealDetails.access$5500(DealDetails.this).setDealUuid(DealDetails.access$1400(DealDetails.this).uuid);
        DealDetails.access$5500(DealDetails.this).requestSync(null, null);
    }

    public void onCabWidgetsInitialized(FilterableWidgetListAdapter filterablewidgetlistadapter)
    {
        if (!DealDetails.access$5200(DealDetails.this))
        {
            DealDetails.access$5202(DealDetails.this, true);
            if (DealDetails.access$5300(DealDetails.this).shouldDisplayCABWidget())
            {
                filterablewidgetlistadapter = new WidgetsForDealLoaderCallbacks(DealDetails.this, filterablewidgetlistadapter, DealDetails.access$1400(DealDetails.this).uuid);
                getLoaderManager().initLoader(1, null, filterablewidgetlistadapter);
            }
        }
        initWidgetSyncManager();
    }

    public void onCavWidgetsInitialized(FilterableWidgetListAdapter filterablewidgetlistadapter)
    {
        if (!DealDetails.access$5400(DealDetails.this))
        {
            DealDetails.access$5402(DealDetails.this, true);
            if (DealDetails.access$5300(DealDetails.this).shouldDisplayCAVWidget())
            {
                filterablewidgetlistadapter = new WidgetsForDealLoaderCallbacks(DealDetails.this, filterablewidgetlistadapter, DealDetails.access$1400(DealDetails.this).uuid);
                getLoaderManager().initLoader(2, null, filterablewidgetlistadapter);
            }
        }
        initWidgetSyncManager();
    }

    private stener()
    {
        this$0 = DealDetails.this;
        super();
    }

    stener(stener stener)
    {
        this();
    }
}
