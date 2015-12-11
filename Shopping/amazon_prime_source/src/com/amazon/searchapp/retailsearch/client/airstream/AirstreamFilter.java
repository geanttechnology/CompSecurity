// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.airstream;


public final class AirstreamFilter extends Enum
{

    private static final AirstreamFilter $VALUES[];
    public static final AirstreamFilter HOME;
    public static final AirstreamFilter MENS;
    public static final AirstreamFilter WOMENS;
    private final String value;

    private AirstreamFilter(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static AirstreamFilter valueOf(String s)
    {
        return (AirstreamFilter)Enum.valueOf(com/amazon/searchapp/retailsearch/client/airstream/AirstreamFilter, s);
    }

    public static AirstreamFilter[] values()
    {
        return (AirstreamFilter[])$VALUES.clone();
    }

    public String getValue()
    {
        return value;
    }

    static 
    {
        HOME = new AirstreamFilter("HOME", 0, "H");
        MENS = new AirstreamFilter("MENS", 1, "M");
        WOMENS = new AirstreamFilter("WOMENS", 2, "W");
        $VALUES = (new AirstreamFilter[] {
            HOME, MENS, WOMENS
        });
    }
}
