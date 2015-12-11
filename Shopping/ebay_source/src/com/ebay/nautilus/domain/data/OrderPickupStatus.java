// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;

public final class OrderPickupStatus extends Enum
{

    private static final OrderPickupStatus $VALUES[];
    public static final OrderPickupStatus PendingMerchantConfirmation;
    public static final OrderPickupStatus Pickedup;
    public static final OrderPickupStatus PickupCancelledBuyerNoShow;
    public static final OrderPickupStatus PickupCancelledBuyerRejected;
    public static final OrderPickupStatus PickupCancelledOutOfStock;
    public static final OrderPickupStatus ReadyToPickup;

    private OrderPickupStatus(String s, int i)
    {
        super(s, i);
    }

    public static OrderPickupStatus getByName(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_15;
        }
        s = valueOf(s);
        return s;
        s;
        return null;
    }

    public static OrderPickupStatus valueOf(String s)
    {
        return (OrderPickupStatus)Enum.valueOf(com/ebay/nautilus/domain/data/OrderPickupStatus, s);
    }

    public static OrderPickupStatus[] values()
    {
        return (OrderPickupStatus[])$VALUES.clone();
    }

    static 
    {
        PendingMerchantConfirmation = new OrderPickupStatus("PendingMerchantConfirmation", 0);
        ReadyToPickup = new OrderPickupStatus("ReadyToPickup", 1);
        Pickedup = new OrderPickupStatus("Pickedup", 2);
        PickupCancelledOutOfStock = new OrderPickupStatus("PickupCancelledOutOfStock", 3);
        PickupCancelledBuyerRejected = new OrderPickupStatus("PickupCancelledBuyerRejected", 4);
        PickupCancelledBuyerNoShow = new OrderPickupStatus("PickupCancelledBuyerNoShow", 5);
        $VALUES = (new OrderPickupStatus[] {
            PendingMerchantConfirmation, ReadyToPickup, Pickedup, PickupCancelledOutOfStock, PickupCancelledBuyerRejected, PickupCancelledBuyerNoShow
        });
    }
}
