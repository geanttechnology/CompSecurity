// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.page_item;


public final class d extends Enum
{

    private static final d $VALUES[];
    public static final d INSIDE;
    public static final d OUTSIDE;
    private final String mValue;

    private d(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/target/mothership/common/page_item/d, s);
    }

    public static d[] values()
    {
        return (d[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        INSIDE = new d("INSIDE", 0, "inside");
        OUTSIDE = new d("OUTSIDE", 1, "outside");
        $VALUES = (new d[] {
            INSIDE, OUTSIDE
        });
    }
}
