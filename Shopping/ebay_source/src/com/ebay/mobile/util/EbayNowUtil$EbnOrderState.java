// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;


// Referenced classes of package com.ebay.mobile.util:
//            EbayNowUtil

public static final class  extends Enum
{

    private static final CANCELLED $VALUES[];
    public static final CANCELLED CANCELLED;
    public static final CANCELLED DELIVERED;
    public static final CANCELLED IN_TRANSIT;
    public static final CANCELLED PENDING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/util/EbayNowUtil$EbnOrderState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PENDING = new <init>("PENDING", 0);
        IN_TRANSIT = new <init>("IN_TRANSIT", 1);
        DELIVERED = new <init>("DELIVERED", 2);
        CANCELLED = new <init>("CANCELLED", 3);
        $VALUES = (new .VALUES[] {
            PENDING, IN_TRANSIT, DELIVERED, CANCELLED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
