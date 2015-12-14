// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.model.res;


public final class FilterType extends Enum
{

    private static final FilterType $VALUES[];
    public static final FilterType Filter1;
    public static final FilterType Filter2;
    public static final FilterType Filter3;
    public static final FilterType Filter4;
    public static final FilterType Filter5;
    public static final FilterType Filter6;
    public static final FilterType Filter7;
    public static final FilterType Filter8;
    public static final FilterType Filter9;
    public static final FilterType NonFilter;
    public static final FilterType UnknownFilter;

    private FilterType(String s, int i)
    {
        super(s, i);
    }

    public static FilterType valueOf(String s)
    {
        return (FilterType)Enum.valueOf(com/wantu/model/res/FilterType, s);
    }

    public static FilterType[] values()
    {
        return (FilterType[])$VALUES.clone();
    }

    static 
    {
        NonFilter = new FilterType("NonFilter", 0);
        Filter1 = new FilterType("Filter1", 1);
        Filter2 = new FilterType("Filter2", 2);
        Filter3 = new FilterType("Filter3", 3);
        Filter4 = new FilterType("Filter4", 4);
        Filter5 = new FilterType("Filter5", 5);
        Filter6 = new FilterType("Filter6", 6);
        Filter7 = new FilterType("Filter7", 7);
        Filter8 = new FilterType("Filter8", 8);
        Filter9 = new FilterType("Filter9", 9);
        UnknownFilter = new FilterType("UnknownFilter", 10);
        $VALUES = (new FilterType[] {
            NonFilter, Filter1, Filter2, Filter3, Filter4, Filter5, Filter6, Filter7, Filter8, Filter9, 
            UnknownFilter
        });
    }
}
