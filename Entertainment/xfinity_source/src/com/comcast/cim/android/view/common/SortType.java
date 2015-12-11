// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;


public final class SortType extends Enum
{

    private static final SortType $VALUES[];
    public static final SortType HD;
    public static final SortType PRICE;
    public static final SortType RANK;
    public static final SortType RELEASE_DATE;
    public static final SortType TITLE;
    public static final SortType YEAR;

    private SortType(String s, int i)
    {
        super(s, i);
    }

    public static SortType valueOf(String s)
    {
        return (SortType)Enum.valueOf(com/comcast/cim/android/view/common/SortType, s);
    }

    public static SortType[] values()
    {
        return (SortType[])$VALUES.clone();
    }

    static 
    {
        TITLE = new SortType("TITLE", 0);
        RANK = new SortType("RANK", 1);
        PRICE = new SortType("PRICE", 2);
        HD = new SortType("HD", 3);
        YEAR = new SortType("YEAR", 4);
        RELEASE_DATE = new SortType("RELEASE_DATE", 5);
        $VALUES = (new SortType[] {
            TITLE, RANK, PRICE, HD, YEAR, RELEASE_DATE
        });
    }
}
