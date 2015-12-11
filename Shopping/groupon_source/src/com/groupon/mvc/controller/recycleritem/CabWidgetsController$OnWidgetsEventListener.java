// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.adapter.widget.FilterableWidgetListAdapter;
import com.groupon.callbacks.DefaultOnDealDetailsWidgetsEventListener;
import com.groupon.callbacks.OnDealDetailsWidgetsEventListener;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            CabWidgetsController

private class <init> extends DefaultOnDealDetailsWidgetsEventListener
{

    final CabWidgetsController this$0;

    public void onCabWidgetClick(View view, DealSummary dealsummary)
    {
        CabWidgetsController.access$200(CabWidgetsController.this).logWidgetDealClick(dealsummary, "mm_deal_details", CabWidgetsController.access$400(CabWidgetsController.this).uuid, CabWidgetsController.access$500(CabWidgetsController.this));
        context.startActivity(CabWidgetsController.access$600(CabWidgetsController.this).nextActivityFromWidgetDealClick(dealsummary, CabWidgetsController.access$100(CabWidgetsController.this), CabWidgetsController.access$500(CabWidgetsController.this)));
    }

    public void onCabWidgetPageSelected(DealSummary dealsummary, int i)
    {
        CabWidgetsController.access$200(CabWidgetsController.this).logWidgetDealImpression(CabWidgetsController.access$100(CabWidgetsController.this).toString(), dealsummary, "INVALID_KEYSTRING", CabWidgetsController.access$500(CabWidgetsController.this), i);
    }

    public void onCabWidgetsInitialized(FilterableWidgetListAdapter filterablewidgetlistadapter)
    {
        CabWidgetsController.access$200(CabWidgetsController.this).setOriginatingNstChannel(CabWidgetsController.access$100(CabWidgetsController.this));
        CabWidgetsController.access$200(CabWidgetsController.this).setRequiresRedirectLogging(false);
        CabWidgetsController.access$300(CabWidgetsController.this).onCabWidgetsInitialized(filterablewidgetlistadapter);
    }

    private Y()
    {
        this$0 = CabWidgetsController.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
