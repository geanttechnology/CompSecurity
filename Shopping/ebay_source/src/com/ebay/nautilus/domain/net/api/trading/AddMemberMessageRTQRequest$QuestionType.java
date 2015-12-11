// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;


// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            AddMemberMessageRTQRequest

public static final class  extends Enum
{

    private static final Shipping $VALUES[];
    public static final Shipping General;
    public static final Shipping MultipleItemShipping;
    public static final Shipping Payment;
    public static final Shipping Shipping;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/trading/AddMemberMessageRTQRequest$QuestionType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        General = new <init>("General", 0);
        MultipleItemShipping = new <init>("MultipleItemShipping", 1);
        Payment = new <init>("Payment", 2);
        Shipping = new <init>("Shipping", 3);
        $VALUES = (new .VALUES[] {
            General, MultipleItemShipping, Payment, Shipping
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
