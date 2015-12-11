// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.payment.alipay;


// Referenced classes of package com.amazon.mShop.payment.alipay:
//            AlipayCallback

public static final class  extends Enum
{

    private static final memo $VALUES[];
    public static final memo memo;
    public static final memo result;
    public static final memo resultStatus;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mShop/payment/alipay/AlipayCallback$ResultField, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        resultStatus = new <init>("resultStatus", 0);
        result = new <init>("result", 1);
        memo = new <init>("memo", 2);
        $VALUES = (new .VALUES[] {
            resultStatus, result, memo
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
