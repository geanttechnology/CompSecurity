// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.tender;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a AMEX;
    public static final a DISCOVER;
    public static final a MASTER_CARD;
    public static final a PAYPAL;
    public static final a TARGET_BUSINESS;
    public static final a TARGET_CARD;
    public static final a TARGET_DEBIT;
    public static final a TARGET_GIFT_CARD;
    public static final a TARGET_MASTERCARD;
    public static final a TARGET_RED_CARD;
    public static final a TARGET_VISA;
    public static final a UNKNOWN;
    public static final a VISA;
    private final String mValue;

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
        return UNKNOWN;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/mothership/common/tender/a, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    public String a()
    {
        return mValue;
    }

    static 
    {
        TARGET_GIFT_CARD = new a("TARGET_GIFT_CARD", 0, "TargetGiftCard");
        VISA = new a("VISA", 1, "Visa");
        MASTER_CARD = new a("MASTER_CARD", 2, "MasterCard");
        AMEX = new a("AMEX", 3, "American Express");
        DISCOVER = new a("DISCOVER", 4, "Discover");
        TARGET_MASTERCARD = new a("TARGET_MASTERCARD", 5, "MasterCard");
        TARGET_VISA = new a("TARGET_VISA", 6, "Target Visa Credit Card");
        TARGET_BUSINESS = new a("TARGET_BUSINESS", 7, "Target Business Card");
        TARGET_CARD = new a("TARGET_CARD", 8, "Target Card");
        TARGET_DEBIT = new a("TARGET_DEBIT", 9, "Target Debit Card");
        TARGET_RED_CARD = new a("TARGET_RED_CARD", 10, "Target Red Card");
        PAYPAL = new a("PAYPAL", 11, "PayPal");
        UNKNOWN = new a("UNKNOWN", 12, "unknown");
        $VALUES = (new a[] {
            TARGET_GIFT_CARD, VISA, MASTER_CARD, AMEX, DISCOVER, TARGET_MASTERCARD, TARGET_VISA, TARGET_BUSINESS, TARGET_CARD, TARGET_DEBIT, 
            TARGET_RED_CARD, PAYPAL, UNKNOWN
        });
    }
}
