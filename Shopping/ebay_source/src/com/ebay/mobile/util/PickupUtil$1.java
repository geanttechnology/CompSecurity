// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import com.ebay.nautilus.domain.data.OrderPickupStatus;

// Referenced classes of package com.ebay.mobile.util:
//            PickupUtil

static class rPickupStatus
{

    static final int $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[];

    static 
    {
        $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus = new int[OrderPickupStatus.values().length];
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.PendingMerchantConfirmation.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.ReadyToPickup.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.Pickedup.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.PickupCancelledBuyerRejected.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.PickupCancelledBuyerNoShow.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.PickupCancelledOutOfStock.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
