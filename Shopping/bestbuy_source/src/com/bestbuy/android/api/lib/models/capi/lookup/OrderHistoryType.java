// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.lookup;


public final class OrderHistoryType extends Enum
{

    private static final OrderHistoryType $VALUES[];
    public static final OrderHistoryType CAPIOrderHistory12Month;
    public static final OrderHistoryType CAPIOrderHistory3Month;
    public static final OrderHistoryType CAPIOrderHistory6Month;

    private OrderHistoryType(String s, int i)
    {
        super(s, i);
    }

    public static OrderHistoryType valueOf(String s)
    {
        return (OrderHistoryType)Enum.valueOf(com/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType, s);
    }

    public static OrderHistoryType[] values()
    {
        return (OrderHistoryType[])$VALUES.clone();
    }

    static 
    {
        CAPIOrderHistory3Month = new OrderHistoryType("CAPIOrderHistory3Month", 0);
        CAPIOrderHistory6Month = new OrderHistoryType("CAPIOrderHistory6Month", 1);
        CAPIOrderHistory12Month = new OrderHistoryType("CAPIOrderHistory12Month", 2);
        $VALUES = (new OrderHistoryType[] {
            CAPIOrderHistory3Month, CAPIOrderHistory6Month, CAPIOrderHistory12Month
        });
    }
}
