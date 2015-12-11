// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.ebay.common.model.ItemTransaction;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.data.EbnOrderCancelReason;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.data.ShipmentTrackingDetail;
import com.ebay.nautilus.kernel.util.FwLog;
import java.util.List;

public class EbayNowUtil
{
    public static final class EbnOrderState extends Enum
    {

        private static final EbnOrderState $VALUES[];
        public static final EbnOrderState CANCELLED;
        public static final EbnOrderState DELIVERED;
        public static final EbnOrderState IN_TRANSIT;
        public static final EbnOrderState PENDING;

        public static EbnOrderState valueOf(String s)
        {
            return (EbnOrderState)Enum.valueOf(com/ebay/mobile/util/EbayNowUtil$EbnOrderState, s);
        }

        public static EbnOrderState[] values()
        {
            return (EbnOrderState[])$VALUES.clone();
        }

        static 
        {
            PENDING = new EbnOrderState("PENDING", 0);
            IN_TRANSIT = new EbnOrderState("IN_TRANSIT", 1);
            DELIVERED = new EbnOrderState("DELIVERED", 2);
            CANCELLED = new EbnOrderState("CANCELLED", 3);
            $VALUES = (new EbnOrderState[] {
                PENDING, IN_TRANSIT, DELIVERED, CANCELLED
            });
        }

        private EbnOrderState(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TRACKING_STATUS_DELIVERED = "DELIVERED";
    private static final String TRACKING_STATUS_IN_TRANSIT = "IN_TRANSIT";
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo verboseLogger;

    public EbayNowUtil()
    {
    }

    public static String getCancelledReason(Context context, ItemTransaction itemtransaction)
    {
        itemtransaction = itemtransaction.cancelReason;
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[];
            static final int $SwitchMap$com$ebay$nautilus$domain$data$EbnOrderCancelReason[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$data$EbnOrderCancelReason = new int[EbnOrderCancelReason.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$EbnOrderCancelReason[EbnOrderCancelReason.OutOfStock.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$EbnOrderCancelReason[EbnOrderCancelReason.BuyerNoShow.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$EbnOrderCancelReason[EbnOrderCancelReason.BuyerRefused.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$EbnOrderCancelReason[EbnOrderCancelReason.ValetDeliveryIssues.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$EbnOrderCancelReason[EbnOrderCancelReason.ValetUnavailable.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$EbnOrderCancelReason[EbnOrderCancelReason.NOT_SET.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState = new int[EbnOrderState.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[EbnOrderState.PENDING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[EbnOrderState.IN_TRANSIT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[EbnOrderState.DELIVERED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[EbnOrderState.CANCELLED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.nautilus.domain.data.EbnOrderCancelReason[itemtransaction.ordinal()];
        JVM INSTR tableswitch 1 5: default 48
    //                   1 60
    //                   2 66
    //                   3 72
    //                   4 78
    //                   5 78;
           goto _L1 _L2 _L3 _L4 _L5 _L5
_L1:
        int i = 0x7f070390;
_L7:
        return context.getResources().getString(i);
_L2:
        i = 0x7f070397;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 0x7f070384;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 0x7f070385;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 0x7f07039d;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static String getDeliveryStatusText(Activity activity, ItemTransaction itemtransaction, ShipmentTracking shipmenttracking)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[] {
                activity, itemtransaction, shipmenttracking
            });
        }
        return getDeliveryStatusText(activity, getOrderState(itemtransaction, shipmenttracking), itemtransaction);
    }

    public static String getDeliveryStatusText(Activity activity, EbnOrderState ebnorderstate, ItemTransaction itemtransaction)
    {
        int i;
        boolean flag;
        flag = activity instanceof ItemViewActivity;
        i = 0x7f070398;
        if (flag)
        {
            i = 0x7f070399;
        }
        _cls1..SwitchMap.com.ebay.mobile.util.EbayNowUtil.EbnOrderState[ebnorderstate.ordinal()];
        JVM INSTR tableswitch 1 4: default 56
    //                   1 65
    //                   2 79
    //                   3 93
    //                   4 107;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return activity.getResources().getString(i);
_L2:
        i = 0x7f070398;
        if (flag)
        {
            i = 0x7f070399;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        i = 0x7f070391;
        if (flag)
        {
            i = 0x7f070392;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        i = 0x7f070388;
        if (flag)
        {
            i = 0x7f070389;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        int j = 0x7f070386;
        i = j;
        if (itemtransaction != null)
        {
            i = j;
            if (itemtransaction.isInStoreCredit())
            {
                i = 0x7f070387;
            }
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public static EbnOrderState getOrderState(ItemTransaction itemtransaction, ShipmentTracking shipmenttracking)
    {
        EbnOrderState ebnorderstate;
        EbnOrderState ebnorderstate1;
        ebnorderstate1 = EbnOrderState.PENDING;
        ebnorderstate = ebnorderstate1;
        if (itemtransaction == null) goto _L2; else goto _L1
_L1:
        ebnorderstate = ebnorderstate1;
        if (shipmenttracking == null) goto _L2; else goto _L3
_L3:
        if (!"Completed".equals(itemtransaction.orderStatus)) goto _L5; else goto _L4
_L4:
        itemtransaction = shipmenttracking.details;
        ebnorderstate = ebnorderstate1;
        if (itemtransaction == null) goto _L2; else goto _L6
_L6:
        ebnorderstate = ebnorderstate1;
        if (itemtransaction.size() <= 0) goto _L2; else goto _L7
_L7:
        itemtransaction = (ShipmentTrackingDetail)itemtransaction.get(itemtransaction.size() - 1);
        if (!"IN_TRANSIT".equals(((ShipmentTrackingDetail) (itemtransaction)).trackingStatus)) goto _L9; else goto _L8
_L8:
        ebnorderstate = EbnOrderState.IN_TRANSIT;
_L2:
        return ebnorderstate;
_L9:
        ebnorderstate = ebnorderstate1;
        if ("DELIVERED".equals(((ShipmentTrackingDetail) (itemtransaction)).trackingStatus))
        {
            return EbnOrderState.DELIVERED;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        ebnorderstate = ebnorderstate1;
        if ("Cancelled".equals(itemtransaction.orderStatus))
        {
            return EbnOrderState.CANCELLED;
        }
        if (true) goto _L2; else goto _L10
_L10:
    }

    static 
    {
        debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("EbnOrderDetails", 3, "Log eBay Now Order Details events");
        verboseLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(debugLogger.tag, 2, "Log extended eBay Now Order Details events");
    }
}
