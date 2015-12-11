// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;


// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            AddMemberMessageAAQRequest

public static final class  extends Enum
{

    private static final CustomizedSubject $VALUES[];
    public static final CustomizedSubject CustomizedSubject;
    public static final CustomizedSubject General;
    public static final CustomizedSubject MultipleItemShipping;
    public static final CustomizedSubject Payment;
    public static final CustomizedSubject Shipping;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/trading/AddMemberMessageAAQRequest$QuestionType, s);
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
        CustomizedSubject = new <init>("CustomizedSubject", 4);
        $VALUES = (new .VALUES[] {
            General, MultipleItemShipping, Payment, Shipping, CustomizedSubject
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
