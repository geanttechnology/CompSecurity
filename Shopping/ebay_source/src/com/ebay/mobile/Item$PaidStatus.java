// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;


// Referenced classes of package com.ebay.mobile:
//            Item

public static final class  extends Enum
{

    private static final REFUNDED $VALUES[];
    public static final REFUNDED NOT_PAID;
    public static final REFUNDED PAID;
    public static final REFUNDED PENDING;
    public static final REFUNDED REFUNDED;
    public static final REFUNDED UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/Item$PaidStatus, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        PAID = new <init>("PAID", 1);
        NOT_PAID = new <init>("NOT_PAID", 2);
        PENDING = new <init>("PENDING", 3);
        REFUNDED = new <init>("REFUNDED", 4);
        $VALUES = (new .VALUES[] {
            UNKNOWN, PAID, NOT_PAID, PENDING, REFUNDED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
