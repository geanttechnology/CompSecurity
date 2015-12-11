// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout.d;


public final class c extends Enum
{

    private static final c $VALUES[];
    public static final c DEFAULT;
    public static final c GIFT_CARD;
    public static final c PROMO_CODE;

    private c(String s, int i)
    {
        super(s, i);
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/target/ui/fragment/checkout/d/c, s);
    }

    public static c[] values()
    {
        return (c[])$VALUES.clone();
    }

    static 
    {
        DEFAULT = new c("DEFAULT", 0);
        GIFT_CARD = new c("GIFT_CARD", 1);
        PROMO_CODE = new c("PROMO_CODE", 2);
        $VALUES = (new c[] {
            DEFAULT, GIFT_CARD, PROMO_CODE
        });
    }
}
