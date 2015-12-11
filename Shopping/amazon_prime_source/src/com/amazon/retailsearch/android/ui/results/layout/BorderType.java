// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;


public final class BorderType extends Enum
{

    private static final BorderType $VALUES[];
    public static final BorderType BOTTOM;
    public static final BorderType NONE;
    public static final BorderType RIGHT;
    private final int resourceId;

    private BorderType(String s, int i, int j)
    {
        super(s, i);
        resourceId = j;
    }

    public static BorderType valueOf(String s)
    {
        return (BorderType)Enum.valueOf(com/amazon/retailsearch/android/ui/results/layout/BorderType, s);
    }

    public static BorderType[] values()
    {
        return (BorderType[])$VALUES.clone();
    }

    public int getResourceId()
    {
        return resourceId;
    }

    static 
    {
        RIGHT = new BorderType("RIGHT", 0, com.amazon.retailsearch.R.drawable.rs_view_entry_border_right);
        BOTTOM = new BorderType("BOTTOM", 1, com.amazon.retailsearch.R.drawable.rs_view_entry_border_bottom);
        NONE = new BorderType("NONE", 2, 0);
        $VALUES = (new BorderType[] {
            RIGHT, BOTTOM, NONE
        });
    }
}
