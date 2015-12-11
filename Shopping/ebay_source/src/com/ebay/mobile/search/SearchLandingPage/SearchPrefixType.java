// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.SearchLandingPage;


public final class SearchPrefixType extends Enum
{

    private static final SearchPrefixType $VALUES[];
    public static final SearchPrefixType EAN;
    public static final SearchPrefixType NORMAL;
    public static final SearchPrefixType SELLER;
    public static final SearchPrefixType UPC;
    private final String name;

    private SearchPrefixType(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static SearchPrefixType valueOf(String s)
    {
        return (SearchPrefixType)Enum.valueOf(com/ebay/mobile/search/SearchLandingPage/SearchPrefixType, s);
    }

    public static SearchPrefixType[] values()
    {
        return (SearchPrefixType[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        NORMAL = new SearchPrefixType("NORMAL", 0, "");
        SELLER = new SearchPrefixType("SELLER", 1, "seller:");
        EAN = new SearchPrefixType("EAN", 2, "EAN:");
        UPC = new SearchPrefixType("UPC", 3, "UPC:");
        $VALUES = (new SearchPrefixType[] {
            NORMAL, SELLER, EAN, UPC
        });
    }
}
