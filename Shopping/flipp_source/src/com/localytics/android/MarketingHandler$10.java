// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.support.v4.app.ah;

// Referenced classes of package com.localytics.android:
//            MarketingCallable, MarketingRulesAdapter, MarketingHandler, TestModeListView

class nit> extends MarketingCallable
{

    final MarketingHandler this$0;
    final MarketingRulesAdapter val$adapter;
    final TestModeListView val$listView;

    Object call(Object aobj[])
    {
        val$adapter.updateDataSet();
        val$listView.show(MarketingHandler.access$300(MarketingHandler.this), "marketing_test_mode_list");
        MarketingHandler.access$300(MarketingHandler.this).b();
        return null;
    }

    r()
    {
        this$0 = final_marketinghandler;
        val$adapter = marketingrulesadapter;
        val$listView = TestModeListView.this;
        super();
    }
}
