// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingOption

public static final class Q extends Enum
{

    private static final DISCOUNTED $VALUES[];
    public static final DISCOUNTED DISCOUNTED;
    public static final DISCOUNTED RETAIL;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/ebay/nautilus/domain/data/ShippingOption$ShippingCostPlan$CostPlanTypes, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        RETAIL = new <init>("RETAIL", 0);
        DISCOUNTED = new <init>("DISCOUNTED", 1);
        $VALUES = (new .VALUES[] {
            RETAIL, DISCOUNTED
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
