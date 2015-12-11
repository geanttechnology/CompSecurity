// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.tender;


public final class c extends Enum
{

    private static final c $VALUES[];
    public static final c GIFT_CARD;
    public static final c INTERNATIONAL_CARD;
    public static final c PAYMENT_CARD;
    private String mValue;

    private c(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/target/mothership/common/tender/c, s);
    }

    public static c[] values()
    {
        return (c[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        PAYMENT_CARD = new c("PAYMENT_CARD", 0, "PC");
        INTERNATIONAL_CARD = new c("INTERNATIONAL_CARD", 1, "IC");
        GIFT_CARD = new c("GIFT_CARD", 2, "GC");
        $VALUES = (new c[] {
            PAYMENT_CARD, INTERNATIONAL_CARD, GIFT_CARD
        });
    }
}
