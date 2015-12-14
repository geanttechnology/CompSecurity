// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.library.model;


public final class TFilterMenuItemType extends Enum
{

    private static final TFilterMenuItemType $VALUES[];
    public static final TFilterMenuItemType TFilterCountType;
    public static final TFilterMenuItemType TFilterResType;
    public static final TFilterMenuItemType TFilterStyleType;

    private TFilterMenuItemType(String s, int i)
    {
        super(s, i);
    }

    public static TFilterMenuItemType valueOf(String s)
    {
        return (TFilterMenuItemType)Enum.valueOf(com/instamag/activity/library/model/TFilterMenuItemType, s);
    }

    public static TFilterMenuItemType[] values()
    {
        return (TFilterMenuItemType[])$VALUES.clone();
    }

    static 
    {
        TFilterResType = new TFilterMenuItemType("TFilterResType", 0);
        TFilterStyleType = new TFilterMenuItemType("TFilterStyleType", 1);
        TFilterCountType = new TFilterMenuItemType("TFilterCountType", 2);
        $VALUES = (new TFilterMenuItemType[] {
            TFilterResType, TFilterStyleType, TFilterCountType
        });
    }
}
