// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;


// Referenced classes of package com.ebay.common.net.api.cart:
//            GetItemIncentives

public static final class  extends Enum
{

    private static final REWARD $VALUES[];
    public static final REWARD COUPON;
    public static final REWARD REWARD;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/net/api/cart/GetItemIncentives$ItemIncentiveType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        COUPON = new <init>("COUPON", 0);
        REWARD = new <init>("REWARD", 1);
        $VALUES = (new .VALUES[] {
            COUPON, REWARD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
