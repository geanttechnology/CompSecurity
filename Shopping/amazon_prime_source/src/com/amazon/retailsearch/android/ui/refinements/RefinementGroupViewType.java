// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;


public final class RefinementGroupViewType extends Enum
{

    private static final RefinementGroupViewType $VALUES[];
    public static final RefinementGroupViewType FILTER_ITEM;
    public static final RefinementGroupViewType GROUP;
    private int value;

    private RefinementGroupViewType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static int getCount()
    {
        return 2;
    }

    public static RefinementGroupViewType valueOf(String s)
    {
        return (RefinementGroupViewType)Enum.valueOf(com/amazon/retailsearch/android/ui/refinements/RefinementGroupViewType, s);
    }

    public static RefinementGroupViewType[] values()
    {
        return (RefinementGroupViewType[])$VALUES.clone();
    }

    public int getValue()
    {
        return value;
    }

    static 
    {
        GROUP = new RefinementGroupViewType("GROUP", 0, 0);
        FILTER_ITEM = new RefinementGroupViewType("FILTER_ITEM", 1, 1);
        $VALUES = (new RefinementGroupViewType[] {
            GROUP, FILTER_ITEM
        });
    }
}
