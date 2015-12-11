// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;


// Referenced classes of package com.ebay.common.net.api.cart:
//            GetUserIncentives

public static final class  extends Enum
{

    private static final REWARD $VALUES[];
    public static final REWARD COUPON;
    public static final REWARD GIFTCARD;
    public static final REWARD GIFTCERTIFICATE;
    public static final REWARD REWARD;
    public static final REWARD VOUCHER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/net/api/cart/GetUserIncentives$UserIncentiveType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        GIFTCERTIFICATE = new <init>("GIFTCERTIFICATE", 0);
        VOUCHER = new <init>("VOUCHER", 1);
        GIFTCARD = new <init>("GIFTCARD", 2);
        COUPON = new <init>("COUPON", 3);
        REWARD = new <init>("REWARD", 4);
        $VALUES = (new .VALUES[] {
            GIFTCERTIFICATE, VOUCHER, GIFTCARD, COUPON, REWARD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
