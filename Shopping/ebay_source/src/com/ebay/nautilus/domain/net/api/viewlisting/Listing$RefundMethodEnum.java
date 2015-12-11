// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final MONEY_BACK_OR_EXCHANGE $VALUES[];
    public static final MONEY_BACK_OR_EXCHANGE EXCHANGE;
    public static final MONEY_BACK_OR_EXCHANGE MERCHANDISE_CREDIT;
    public static final MONEY_BACK_OR_EXCHANGE MONEY_BACK;
    public static final MONEY_BACK_OR_EXCHANGE MONEY_BACK_OR_EXCHANGE;
    public static final MONEY_BACK_OR_EXCHANGE REPLACEMENT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$RefundMethodEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MONEY_BACK = new <init>("MONEY_BACK", 0);
        EXCHANGE = new <init>("EXCHANGE", 1);
        MERCHANDISE_CREDIT = new <init>("MERCHANDISE_CREDIT", 2);
        REPLACEMENT = new <init>("REPLACEMENT", 3);
        MONEY_BACK_OR_EXCHANGE = new <init>("MONEY_BACK_OR_EXCHANGE", 4);
        $VALUES = (new .VALUES[] {
            MONEY_BACK, EXCHANGE, MERCHANDISE_CREDIT, REPLACEMENT, MONEY_BACK_OR_EXCHANGE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
