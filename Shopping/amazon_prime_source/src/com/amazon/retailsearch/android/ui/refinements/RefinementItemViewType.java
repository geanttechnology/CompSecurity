// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;


public final class RefinementItemViewType extends Enum
{

    private static final RefinementItemViewType $VALUES[];
    public static final RefinementItemViewType DDS;
    public static final RefinementItemViewType GENERAL;
    private int value;

    private RefinementItemViewType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static int getCount()
    {
        return 2;
    }

    public static RefinementItemViewType valueOf(String s)
    {
        return (RefinementItemViewType)Enum.valueOf(com/amazon/retailsearch/android/ui/refinements/RefinementItemViewType, s);
    }

    public static RefinementItemViewType[] values()
    {
        return (RefinementItemViewType[])$VALUES.clone();
    }

    public int getValue()
    {
        return value;
    }

    static 
    {
        GENERAL = new RefinementItemViewType("GENERAL", 0, 0);
        DDS = new RefinementItemViewType("DDS", 1, 1);
        $VALUES = (new RefinementItemViewType[] {
            GENERAL, DDS
        });
    }
}
