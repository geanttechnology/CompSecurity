// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import com.ebay.nautilus.domain.data.EbnOrderCancelReason;

// Referenced classes of package com.ebay.mobile.util:
//            EbayNowUtil

static class nOrderState
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
        $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState = new int[nOrderState.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[nOrderState.PENDING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[nOrderState.IN_TRANSIT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[nOrderState.DELIVERED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[nOrderState.CANCELLED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
