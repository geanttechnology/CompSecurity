// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            MarketingCallable, MarketingHandler, LocalyticsDao, MarketingRulesAdapter

class nit> extends MarketingCallable
{

    final MarketingHandler this$0;
    final MarketingRulesAdapter val$adapter;

    Object call(Object aobj[])
    {
        mLocalyticsDao.tagEvent("Test Mode Update Data");
        MarketingHandler.access$602(MarketingHandler.this, val$adapter);
        upload(mLocalyticsDao.getCustomerIdInMemory());
        return null;
    }

    r()
    {
        this$0 = final_marketinghandler;
        val$adapter = MarketingRulesAdapter.this;
        super();
    }
}
