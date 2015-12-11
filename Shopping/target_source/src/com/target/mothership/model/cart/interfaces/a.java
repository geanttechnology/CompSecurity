// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a DD;
    public static final a EMAIL_GIFT_CARD;
    public static final a LTL;
    public static final a MAIL_GIFT_CARD;
    public static final a MOBILE_GIFT_CARD;
    public static final a NONE;
    public static final a STANDARD;
    private String mValue;

    private a(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static a a(String s)
    {
        if (s != null)
        {
            a aa[] = values();
            int j = aa.length;
            for (int i = 0; i < j; i++)
            {
                a a1 = aa[i];
                if (s.equalsIgnoreCase(a1.mValue))
                {
                    return a1;
                }
            }

        }
        return NONE;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/mothership/model/cart/interfaces/a, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        DD = new a("DD", 0, "DD");
        LTL = new a("LTL", 1, "LTL");
        STANDARD = new a("STANDARD", 2, "Standard");
        EMAIL_GIFT_CARD = new a("EMAIL_GIFT_CARD", 3, "EmailGiftCard");
        MOBILE_GIFT_CARD = new a("MOBILE_GIFT_CARD", 4, "MobileGiftCard");
        MAIL_GIFT_CARD = new a("MAIL_GIFT_CARD", 5, "MailGiftCard");
        NONE = new a("NONE", 6, "");
        $VALUES = (new a[] {
            DD, LTL, STANDARD, EMAIL_GIFT_CARD, MOBILE_GIFT_CARD, MAIL_GIFT_CARD, NONE
        });
    }
}
