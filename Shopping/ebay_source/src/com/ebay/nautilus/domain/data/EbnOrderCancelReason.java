// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;

public final class EbnOrderCancelReason extends Enum
{

    private static final EbnOrderCancelReason $VALUES[];
    public static final EbnOrderCancelReason BuyerCancelOrder;
    public static final EbnOrderCancelReason BuyerNoShow;
    public static final EbnOrderCancelReason BuyerRefused;
    public static final EbnOrderCancelReason NOT_SET;
    public static final EbnOrderCancelReason OutOfStock;
    public static final EbnOrderCancelReason ValetDeliveryIssues;
    public static final EbnOrderCancelReason ValetUnavailable;

    private EbnOrderCancelReason(String s, int i)
    {
        super(s, i);
    }

    public static EbnOrderCancelReason getByName(String s)
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

    public static EbnOrderCancelReason valueOf(String s)
    {
        return (EbnOrderCancelReason)Enum.valueOf(com/ebay/nautilus/domain/data/EbnOrderCancelReason, s);
    }

    public static EbnOrderCancelReason[] values()
    {
        return (EbnOrderCancelReason[])$VALUES.clone();
    }

    static 
    {
        NOT_SET = new EbnOrderCancelReason("NOT_SET", 0);
        OutOfStock = new EbnOrderCancelReason("OutOfStock", 1);
        BuyerNoShow = new EbnOrderCancelReason("BuyerNoShow", 2);
        BuyerRefused = new EbnOrderCancelReason("BuyerRefused", 3);
        BuyerCancelOrder = new EbnOrderCancelReason("BuyerCancelOrder", 4);
        ValetDeliveryIssues = new EbnOrderCancelReason("ValetDeliveryIssues", 5);
        ValetUnavailable = new EbnOrderCancelReason("ValetUnavailable", 6);
        $VALUES = (new EbnOrderCancelReason[] {
            NOT_SET, OutOfStock, BuyerNoShow, BuyerRefused, BuyerCancelOrder, ValetDeliveryIssues, ValetUnavailable
        });
    }
}
