// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            MarketingHandler

class val.campaignId
    implements Runnable
{

    final MarketingHandler this$0;
    final int val$campaignId;

    public void run()
    {
        _setMarketingMessageAsNotDisplayed(val$campaignId);
    }

    ()
    {
        this$0 = final_marketinghandler;
        val$campaignId = I.this;
        super();
    }
}
