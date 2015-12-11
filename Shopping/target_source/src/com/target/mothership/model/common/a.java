// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a Billing;
    public static final a Shipping;
    public static final a ShippingAndBilling;
    private String mValue;

    private a(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/mothership/model/common/a, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        Shipping = new a("Shipping", 0, "S");
        Billing = new a("Billing", 1, "B");
        ShippingAndBilling = new a("ShippingAndBilling", 2, "SB");
        $VALUES = (new a[] {
            Shipping, Billing, ShippingAndBilling
        });
    }
}
