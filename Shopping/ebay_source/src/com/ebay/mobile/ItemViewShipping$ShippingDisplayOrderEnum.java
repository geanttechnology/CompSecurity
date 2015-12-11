// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;


// Referenced classes of package com.ebay.mobile:
//            ItemViewShipping

public static final class  extends Enum
{

    private static final SERVICE_NAME $VALUES[];
    public static final SERVICE_NAME COST;
    public static final SERVICE_NAME EDD;
    public static final SERVICE_NAME LOCATION;
    public static final SERVICE_NAME SERVICE_NAME;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/ItemViewShipping$ShippingDisplayOrderEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EDD = new <init>("EDD", 0);
        COST = new <init>("COST", 1);
        LOCATION = new <init>("LOCATION", 2);
        SERVICE_NAME = new <init>("SERVICE_NAME", 3);
        $VALUES = (new .VALUES[] {
            EDD, COST, LOCATION, SERVICE_NAME
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
