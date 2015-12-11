// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.Handler;
import com.ebay.mobile.Item;
import com.ebay.nautilus.kernel.util.FwLog;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager, ItemViewBiddingUpdater

private static class item extends Handler
    implements Runnable
{

    public static final long oneMinute = 60000L;
    public static final long oneSecond = 1000L;
    private final WeakReference biddingUpdater;
    private final Item item;

    private long getNextViewItemLitePostDelayMs()
    {
        if (ItemViewBiddingUpdater.fwLogItemViewBidding.g)
        {
            FwLog.logMethod(ItemViewBiddingUpdater.fwLogItemViewBidding, new Object[0]);
        }
        long l = 1000L;
        if ((ItemViewBiddingUpdater)biddingUpdater.get() != null)
        {
            l = ViewItemDataManager.getNextViewItemLiteDelayMs(item.getAuctionTimeRemainingMs());
        }
        return l;
    }

    public void run()
    {
        if (ItemViewBiddingUpdater.fwLogItemViewBidding.g)
        {
            FwLog.logMethod(ItemViewBiddingUpdater.fwLogItemViewBidding, new Object[0]);
        }
        ItemViewBiddingUpdater itemviewbiddingupdater = (ItemViewBiddingUpdater)biddingUpdater.get();
        if (itemviewbiddingupdater != null && LING == itemviewbiddingupdater.updateMode)
        {
            itemviewbiddingupdater.sendViewItemLite(true);
        }
    }


    public (ItemViewBiddingUpdater itemviewbiddingupdater, Item item1)
    {
        biddingUpdater = new WeakReference(itemviewbiddingupdater);
        item = item1;
    }
}
