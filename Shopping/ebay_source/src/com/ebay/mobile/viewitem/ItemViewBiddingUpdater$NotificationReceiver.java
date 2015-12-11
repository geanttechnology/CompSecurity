// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ebay.mobile.Item;
import com.ebay.nautilus.kernel.util.FwLog;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBiddingUpdater

private class <init> extends BroadcastReceiver
{

    final ItemViewBiddingUpdater this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (0x493e0L < ItemViewBiddingUpdater.access$200(ItemViewBiddingUpdater.this).getAuctionTimeRemainingMs())
        {
            if (ItemViewBiddingUpdater.fwLogItemViewBidding._fld0)
            {
                FwLog.println(ItemViewBiddingUpdater.fwLogItemViewBidding, (new StringBuilder()).append(this).append(" Received outbid notification").toString());
            }
            sendViewItemLite(false);
        }
    }

    private ()
    {
        this$0 = ItemViewBiddingUpdater.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
