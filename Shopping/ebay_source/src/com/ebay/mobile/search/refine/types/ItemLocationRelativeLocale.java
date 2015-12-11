// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.types;


public final class ItemLocationRelativeLocale extends Enum
{

    private static final ItemLocationRelativeLocale $VALUES[];
    public static final ItemLocationRelativeLocale CURRENT_COUNTRY;
    public static final ItemLocationRelativeLocale ON_EBAY;
    public static final ItemLocationRelativeLocale WORLDWIDE;

    private ItemLocationRelativeLocale(String s, int i)
    {
        super(s, i);
    }

    public static ItemLocationRelativeLocale valueOf(String s)
    {
        return (ItemLocationRelativeLocale)Enum.valueOf(com/ebay/mobile/search/refine/types/ItemLocationRelativeLocale, s);
    }

    public static ItemLocationRelativeLocale[] values()
    {
        return (ItemLocationRelativeLocale[])$VALUES.clone();
    }

    static 
    {
        CURRENT_COUNTRY = new ItemLocationRelativeLocale("CURRENT_COUNTRY", 0);
        WORLDWIDE = new ItemLocationRelativeLocale("WORLDWIDE", 1);
        ON_EBAY = new ItemLocationRelativeLocale("ON_EBAY", 2);
        $VALUES = (new ItemLocationRelativeLocale[] {
            CURRENT_COUNTRY, WORLDWIDE, ON_EBAY
        });
    }
}
