// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ebay.common.EbayTimer;
import com.ebay.mobile.Item;
import com.ebay.mobile.notifications.PushService;
import com.ebay.nautilus.kernel.util.FwLog;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

public class ItemViewBiddingUpdater
{
    private class NotificationReceiver extends BroadcastReceiver
    {

        final ItemViewBiddingUpdater this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (0x493e0L < item.getAuctionTimeRemainingMs())
            {
                if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
                {
                    FwLog.println(ItemViewBiddingUpdater.fwLogItemViewBidding, (new StringBuilder()).append(this).append(" Received outbid notification").toString());
                }
                sendViewItemLite(false);
            }
        }

        private NotificationReceiver()
        {
            this$0 = ItemViewBiddingUpdater.this;
            super();
        }

    }

    public static interface OnBidChangedEvent
    {

        public abstract void OnBidChanged(ViewItemDataManager.BidEvent bidevent);
    }

    public static final class UpdateMode extends Enum
    {

        private static final UpdateMode $VALUES[];
        public static final UpdateMode NONE;
        public static final UpdateMode POLLING;

        public static UpdateMode valueOf(String s)
        {
            return (UpdateMode)Enum.valueOf(com/ebay/mobile/viewitem/ItemViewBiddingUpdater$UpdateMode, s);
        }

        public static UpdateMode[] values()
        {
            return (UpdateMode[])$VALUES.clone();
        }

        static 
        {
            NONE = new UpdateMode("NONE", 0);
            POLLING = new UpdateMode("POLLING", 1);
            $VALUES = (new UpdateMode[] {
                NONE, POLLING
            });
        }

        private UpdateMode(String s, int i)
        {
            super(s, i);
        }
    }


    public static final long START_THRESHOLD = 0x493e0L;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo fwLogItemViewBidding = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("fwLogItemViewBidding", 3, "Log bidding updates in ItemView");
    private final Item item;
    private final long itemId;
    NotificationReceiver notificationReceiver;
    public OnBidChangedEvent onBidChangedEvent;
    private final EbayTimer timer = new EbayTimer(1000L);
    public UpdateMode updateMode;
    protected ViewItemDataManager viewItemDataManager;

    public ItemViewBiddingUpdater(ViewItemDataManager viewitemdatamanager, Item item1)
    {
        notificationReceiver = new NotificationReceiver();
        viewItemDataManager = viewitemdatamanager;
        itemId = item1.id;
        item = item1;
        setupTimer(item1);
    }

    private void setupTimer(final Item item)
    {
        timer.setOnTimerEvent(new com.ebay.common.EbayTimer.OnTimerEvent() {

            final ItemViewBiddingUpdater this$0;
            final Item val$item;

            public void OnTimer()
            {
                if (updateMode == UpdateMode.NONE && item.isListingTypeBid && !item.finalized && !item.isTransacted)
                {
                    startPolling();
                }
            }

            
            {
                this$0 = ItemViewBiddingUpdater.this;
                item = item1;
                super();
            }
        });
    }

    private void startPolling()
    {
        if (fwLogItemViewBidding.isLoggable)
        {
            FwLog.println(fwLogItemViewBidding, (new StringBuilder()).append(this).append(" ViewItemLite started").toString());
        }
        updateMode = UpdateMode.POLLING;
        sendViewItemLite(true);
    }

    private void stopPolling()
    {
        if (fwLogItemViewBidding.isLoggable)
        {
            FwLog.println(fwLogItemViewBidding, (new StringBuilder()).append(this).append(" ViewItemLite stopped").toString());
        }
        updateMode = UpdateMode.NONE;
    }

    public void sendViewItemLite(boolean flag)
    {
        if (fwLogItemViewBidding.isLoggable)
        {
            FwLog.logMethod(fwLogItemViewBidding, new Object[0]);
        }
        viewItemDataManager.getViewItemLite(itemId, flag);
    }

    public final void setOnBidChangedEvent(OnBidChangedEvent onbidchangedevent)
    {
        onBidChangedEvent = onbidchangedevent;
    }

    public void start(Context context)
    {
        if (fwLogItemViewBidding.isLoggable)
        {
            FwLog.logMethod(fwLogItemViewBidding, new Object[0]);
        }
        updateMode = UpdateMode.NONE;
        timer.start();
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction(PushService.PARAM_OUTBID_INTENT_FILTER);
        context.registerReceiver(notificationReceiver, intentfilter);
    }

    public void stop(Context context)
    {
        if (fwLogItemViewBidding.isLoggable)
        {
            FwLog.logMethod(fwLogItemViewBidding, new Object[0]);
        }
        stopUpdateMode();
        timer.stop();
        context.unregisterReceiver(notificationReceiver);
    }

    public void stopUpdateMode()
    {
        if (fwLogItemViewBidding.isLoggable)
        {
            FwLog.logMethod(fwLogItemViewBidding, new Object[0]);
        }
        if (UpdateMode.POLLING == updateMode)
        {
            stopPolling();
        }
    }



}
