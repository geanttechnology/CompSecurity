// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingLabelContact

public static final class  extends Enum
{

    private static final LOCKER $VALUES[];
    public static final LOCKER BUSINESS;
    public static final LOCKER LOCKER;
    public static final LOCKER RESIDENTIAL;
    public static final LOCKER STORE;
    public static final LOCKER WAREHOUSE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/ShippingLabelContact$ShippingLocationType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RESIDENTIAL = new <init>("RESIDENTIAL", 0);
        BUSINESS = new <init>("BUSINESS", 1);
        WAREHOUSE = new <init>("WAREHOUSE", 2);
        STORE = new <init>("STORE", 3);
        LOCKER = new <init>("LOCKER", 4);
        $VALUES = (new .VALUES[] {
            RESIDENTIAL, BUSINESS, WAREHOUSE, STORE, LOCKER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
