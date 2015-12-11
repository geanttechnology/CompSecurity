// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;


// Referenced classes of package com.amazon.mShop.net:
//            MetricsSender

public static final class  extends Enum
{

    private static final RefMarkerSender $VALUES[];
    public static final RefMarkerSender MShopSender;
    public static final RefMarkerSender RefMarkerSender;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mShop/net/MetricsSender$SenderType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MShopSender = new <init>("MShopSender", 0);
        RefMarkerSender = new <init>("RefMarkerSender", 1);
        $VALUES = (new .VALUES[] {
            MShopSender, RefMarkerSender
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
