// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a AMOUNT_OFF_WITH_CODE;
    public static final a AMOUNT_OFF_WITH_COUPON;
    public static final a FREE_GIFT;
    public static final a FREE_GIFT_CARD;
    public static final a NEW_AT_TARGET;
    public static final a ONLY_AT_TARGET;
    public static final a PERCENTAGE_OFF;
    public static final a UNKNOWN;
    private String mValue;

    private a(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static a a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        a a1 = UNKNOWN;
_L4:
        return a1;
_L2:
        a aa[];
        int i;
        int j;
        aa = values();
        j = aa.length;
        i = 0;
_L6:
        a a2;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        a2 = aa[i];
        a1 = a2;
        if (s.equalsIgnoreCase(a2.toString())) goto _L4; else goto _L3
_L3:
        a1 = a2;
        if (s.equalsIgnoreCase(a2.name())) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
        return UNKNOWN;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/mothership/common/product/a, s);
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
        FREE_GIFT = new a("FREE_GIFT", 0, "FREE_GIFT");
        FREE_GIFT_CARD = new a("FREE_GIFT_CARD", 1, "FREE_GIFT_CARD");
        AMOUNT_OFF_WITH_COUPON = new a("AMOUNT_OFF_WITH_COUPON", 2, "AMOUNT_OFF_WITH_COUPON");
        AMOUNT_OFF_WITH_CODE = new a("AMOUNT_OFF_WITH_CODE", 3, "AMOUNT_OFF_WITH_CODE");
        PERCENTAGE_OFF = new a("PERCENTAGE_OFF", 4, "PERCENT_OFF_WITH_CODE");
        ONLY_AT_TARGET = new a("ONLY_AT_TARGET", 5, "ONLY_AT_TARGET");
        NEW_AT_TARGET = new a("NEW_AT_TARGET", 6, "NEW_AT_TARGET");
        UNKNOWN = new a("UNKNOWN", 7, "");
        $VALUES = (new a[] {
            FREE_GIFT, FREE_GIFT_CARD, AMOUNT_OFF_WITH_COUPON, AMOUNT_OFF_WITH_CODE, PERCENTAGE_OFF, ONLY_AT_TARGET, NEW_AT_TARGET, UNKNOWN
        });
    }
}
