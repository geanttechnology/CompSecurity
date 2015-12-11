// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netswipe.sdk.enums;


public final class CreditCardType extends Enum
{

    private static final CreditCardType $VALUES[];
    public static final CreditCardType AMERICAN_EXPRESS;
    public static final CreditCardType CHINA_UNIONPAY;
    public static final CreditCardType DINERS_CLUB;
    public static final CreditCardType DISCOVER;
    public static final CreditCardType JCB;
    public static final CreditCardType MASTER_CARD;
    public static final CreditCardType PRIVATE_LABEL;
    public static final CreditCardType UNKNOWN;
    public static final CreditCardType VISA;

    private CreditCardType(String s, int i)
    {
        super(s, i);
    }

    public static CreditCardType valueOf(String s)
    {
        return (CreditCardType)Enum.valueOf(com/jumio/netswipe/sdk/enums/CreditCardType, s);
    }

    public static CreditCardType[] values()
    {
        return (CreditCardType[])$VALUES.clone();
    }

    static 
    {
        VISA = new CreditCardType("VISA", 0);
        MASTER_CARD = new CreditCardType("MASTER_CARD", 1);
        AMERICAN_EXPRESS = new CreditCardType("AMERICAN_EXPRESS", 2);
        DINERS_CLUB = new CreditCardType("DINERS_CLUB", 3);
        DISCOVER = new CreditCardType("DISCOVER", 4);
        CHINA_UNIONPAY = new CreditCardType("CHINA_UNIONPAY", 5);
        JCB = new CreditCardType("JCB", 6);
        PRIVATE_LABEL = new CreditCardType("PRIVATE_LABEL", 7);
        UNKNOWN = new CreditCardType("UNKNOWN", 8);
        $VALUES = (new CreditCardType[] {
            VISA, MASTER_CARD, AMERICAN_EXPRESS, DINERS_CLUB, DISCOVER, CHINA_UNIONPAY, JCB, PRIVATE_LABEL, UNKNOWN
        });
    }
}
