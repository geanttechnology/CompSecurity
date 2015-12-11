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
//            CavWidgetsController

private class <init> extends DefaultOnDealDetailsWidgetsEventListener
{

    final CavWidgetsController this$0;

    public void onCavWidgetClick(View view, DealSummary dealsummary)
    {
        CavWidgetsController.access$200(CavWidgetsController.this).logWidgetDealClick(dealsummary, "mm_deal_details", CavWidgetsController.access$400(CavWidgetsController.this).uuid, CavWidgetsController.access$500(CavWidgetsController.this));
        context.startActivity(CavWidgetsController.access$600(CavWidgetsController.this).nextActivityFromWidgetDealClick(dealsummary, CavWidgetsController.access$100(CavWidgetsController.this), CavWidgetsController.access$500(CavWidgetsController.this)));
    }

    public void onCavWidgetPageSelected(DealSummary dealsummary, int i)
    {
        CavWidgetsController.access$200(CavWidgetsController.this).logWidgetDealImpression(CavWidgetsController.access$100(CavWidgetsController.this).toString(), dealsummary, "INVALID_KEYSTRING", CavWidgetsController.access$500(CavWidgetsController.this), i);
    }

    public void onCavWidgetsInitialized(FilterableWidgetListAdapter filterablewidgetlistadapter)
    {
        CavWidgetsController.access$200(CavWidgetsController.this).setOriginatingNstChannel(CavWidgetsController.access$100(CavWidgetsController.this));
        CavWidgetsController.access$200(CavWidgetsController.this).setRequiresRedirectLogging(false);
        CavWidgetsController.access$300(CavWidgetsController.this).onCavWidgetsInitialized(filterablewidgetlistadapter);
    }

    private Y()
    {
        this$0 = CavWidgetsController.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
