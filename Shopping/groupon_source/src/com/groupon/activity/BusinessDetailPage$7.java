// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.Channel;
import com.groupon.db.models.Deal;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.activity:
//            BusinessDetailPage, IntentFactory

class val.deal
    implements android.view.lPage._cls7
{

    final BusinessDetailPage this$0;
    final Deal val$deal;

    public void onClick(View view)
    {
        Deal deal1 = (Deal)view.getTag();
        LoggingUtils loggingutils = BusinessDetailPage.access$500(BusinessDetailPage.this);
        if (isListOffers)
        {
            view = "offer_screen_deal_click";
        } else
        {
            view = "deal_click";
        }
        loggingutils.logClick("", view, val$deal.remoteId, "");
        view = BusinessDetailPage.access$400(BusinessDetailPage.this).newDealIntent(deal1, Channel.MERCHANT_PAGE);
        startActivity(view);
    }

    ()
    {
        this$0 = final_businessdetailpage;
        val$deal = Deal.this;
        super();
    }
}
